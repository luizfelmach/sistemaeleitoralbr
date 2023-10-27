package domain.usecases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import domain.entity.PoliticalParty;
import domain.repository.ElectionRepository;
import domain.util.ComparatorUseCase;

public class FirstAndLastByPoliticalPartyUseCase {
    ElectionRepository electionRepository;

    public FirstAndLastByPoliticalPartyUseCase(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public List<PoliticalParty> execute() {
        List<PoliticalParty> politicalParties = new ArrayList<>(electionRepository.getAllPoliticalParty());
        politicalParties = politicalParties
                .stream()
                .filter(p -> p.getMostVoted() != null)
                .collect(Collectors.toList());
        Collections.sort(politicalParties, ComparatorUseCase.politicalPartyMostVotedCandidate);
        return politicalParties;
    }
}
