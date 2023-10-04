package presentation.terminal;

import domain.usecases.NumberOfElectedCandidatesUseCase;
import factory.usecases.NumberOfElectedCandidatesFactory;
import presentation.View;

public class NumberOfElectedCandidatesView implements View {
    NumberOfElectedCandidatesUseCase numberOfElectedCandidatesUseCase;

    public NumberOfElectedCandidatesView() {
        this.numberOfElectedCandidatesUseCase = new NumberOfElectedCandidatesFactory().create();
    }

    public void view() {
        int totalElectedCandidates = numberOfElectedCandidatesUseCase.execute();
        System.out.printf("Número de vagas: %d\n", totalElectedCandidates);
    }
}
