package adapters;

import java.util.HashSet;
import java.util.Set;

import domain.model.Candidate;
import repository.CandidateRepository;

public class InMemoryCandidateRepository implements CandidateRepository {
    @Override
    public Set<Candidate> getAllCandidates() {
        return new HashSet<>();
    }
}
