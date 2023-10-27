package domain.usecases;

import domain.repository.ElectionRepository;

public class NumberOfVacancies {

  ElectionRepository electionRepository;

  public NumberOfVacancies(ElectionRepository electionRepository) {
    this.electionRepository = electionRepository;
  }

  public int execute() {
    return electionRepository.getNumberOfElectedCandidates();
  }
}
