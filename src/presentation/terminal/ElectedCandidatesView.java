package presentation.terminal;

import config.AppConfig;
import domain.entity.Candidate;
import domain.usecases.ElectedCandidatesUseCase;
import presentation.View;
import presentation.helpers.ViewHelpers;

public class ElectedCandidatesView implements View {
    ElectedCandidatesUseCase electedCandidatesUseCase;

    public ElectedCandidatesView(ElectedCandidatesUseCase electedCandidatesUseCase) {
        this.electedCandidatesUseCase = electedCandidatesUseCase;
    }

    public void view() {
        System.out.printf("Deputados %s eleitos:\n", AppConfig.getElectionType());
        int position = 1;
        for (Candidate candidate : electedCandidatesUseCase.execute()) {
            System.out.printf("%d - %s (%s, %s votos)\n",
                    position, ViewHelpers.showCandidateName(candidate),
                    candidate.getPoliticalParty().getName(),
                    ViewHelpers.toInt(candidate.getTotalVotes()));
            position += 1;
        }
    }
}
