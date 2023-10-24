package adapters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import adapters.helpers.ReadFileOfCandidate;
import adapters.helpers.ReadFileOfVoting;
import adapters.helpers.ReadFileOfCandidate.FieldsFileOfCandidate;
import config.AppConfig;
import config.AppConfig.ElectionType;
import domain.entity.Candidate;
import domain.entity.PoliticalParty;
import domain.repository.ElectionRepository;

public class InMemoryElectionRepository implements ElectionRepository {
    private Map<String, Candidate> candidates = new HashMap<>();

    private Map<Integer, PoliticalParty> politicalParties = new HashMap<>();

    public InMemoryElectionRepository() {

        ReadFileOfCandidate fileOfCandidate = new ReadFileOfCandidate();

        while (fileOfCandidate.hasMore()) {
            FieldsFileOfCandidate fields = fileOfCandidate.next();
            String electionType = "6";
            if (AppConfig.electionType == ElectionType.STATE) {
                electionType = "7";
            }
            if (!fields.CD_CARGO.equals(electionType)) {
                continue;
            }

            PoliticalParty politicalParty = politicalParties.get(fields.NR_PARTIDO);

            if (politicalParty == null) {
                PoliticalParty p = new PoliticalParty(fields.NR_PARTIDO, fields.SG_PARTIDO);
                politicalParties.put(fields.NR_PARTIDO, p);
                politicalParty = p;
            }

            if (!fields.CD_SITUACAO_CANDIDATO_TOT.equals("16") && !fields.CD_SITUACAO_CANDIDATO_TOT.equals("2")) {
                continue;
            }

            boolean isElected = false;
            Candidate.Gender gender = Candidate.Gender.MALE;
            if (fields.CD_GENERO.equals("4")) {
                gender = Candidate.Gender.FEMALE;
            }
            if (fields.CD_SIT_TOT_TURNO.equals("2") || fields.CD_SIT_TOT_TURNO.equals("3")) {
                isElected = true;
            }

            Candidate candidate = new Candidate(
                    fields.NM_URNA_CANDIDATO,
                    politicalParty,
                    isElected,
                    gender,
                    fields.DT_NASCIMENTO);
            candidates.put(fields.NR_CANDIDATO, candidate);
        }

        fileOfCandidate.close();

        ReadFileOfVoting fileOfVoting = new ReadFileOfVoting();

        while (fileOfVoting.hasMore()) {
            // FieldsFileOfVoting fields = fileOfVoting.next();
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
