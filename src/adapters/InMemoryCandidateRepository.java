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
