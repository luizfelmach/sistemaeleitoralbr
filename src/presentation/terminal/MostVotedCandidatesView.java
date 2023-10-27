package presentation.terminal;

import domain.entity.Candidate;
import domain.usecases.MostVotedCandidates;
import presentation.View;
import presentation.helpers.ViewHelpers;

public class MostVotedCandidatesView implements View {

  MostVotedCandidates mostVotedCandidates;

  public MostVotedCandidatesView(MostVotedCandidates mostVotedCandidates) {
    this.mostVotedCandidates = mostVotedCandidates;
  }

  public void view() {
    System.out.println(
      "Candidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):"
    );
    for (Candidate candidate : mostVotedCandidates.execute()) {
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
