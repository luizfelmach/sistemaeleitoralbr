package domain.usecases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.entity.PoliticalParty;
import domain.repository.ElectionRepository;
import domain.util.ComparatorUseCase;

public class VotingByPoliticalPartyUseCase {
    ElectionRepository electionRepository;

    public VotingByPoliticalPartyUseCase(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public List<PoliticalParty> execute() {
        List<PoliticalParty> politicalParties = new ArrayList<>(electionRepository.getAllPoliticalParty());
        Collections.sort(politicalParties, ComparatorUseCase.politicalPartyMostVoted);
        return politicalParties;
    }
}
