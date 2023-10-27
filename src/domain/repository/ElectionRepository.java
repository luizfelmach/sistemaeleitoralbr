package domain.repository;

import java.util.List;

import domain.entity.Candidate;
import domain.entity.PoliticalParty;

public interface ElectionRepository {
    public List<Candidate> getAllCandidates();

    public List<Candidate> getElectedCandidates();

    public int getNumberOfElectedCandidates();

    public List<PoliticalParty> getAllPoliticalParty();
}
