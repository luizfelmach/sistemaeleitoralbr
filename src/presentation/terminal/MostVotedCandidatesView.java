package presentation.terminal;

import domain.entity.Candidate;
import domain.usecases.MostVotedCandidatesUseCase;
import factory.usecases.MostVotedCandidatesFactory;
import presentation.View;

public class MostVotedCandidatesView implements View {
    MostVotedCandidatesUseCase mostVotedCandidatesUseCase;

    public MostVotedCandidatesView() {
        this.mostVotedCandidatesUseCase = new MostVotedCandidatesFactory().create();
    }

    public void view() {
        System.out.println("Candidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):");
        for (Candidate candidate : mostVotedCandidatesUseCase.execute()) {
            System.out.printf("%d - %s (%s, %d votos)\n",
                    candidate.getRankingMostVoted(), candidate.getName(),
                    candidate.getPoliticalParty(),
                    candidate.getTotalVotes());
        }
    }
}
