package presentation;

import domain.usecases.NumberOfElectedCandidatesUseCase;

public class NumberOfElectedCandidatesView {
    NumberOfElectedCandidatesUseCase numberOfElectedCandidatesUseCase;

    public NumberOfElectedCandidatesView(NumberOfElectedCandidatesUseCase numberOfElectedCandidatesUseCase) {
        this.numberOfElectedCandidatesUseCase = numberOfElectedCandidatesUseCase;
    }

    public void handle() {
        int totalElectedCandidates = numberOfElectedCandidatesUseCase.execute();
        System.out.printf("Número de vagas: %d\n", totalElectedCandidates);
    }
}
