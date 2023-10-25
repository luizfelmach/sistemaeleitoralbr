package presentation.terminal;

import domain.entity.Candidate;
import domain.usecases.ElectedCandidatesIfWasMajorityUseCase;
import presentation.View;
import presentation.helpers.ViewHelpers;

public class ElectedCandidatesIfWasMajorityView implements View {
    ElectedCandidatesIfWasMajorityUseCase electedCandidatesIfWasMajorityUseCase;

    public ElectedCandidatesIfWasMajorityView(
            ElectedCandidatesIfWasMajorityUseCase electedCandidatesIfWasMajorityUseCase) {
        this.electedCandidatesIfWasMajorityUseCase = electedCandidatesIfWasMajorityUseCase;
    }

    @Override
    public void view() {
        System.out.println("Teriam sido eleitos se a votação fosse majoritária, e não foram eleitos:");
        System.out.println("(com sua posição no ranking de mais votados)");
        for (Candidate candidate : electedCandidatesIfWasMajorityUseCase.execute()) {
            System.out.printf("%d - %s (%s, %s %s)\n",
                    candidate.getRankingMostVoted(), ViewHelpers.showCandidateName(candidate),
                    candidate.getPoliticalParty().getName(),
                    ViewHelpers.toInt(candidate.getTotalVotes()),
                    ViewHelpers.getSlugVote(candidate.getTotalVotes()));
        }
    }

}
