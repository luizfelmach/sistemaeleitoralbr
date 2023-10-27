package domain.usecases;

import domain.entity.PoliticalParty;
import domain.repository.ElectionRepository;
import domain.util.ComparatorUseCase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VotesByPartyAndElectedCandidates {

  ElectionRepository electionRepository;

  public VotesByPartyAndElectedCandidates(
    ElectionRepository electionRepository
  ) {
    this.electionRepository = electionRepository;
  }

  public List<PoliticalParty> execute() {
    List<PoliticalParty> politicalParties = new ArrayList<>(
      electionRepository.getAllPoliticalParty()
    );
    Collections.sort(
      politicalParties,
      ComparatorUseCase.politicalPartyMostVoted
    );
    return politicalParties;
  }
}
