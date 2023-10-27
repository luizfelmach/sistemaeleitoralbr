package domain.usecases;

import domain.entity.Candidate;
import domain.repository.ElectionRepository;
import domain.util.ComparatorUseCase;
import java.util.Collections;
import java.util.List;

public class ElectedCandidates {

  ElectionRepository electionRepository;

  public ElectedCandidates(ElectionRepository electionRepository) {
    this.electionRepository = electionRepository;
  }

  public List<Candidate> execute() {
    List<Candidate> electedCandidates = electionRepository.getElectedCandidates();
    Collections.sort(electedCandidates, ComparatorUseCase.candidateMostVoted);
    return electedCandidates;
  }
}
