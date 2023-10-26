package presentation.terminal;

import domain.usecases.TotalVotesUseCase;
import presentation.View;
import presentation.helpers.ViewHelpers;

public class TotalVotesView implements View {
    TotalVotesUseCase totalVotesUseCase;

    public TotalVotesView(TotalVotesUseCase totalVotesUseCase) {
        this.totalVotesUseCase = totalVotesUseCase;
    }

    public void view() {
        TotalVotesUseCase.Result result = totalVotesUseCase.execute();
        float rollCallPercent = (float) result.totalRollCallVotes / (result.totalVotes + 1);
        float captionPercent = (float) result.totalCaptionVotes / (result.totalVotes + 1);
        System.out.printf("Total de votos válidos:\t\t%s\n", ViewHelpers.toInt(result.totalVotes));
        System.out.printf("Total de votos nominais:\t%s (%.2f%%)\n", ViewHelpers.toInt(result.totalRollCallVotes),
                rollCallPercent * 100);
        System.out.printf("Total de votos de legenda:\t%s (%.2f%%)\n", ViewHelpers.toInt(result.totalCaptionVotes),
                captionPercent * 100);
    }
}
