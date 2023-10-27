package presentation.terminal;

import domain.entity.Candidate;
import domain.usecases.CandidatesWouldBeElectedInMajority;
import presentation.View;
import presentation.helpers.ViewHelpers;

public class CandidatesWouldBeElectedInMajorityView implements View {

  CandidatesWouldBeElectedInMajority candidatesWouldBeElectedInMajority;

  public CandidatesWouldBeElectedInMajorityView(
    CandidatesWouldBeElectedInMajority candidatesWouldBeElectedInMajority
  ) {
    this.candidatesWouldBeElectedInMajority =
      candidatesWouldBeElectedInMajority;
  }

  @Override
  public void view() {
    System.out.println(
      "Teriam sido eleitos se a votação fosse majoritária, e não foram eleitos:"
    );
    System.out.println("(com sua posição no ranking de mais votados)");
    for (Candidate candidate : candidatesWouldBeElectedInMajority.execute()) {
      System.out.printf(
        "%d - %s (%s, %s %s)\n",
        candidate.getRankingMostVoted(),
        ViewHelpers.showCandidateName(candidate),
        candidate.getPoliticalParty().getName(),
        ViewHelpers.toInt(candidate.getTotalVotes()),
        ViewHelpers.getSlugVote(candidate.getTotalVotes())
      );
    }
  }
}
