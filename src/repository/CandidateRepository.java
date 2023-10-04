package repository;

import java.util.Set;

import domain.entity.Candidate;

public interface CandidateRepository {
    public Set<Candidate> getAllCandidates();
}
