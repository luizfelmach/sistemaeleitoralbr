package domain.repository;

import java.util.List;
import java.util.Set;

import domain.entity.Candidate;
import domain.entity.PoliticalParty;

public interface ElectionRepository {
    public Set<Candidate> getAllCandidates();

    public Set<Candidate> getElectedCandidates();

    public int getNumberOfElectedCandidates();

    public List<Candidate> getMostVotedCandidates();

    public Set<PoliticalParty> getAllPoliticalParty();
}
