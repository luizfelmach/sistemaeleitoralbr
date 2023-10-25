package presentation.terminal;

import domain.entity.Candidate;
import domain.usecases.ElectedCandidatesBenefitedProportionalUseCase;
import presentation.View;
import presentation.helpers.ViewHelpers;

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
            System.out.printf("%d - %s (%s, %s %s)\n",
                    candidate.getRankingMostVoted(), ViewHelpers.showCandidateName(candidate),
                    candidate.getPoliticalParty().getName(),
                    ViewHelpers.toInt(candidate.getTotalVotes()),
                    ViewHelpers.getSlugVote(candidate.getTotalVotes()));
        }
    }
}
