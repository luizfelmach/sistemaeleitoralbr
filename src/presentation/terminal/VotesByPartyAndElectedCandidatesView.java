package presentation.terminal;

import domain.entity.PoliticalParty;
import domain.usecases.VotesByPartyAndElectedCandidates;
import java.util.List;
import presentation.View;
import presentation.helpers.ViewHelpers;

public class VotesByPartyAndElectedCandidatesView implements View {

  VotesByPartyAndElectedCandidates votesByPartyAndElectedCandidates;

  public VotesByPartyAndElectedCandidatesView(
    VotesByPartyAndElectedCandidates votesByPartyAndElectedCandidates
  ) {
    this.votesByPartyAndElectedCandidates = votesByPartyAndElectedCandidates;
  }

  @Override
  public void view() {
    List<PoliticalParty> politicalParties = votesByPartyAndElectedCandidates.execute();
    System.out.println("Votação dos partidos e número de candidatos eleitos:");
    int i = 1;
    for (PoliticalParty politicalParty : politicalParties) {
      System.out.printf(
        "%d - %s - %d, %s %s (%s %s e %s de legenda), %s %s\n",
        i,
        politicalParty.getName(),
        politicalParty.getNumber(),
        ViewHelpers.toInt(politicalParty.getTotalVotes()),
        ViewHelpers.getSlugVote(politicalParty.getTotalVotes()),
        ViewHelpers.toInt(politicalParty.getRollCallVotes()),
        politicalParty.getRollCallVotes() <= 1 ? "nominal" : "nominais",
        ViewHelpers.toInt(politicalParty.getCaptionVotes()),
        politicalParty.getElectedCandidatesSize(),
        politicalParty.getElectedCandidatesSize() <= 1
          ? "candidato eleito"
          : "candidatos eleitos"
      );
      i += 1;
    }
  }
}
