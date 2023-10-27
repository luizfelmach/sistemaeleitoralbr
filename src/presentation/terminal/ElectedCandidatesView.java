package presentation.terminal;

import domain.entity.Candidate;
import domain.usecases.ElectedCandidates;
import presentation.View;
import presentation.helpers.ViewHelpers;

public class ElectedCandidatesView implements View {

  ElectedCandidates electedCandidates;

  public ElectedCandidatesView(ElectedCandidates electedCandidates) {
    this.electedCandidates = electedCandidates;
  }

  public void view() {
    System.out.printf("Deputados %s eleitos:\n", ViewHelpers.getElectionType());
    int position = 1;
    for (Candidate candidate : electedCandidates.execute()) {
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
