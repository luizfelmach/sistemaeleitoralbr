package presentation.terminal;

import domain.entity.Candidate;
import domain.usecases.ElectedCandidatesUseCase;
import factory.usecases.ElectedCandidatesFactory;
import presentation.View;

public class ElectedCandidatesView implements View {
    ElectedCandidatesUseCase electedCandidatesUseCase;

    public ElectedCandidatesView() {
        this.electedCandidatesUseCase = new ElectedCandidatesFactory().create();
    }

    public void view() {
        System.out.println("Deputados xxx eleitos:");
        int position = 1;
        for (Candidate candidate : electedCandidatesUseCase.execute()) {
            System.out.printf("%d - %s (%s, %d votos)\n",
                    position, candidate.getName(),
                    candidate.getPoliticalParty(),
                    candidate.getTotalVotes());
        }
    }
}
