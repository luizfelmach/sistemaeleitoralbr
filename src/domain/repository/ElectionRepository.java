package domain.repository;

import java.util.List;
import java.util.Set;

import domain.entity.Candidate;

public interface ElectionRepository {
    public Set<Candidate> getAllCandidates();

    public Set<Candidate> getElectedCandidates();

    public int getNumberOfElectedCandidates();

    public List<Candidate> getMostVotedCandidates();
}
