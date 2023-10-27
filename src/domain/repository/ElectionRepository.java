package domain.repository;

import domain.entity.Candidate;
import domain.entity.PoliticalParty;
import java.util.List;

public interface ElectionRepository {
  public List<Candidate> getAllCandidates();

  public List<Candidate> getElectedCandidates();

  public int getNumberOfElectedCandidates();

  public List<PoliticalParty> getAllPoliticalParty();
}
