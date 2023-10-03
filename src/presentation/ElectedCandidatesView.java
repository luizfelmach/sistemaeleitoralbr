package presentation;

import domain.usecases.ElectedCandidates;

public class ElectedCandidatesView {
    ElectedCandidates electedCandidates;

    ElectedCandidatesView(ElectedCandidates electedCandidates) {
        this.electedCandidates = electedCandidates;
    }

    public void handle() {
        int totalElectedCandidates = electedCandidates.execute();
        System.out.printf("Número de vagas: %d\n", totalElectedCandidates);
    }
}
