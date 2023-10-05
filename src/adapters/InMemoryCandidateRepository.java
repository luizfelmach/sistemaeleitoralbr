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
    private Set<Candidate> candidates;

    public InMemoryCandidateRepository() {
        candidates.add(new Candidate("Lula", "PT", 10, true));
        candidates.add(new Candidate("Fulano", "PSOl", 200, true));
        candidates.add(new Candidate("John Doe", "REPUBLICANOS", 100, true));
        candidates.add(new Candidate("Sicrano", "PTB", 40, true));
        candidates.add(new Candidate("Bolsonaro", "Novo", 90, true));

        candidates.add(new Candidate("MARCELO SANTOS", "PODE", 5, false));
        candidates.add(new Candidate("BRUNO SILVA", "PT", 250, false));

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
                return c1.getTotalVotes() - c2.getTotalVotes();
            }
        });
        return allCandidates;
    }
}
