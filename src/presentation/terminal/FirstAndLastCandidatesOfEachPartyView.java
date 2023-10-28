package presentation.terminal;

import domain.entity.Candidate;
import domain.entity.PoliticalParty;
import domain.usecases.FirstAndLastCandidatesOfEachParty;
import java.util.List;
import presentation.View;
import presentation.helpers.ViewHelpers;

public class FirstAndLastCandidatesOfEachPartyView implements View {

  FirstAndLastCandidatesOfEachParty firstAndLastCandidatesOfEachParty;

  public FirstAndLastCandidatesOfEachPartyView(
    FirstAndLastCandidatesOfEachParty firstAndLastCandidatesOfEachParty
  ) {
    this.firstAndLastCandidatesOfEachParty = firstAndLastCandidatesOfEachParty;
  }

  @Override
  public void view() {
    List<PoliticalParty> result = firstAndLastCandidatesOfEachParty.execute();
    System.out.println("Primeiro e último colocados de cada partido:");
    int i = 1;
    for (PoliticalParty politicalParty : result) {
      System.out.printf(
        "%d - %s - %d, %s / %s\n",
        i,
        politicalParty.getName(),
        politicalParty.getNumber(),
        showCandidate(politicalParty.getMostVoted()),
        showCandidate(politicalParty.getLeastVoted())
      );
      i += 1;
    }
  }

  private String showCandidate(Candidate candidate) {
    return String.format(
      "%s (%d, %s %s)",
      candidate.getName(),
      candidate.getNumber(),
      ViewHelpers.toInt(candidate.getTotalVotes()),
      ViewHelpers.getSlugVote(candidate.getTotalVotes())
    );
  }
}
