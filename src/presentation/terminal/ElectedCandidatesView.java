package presentation.terminal;

import domain.entity.Candidate;
import domain.usecases.ElectedCandidatesUseCase;
import presentation.View;
import presentation.helpers.ViewHelpers;

public class ElectedCandidatesView implements View {

  ElectedCandidatesUseCase electedCandidatesUseCase;

  public ElectedCandidatesView(
    ElectedCandidatesUseCase electedCandidatesUseCase
  ) {
    this.electedCandidatesUseCase = electedCandidatesUseCase;
  }

  public void view() {
    System.out.printf("Deputados %s eleitos:\n", ViewHelpers.getElectionType());
    int position = 1;
    for (Candidate candidate : electedCandidatesUseCase.execute()) {
      System.out.printf(
        "%d - %s (%s, %s %s)\n",
        position,
        ViewHelpers.showCandidateName(candidate),
        candidate.getPoliticalParty().getName(),
        ViewHelpers.toInt(candidate.getTotalVotes()),
        ViewHelpers.getSlugVote(candidate.getTotalVotes())
      );
      position += 1;
    }
  }
}
