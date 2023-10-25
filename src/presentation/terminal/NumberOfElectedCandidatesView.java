package presentation.terminal;

import domain.usecases.NumberOfElectedCandidatesUseCase;
import presentation.View;

public class NumberOfElectedCandidatesView implements View {
    NumberOfElectedCandidatesUseCase numberOfElectedCandidatesUseCase;

    public NumberOfElectedCandidatesView(NumberOfElectedCandidatesUseCase numberOfElectedCandidatesUseCase) {
        this.numberOfElectedCandidatesUseCase = numberOfElectedCandidatesUseCase;
    }

    public void view() {
        int totalElectedCandidates = numberOfElectedCandidatesUseCase.execute();
        System.out.printf("Número de vagas: %d\n", totalElectedCandidates);
    }
}
