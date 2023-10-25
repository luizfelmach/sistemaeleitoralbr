package presentation.terminal;

import domain.entity.Candidate;
import domain.usecases.ElectedCandidatesBenefitedProportionalUseCase;
import presentation.View;

public class ElectedCandidatesBenefitedProportionalView implements View {
    ElectedCandidatesBenefitedProportionalUseCase electedCandidatesBenefitedProportionalUseCase;

    public ElectedCandidatesBenefitedProportionalView(
            ElectedCandidatesBenefitedProportionalUseCase electedCandidatesBenefitedProportionalUseCase) {
        this.electedCandidatesBenefitedProportionalUseCase = electedCandidatesBenefitedProportionalUseCase;
    }

    @Override
    public void view() {
        System.out.println("Eleitos, que se beneficiaram do sistema proporcional:");
        System.out.println("(com sua posição no ranking de mais votados)");
        for (Candidate candidate : electedCandidatesBenefitedProportionalUseCase.execute()) {
            System.out.printf("%d - %s (%s, %d votos)\n",
                    candidate.getRankingMostVoted(), candidate.getName(),
                    candidate.getPoliticalParty().getName(),
                    candidate.getTotalVotes());
        }
    }
}
