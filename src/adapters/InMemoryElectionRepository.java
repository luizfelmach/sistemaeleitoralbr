package adapters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import adapters.helpers.ElectionHelpers;
import adapters.helpers.ReadFileOfCandidate;
import adapters.helpers.ReadFileOfVoting;
import adapters.helpers.ReadFileOfCandidate.FieldsFileOfCandidate;
import adapters.helpers.ReadFileOfVoting.FieldsFileOfVoting;
import domain.entity.Candidate;
import domain.entity.PoliticalParty;
import domain.repository.ElectionRepository;

public class InMemoryElectionRepository implements ElectionRepository {
    private Map<Integer, Candidate> candidates = new HashMap<>();
    private Map<Integer, PoliticalParty> politicalParties = new HashMap<>();

    public InMemoryElectionRepository() {
        setupCandidates();
        setupPoliticalParties();
    }

    private void setupCandidates() {
        ReadFileOfCandidate fileOfCandidate = new ReadFileOfCandidate();
        while (fileOfCandidate.hasMore()) {
            FieldsFileOfCandidate fields = fileOfCandidate.next();
            if (ElectionHelpers.isCandidatePositionInvalid(fields.CD_CARGO)) {
                continue;
            }
            PoliticalParty politicalParty = politicalParties.get(fields.NR_PARTIDO);
            if (politicalParty == null) {
                PoliticalParty p = new PoliticalParty(fields.NR_PARTIDO, fields.SG_PARTIDO);
                politicalParties.put(fields.NR_PARTIDO, p);
                politicalParty = p;
            }
            if (ElectionHelpers.isToSkipCandidate(fields.CD_SITUACAO_CANDIDATO_TOT)) {
                continue;
            }
            Candidate.Gender gender = ElectionHelpers.getCandidatGender(fields.CD_GENERO);
            boolean isElected = ElectionHelpers.isCandidateElected(fields.CD_SIT_TOT_TURNO);
            Candidate candidate = new Candidate(
                    fields.NM_URNA_CANDIDATO,
                    politicalParty,
                    isElected,
                    gender,
                    fields.DT_NASCIMENTO,
                    fields.NR_FEDERACAO);
            candidates.put(fields.NR_CANDIDATO, candidate);
        }
        fileOfCandidate.close();
    }

    private void setupPoliticalParties() {
        ReadFileOfVoting fileOfVoting = new ReadFileOfVoting();
        while (fileOfVoting.hasMore()) {
            FieldsFileOfVoting fields = fileOfVoting.next();
            if (ElectionHelpers.isCandidatePositionInvalid(fields.CD_CARGO)) {
                continue;
            }
            if (ElectionHelpers.isInvalidVote(fields.NR_VOTAVEL)) {
                continue;
            }
            Candidate candidate = candidates.get(fields.NR_VOTAVEL);
            if (candidate != null) {
                candidate.addVotes(fields.QT_VOTOS);
            } else {
                // PoliticalParty politicalParty = politicalParties.get(fields.NR_VOTAVEL);
                // politicalParty.addCaptionVote(fields.QT_VOTOS);
            }
        }
        fileOfVoting.close();
    }

    @Override
    public Set<Candidate> getAllCandidates() {
        return new HashSet<>(candidates.values());
    }

    @Override
    public Set<Candidate> getElectedCandidates() {
        Set<Candidate> electedCandidates = new HashSet<>();
        for (Candidate candidate : candidates.values()) {
            if (candidate.isElected()) {
                electedCandidates.add(candidate);
            }
        }
        return electedCandidates;
    }

    @Override
    public int getNumberOfElectedCandidates() {
        return getElectedCandidates().size();
    }

    @Override
    public List<Candidate> getMostVotedCandidates() {
        List<Candidate> allCandidates = new ArrayList<>(candidates.values());
        Collections.sort(allCandidates, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate c1, Candidate c2) {
                return c2.getTotalVotes() - c1.getTotalVotes();
            }
        });
        int position = 1;
        for (Candidate candidate : allCandidates) {
            candidate.setRankingMostVoted(position);
            position += 1;
        }
        return allCandidates;
    }

    @Override
    public Set<PoliticalParty> getAllPoliticalParty() {
        return new HashSet<>(politicalParties.values());
    }
}
