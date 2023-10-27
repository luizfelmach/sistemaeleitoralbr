package presentation.terminal;

import java.util.List;

import domain.entity.Candidate;
import domain.entity.PoliticalParty;
import domain.usecases.FirstAndLastByPoliticalPartyUseCase;
import presentation.View;
import presentation.helpers.ViewHelpers;

public class FirstAndLastByPoliticalPartyView implements View {
    FirstAndLastByPoliticalPartyUseCase firstAndLastByPoliticalPartyUseCase;

    public FirstAndLastByPoliticalPartyView(FirstAndLastByPoliticalPartyUseCase firstAndLastByPoliticalPartyUseCase) {
        this.firstAndLastByPoliticalPartyUseCase = firstAndLastByPoliticalPartyUseCase;
    }

    @Override
    public void view() {
        List<PoliticalParty> result = firstAndLastByPoliticalPartyUseCase.execute();
        int i = 1;
        for (PoliticalParty politicalParty : result) {
            System.out.printf("%d - %s - %d, %s / %s\n",
                    i, politicalParty.getName(),
                    politicalParty.getPoliticalPartyNumber(),
                    showCandidate(politicalParty.getMostVoted()),
                    showCandidate(politicalParty.getLeastVoted()));
            i += 1;
        }
    }

    public String showCandidate(Candidate candidate) {
        return String.format("%s (%d, %s %s)",
                candidate.getName(),
                candidate.getNumber(),
                ViewHelpers.toInt(candidate.getTotalVotes()),
                ViewHelpers.getSlugVote(candidate.getTotalVotes()));
    }
}
