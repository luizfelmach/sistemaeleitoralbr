package adapters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.entity.Candidate;
import domain.repository.CandidateRepository;

public class InMemoryCandidateRepository implements CandidateRepository {
    private Set<Candidate> candidates = new HashSet<>();

    public InMemoryCandidateRepository() {
        candidates.add(new Candidate("Lula", "PT", 11, true));
        candidates.add(new Candidate("Fulano", "PSOl", 200, true));
        candidates.add(new Candidate("John Doe", "REPUBLICANOS", 100, true));
        candidates.add(new Candidate("Sicrano", "PTB", 40, true));
        candidates.add(new Candidate("Bolsonaro", "Novo", 90, true));
        candidates.add(new Candidate("MARCELO SANTOS", "PODE", 5, false));
        candidates.add(new Candidate("BRUNO SILVA", "PT", 250, false));
        candidates.add(new Candidate("PEDRO SILVA", "PT", 25, false));
        candidates.add(new Candidate("JOAO SILVA", "PT", 10, false));
        candidates.add(new Candidate("MARIA SILVA", "PT", 30, false));
    }

    @Override
    public Set<Candidate> getAllCandidates() {
        return new HashSet<>(candidates);
    }

    @Override
    public Set<Candidate> getElectedCandidates() {
        Set<Candidate> electedCandidates = new HashSet<>();
        for (Candidate candidate : candidates) {
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
        List<Candidate> allCandidates = new ArrayList<>(candidates);
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
}
