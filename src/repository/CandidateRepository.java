package repository;

import java.util.Set;
import domain.model.Candidate;

public interface CandidateRepository {
    public Set<Candidate> getAllCandidates();
}
