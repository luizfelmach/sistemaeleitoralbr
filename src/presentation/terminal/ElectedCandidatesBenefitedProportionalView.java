package presentation.terminal;

import domain.entity.Candidate;
import domain.usecases.ElectedCandidatesBenefitedProportionalUseCase;
import factory.usecases.ElectedCandidatesBenefitedProportionalFactory;
import presentation.View;

public class ElectedCandidatesBenefitedProportionalView implements View {
    ElectedCandidatesBenefitedProportionalUseCase electedCandidatesBenefitedProportionalUseCase;

    public ElectedCandidatesBenefitedProportionalView() {
        this.electedCandidatesBenefitedProportionalUseCase = new ElectedCandidatesBenefitedProportionalFactory()
                .create();
    }

    @Override
    public void view() {
        System.out.println("Eleitos, que se beneficiaram do sistema proporcional:");
        int position = 1;
        for (Candidate candidate : electedCandidatesBenefitedProportionalUseCase.execute()) {
            System.out.printf("%d - %s (%s, %d votos)\n",
                    position, candidate.getName(),
                    candidate.getPoliticalParty(),
                    candidate.getTotalVotes());
            position += 1;
        }
    }

}
