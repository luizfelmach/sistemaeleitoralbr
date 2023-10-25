package presentation.terminal;

import domain.entity.Candidate;
import domain.usecases.MostVotedCandidatesUseCase;
import presentation.View;
import presentation.helpers.ViewHelpers;

public class MostVotedCandidatesView implements View {
    MostVotedCandidatesUseCase mostVotedCandidatesUseCase;

    public MostVotedCandidatesView(MostVotedCandidatesUseCase mostVotedCandidatesUseCase) {
        this.mostVotedCandidatesUseCase = mostVotedCandidatesUseCase;
    }

    public void view() {
        System.out.println("Candidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):");
        for (Candidate candidate : mostVotedCandidatesUseCase.execute()) {
            System.out.printf("%d - %s (%s, %s %s)\n",
                    candidate.getRankingMostVoted(), ViewHelpers.showCandidateName(candidate),
                    candidate.getPoliticalParty().getName(),
                    ViewHelpers.toInt(candidate.getTotalVotes()),
                    ViewHelpers.getSlugVote(candidate.getTotalVotes()));
        }
    }
}
