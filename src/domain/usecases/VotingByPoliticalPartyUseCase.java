package domain.usecases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domain.entity.PoliticalParty;
import domain.repository.ElectionRepository;

public class VotingByPoliticalPartyUseCase {
    ElectionRepository electionRepository;

    public VotingByPoliticalPartyUseCase(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public List<PoliticalParty> execute() {
        List<PoliticalParty> politicalParties = new ArrayList<>(electionRepository.getAllPoliticalParty());
        Collections.sort(politicalParties, new Comparator<PoliticalParty>() {
            @Override
            public int compare(PoliticalParty p1, PoliticalParty p2) {
                return p2.getTotalVotes() - p1.getTotalVotes();
            }
        });
        return politicalParties;
    }
}
