package presentation.terminal;

import domain.usecases.TotalVotes;
import presentation.View;
import presentation.helpers.ViewHelpers;

public class TotalVotesView implements View {

  TotalVotes totalVotes;

  public TotalVotesView(TotalVotes totalVotes) {
    this.totalVotes = totalVotes;
  }

  public void view() {
    TotalVotes.Result result = totalVotes.execute();
    float rollCallPercent = (float) result.totalRollCallVotes /
    (result.totalVotes + 1);
    float captionPercent = (float) result.totalCaptionVotes /
    (result.totalVotes + 1);
    System.out.printf(
      "Total de votos válidos:    %s\n",
      ViewHelpers.toInt(result.totalVotes)
    );
    System.out.printf(
      "Total de votos nominais:   %s (%.2f%%)\n",
      ViewHelpers.toInt(result.totalRollCallVotes),
      rollCallPercent * 100
    );
    System.out.printf(
      "Total de votos de legenda: %s (%.2f%%)\n",
      ViewHelpers.toInt(result.totalCaptionVotes),
      captionPercent * 100
    );
  }
}
