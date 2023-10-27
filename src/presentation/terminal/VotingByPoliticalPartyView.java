package presentation.terminal;

import java.util.List;

import domain.entity.PoliticalParty;
import domain.usecases.VotingByPoliticalPartyUseCase;
import presentation.View;
import presentation.helpers.ViewHelpers;

public class VotingByPoliticalPartyView implements View {
    VotingByPoliticalPartyUseCase votingByPoliticalPartyUseCase;

    public VotingByPoliticalPartyView(VotingByPoliticalPartyUseCase votingByPoliticalPartyUseCase) {
        this.votingByPoliticalPartyUseCase = votingByPoliticalPartyUseCase;
    }

    @Override
    public void view() {
        List<PoliticalParty> politicalParties = votingByPoliticalPartyUseCase.execute();
        System.out.println("Primeiro e último colocados de cada partido:");
        int i = 1;
        for (PoliticalParty politicalParty : politicalParties) {
            System.out.printf("%d - %s - %d, %s %s (%s %s e %s de legenda), %s %s\n",
                    i, politicalParty.getName(),
                    politicalParty.getPoliticalPartyNumber(),
                    ViewHelpers.toInt(politicalParty.getTotalVotes()),
                    ViewHelpers.getSlugVote(politicalParty.getTotalVotes()),
                    ViewHelpers.toInt(politicalParty.getRollCallVotes()),
                    politicalParty.getRollCallVotes() <= 1 ? "nominal" : "nominais",
                    politicalParty.getCaptionVotes(),
                    politicalParty.getCandidates().size(),
                    politicalParty.getCandidates().size() <= 1 ? "candidato eleito" : "candidatos eleitos");
            i += 1;
        }
    }
}
