package adapters;

import java.util.HashSet;
import java.util.Set;

import domain.entity.Candidate;
import domain.repository.CandidateRepository;

public class InMemoryCandidateRepository implements CandidateRepository {
    @Override
    public Set<Candidate> getAllCandidates() {
        return new HashSet<>();
    }

    @Override
    public Set<Candidate> getElectedCandidates() {
        return new HashSet<>();
    }

    @Override
    public int getNumberOfElectedCandidates() {
        return 0;
    }
}
