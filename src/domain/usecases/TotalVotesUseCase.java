package domain.usecases;

import java.util.Set;

import domain.entity.PoliticalParty;
import domain.repository.ElectionRepository;

public class TotalVotesUseCase {
    ElectionRepository electionRepository;

    public TotalVotesUseCase(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public Result execute() {
        Set<PoliticalParty> politicalParties = electionRepository.getAllPoliticalParty();
        int totalRollCallVotes = 0;
        int totalCaptionVotes = 0;
        for (PoliticalParty politicalParty : politicalParties) {
            totalRollCallVotes += politicalParty.getRollCallVotes();
            totalCaptionVotes += politicalParty.getCaptionVotes();
        }
        return new Result(totalRollCallVotes, totalCaptionVotes);
    }

    public class Result {
        public int totalRollCallVotes;
        public int totalCaptionVotes;

        public Result(int totalRollCallVotes, int totalCaptionVotes) {
            this.totalRollCallVotes = totalRollCallVotes;
            this.totalCaptionVotes = totalCaptionVotes;
        }
    }
}
