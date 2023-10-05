package presentation.terminal;

import domain.usecases.TotalVotesUseCase;
import factory.usecases.TotalVotesFactory;
import presentation.View;

public class TotalVotesView implements View {
    TotalVotesUseCase totalVotesUseCase;

    public TotalVotesView() {
        this.totalVotesUseCase = new TotalVotesFactory().create();
    }

    public void view() {
        TotalVotesUseCase.Result result = totalVotesUseCase.execute();
        float rollCallPercent = (float) result.totalRollCallVotes / (result.totalVotes + 1);
        float captionPercent = (float) result.totalCaptionVotes / (result.totalVotes + 1);
        System.out.printf("Total de votos válidos:\t\t%d\n", result.totalVotes);
        System.out.printf("Total de votos nominais:\t%d (%.2f%%)\n", result.totalRollCallVotes, rollCallPercent);
        System.out.printf("Total de votos de legenda:\t%d (%.2f%%)\n", result.totalRollCallVotes, captionPercent);
    }
}
