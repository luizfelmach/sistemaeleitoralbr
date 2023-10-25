package presentation.terminal;

import java.text.NumberFormat;
import java.util.Locale;

import config.AppConfig;
import domain.entity.Candidate;
import domain.usecases.ElectedCandidatesUseCase;
import presentation.View;

public class ElectedCandidatesView implements View {
    ElectedCandidatesUseCase electedCandidatesUseCase;

    public ElectedCandidatesView(ElectedCandidatesUseCase electedCandidatesUseCase) {
        this.electedCandidatesUseCase = electedCandidatesUseCase;
    }

    public void view() {
        System.out.printf("Deputados %s eleitos:\n", AppConfig.getElectionType());
        NumberFormat formatter = NumberFormat.getInstance(Locale.of("pt", "BR"));
        int position = 1;
        for (Candidate candidate : electedCandidatesUseCase.execute()) {
            String withoutFederation = "*";
            if (candidate.getFederationNumber() == -1) {
                withoutFederation = "";
            }
            System.out.printf("%d - %s%s (%s, %s votos)\n",
                    position, withoutFederation, candidate.getName(),
                    candidate.getPoliticalParty().getName(),
                    formatter.format(candidate.getTotalVotes()));
            position += 1;
        }
    }
}
