package presentation;

import domain.entity.Candidate;
import domain.usecases.ElectedCandidatesUseCase;

public class ElectedCandidatesView {
    ElectedCandidatesUseCase electedCandidatesUseCase;

    public ElectedCandidatesView(ElectedCandidatesUseCase electedCandidatesUseCase) {
        this.electedCandidatesUseCase = electedCandidatesUseCase;
    }

    public void handle() {
        System.out.println("Deputados xxx eleitos:");
        int position = 1;
        for (Candidate candidate : electedCandidatesUseCase.execute()) {
            System.out.printf("%d - %s (%s, %d votos)\n", position, candidate.getName(), candidate.getPoliticalParty(),
                    candidate.getTotalVotes());
        }
    }
}
