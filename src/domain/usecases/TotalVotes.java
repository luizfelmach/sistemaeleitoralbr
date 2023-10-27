package domain.usecases;

import domain.entity.PoliticalParty;
import domain.repository.ElectionRepository;
import java.util.List;

public class TotalVotes {

  ElectionRepository electionRepository;

  public TotalVotes(ElectionRepository electionRepository) {
    this.electionRepository = electionRepository;
  }

  public Result execute() {
    List<PoliticalParty> politicalParties = electionRepository.getAllPoliticalParty();
    int totalRollCallVotes = 0;
    int totalCaptionVotes = 0;
    for (PoliticalParty politicalParty : politicalParties) {
      totalRollCallVotes += politicalParty.getRollCallVotes();
      totalCaptionVotes += politicalParty.getCaptionVotes();
    }
    return new Result(
      totalRollCallVotes,
      totalCaptionVotes,
      totalRollCallVotes + totalCaptionVotes
    );
  }

  public class Result {

    public int totalRollCallVotes;
    public int totalCaptionVotes;
    public int totalVotes;

    public Result(
      int totalRollCallVotes,
      int totalCaptionVotes,
      int totalVotes
    ) {
      this.totalRollCallVotes = totalRollCallVotes;
      this.totalCaptionVotes = totalCaptionVotes;
      this.totalVotes = totalVotes;
    }
  }
}
