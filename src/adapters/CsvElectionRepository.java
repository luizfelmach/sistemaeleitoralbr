package adapters;

import adapters.helpers.ElectionHelpers;
import adapters.helpers.ReadFileOfCandidate;
import adapters.helpers.ReadFileOfCandidate.FieldsFileOfCandidate;
import adapters.helpers.ReadFileOfVoting;
import adapters.helpers.ReadFileOfVoting.FieldsFileOfVoting;
import domain.entity.Candidate;
import domain.entity.PoliticalParty;
import domain.repository.ElectionRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvElectionRepository implements ElectionRepository {

  private Map<Integer, Candidate> candidates = new HashMap<>();
  private Map<Integer, Candidate> captionCandidates = new HashMap<>();
  private Map<Integer, Candidate> rejectedCandidates = new HashMap<>();
  private Map<Integer, PoliticalParty> politicalParties = new HashMap<>();

  public CsvElectionRepository() {
    setupCandidates();
    setupPoliticalParties();
  }

  private void setupCandidates() {
    ReadFileOfCandidate fileOfCandidate = new ReadFileOfCandidate();
    while (fileOfCandidate.hasMore()) {
      FieldsFileOfCandidate fields = fileOfCandidate.next();
      int NR_PARTIDO = fields.NR_PARTIDO;
      int NR_CANDIDATO = fields.NR_CANDIDATO;
      int CD_CARGO = fields.CD_CARGO;
      String SG_PARTIDO = fields.SG_PARTIDO;

      PoliticalParty politicalParty = politicalParties.get(NR_PARTIDO);
      if (politicalParty == null) {
        PoliticalParty p = new PoliticalParty(NR_PARTIDO, SG_PARTIDO);
        politicalParties.put(NR_PARTIDO, p);
        politicalParty = p;
      }
      if (ElectionHelpers.isCandidatePositionInvalid(CD_CARGO)) {
        continue;
      }

      Candidate.Gender gender = ElectionHelpers.getCandidatGender(
        fields.CD_GENERO
      );
      boolean isElected = ElectionHelpers.isCandidateElected(
        fields.CD_SIT_TOT_TURNO
      );

      Candidate candidate = new Candidate(
        fields.NM_URNA_CANDIDATO,
        NR_CANDIDATO,
        politicalParty,
        isElected,
        gender,
        fields.DT_NASCIMENTO,
        fields.NR_FEDERACAO
      );

      if (ElectionHelpers.destCaptionVote(fields.NM_TIPO_DESTINACAO_VOTOS)) {
        captionCandidates.put(NR_CANDIDATO, candidate);
        candidate.setCaptionCandidate(true);
      } else if (
        ElectionHelpers.isCandidateRejected(fields.CD_SITUACAO_CANDIDATO_TOT)
      ) {
        rejectedCandidates.put(NR_CANDIDATO, candidate);
        candidate.setRejected(true);
      } else {
        candidates.put(NR_CANDIDATO, candidate);
      }
    }
    fileOfCandidate.close();
  }

  private void setupPoliticalParties() {
    ReadFileOfVoting fileOfVoting = new ReadFileOfVoting();
    while (fileOfVoting.hasMore()) {
      FieldsFileOfVoting fields = fileOfVoting.next();
      int CD_CARGO = fields.CD_CARGO;
      int NR_NOTAVEL = fields.NR_VOTAVEL;
      int QT_VOTOS = fields.QT_VOTOS;
      if (ElectionHelpers.isValidVote(CD_CARGO, NR_NOTAVEL)) {
        if (candidates.containsKey(NR_NOTAVEL)) {
          candidates.get(NR_NOTAVEL).addVotes(QT_VOTOS);
        } else if (captionCandidates.containsKey(NR_NOTAVEL)) {
          captionCandidates
            .get(NR_NOTAVEL)
            .getPoliticalParty()
            .addCaptionVote(QT_VOTOS);
        } else if (politicalParties.containsKey(NR_NOTAVEL)) {
          politicalParties.get(fields.NR_VOTAVEL).addCaptionVote(QT_VOTOS);
        }
      }
    }
    fileOfVoting.close();
  }

  @Override
  public List<Candidate> getAllCandidates() {
    return new ArrayList<>(candidates.values());
  }

  @Override
  public List<Candidate> getElectedCandidates() {
    return candidates
      .values()
      .stream()
      .filter(c -> c.isElected())
      .collect(Collectors.toList());
  }

  @Override
  public int getNumberOfElectedCandidates() {
    return getElectedCandidates().size();
  }

  @Override
  public List<PoliticalParty> getAllPoliticalParty() {
    return new ArrayList<>(politicalParties.values());
  }
}
