package factory.usecases;

import domain.repository.ElectionRepository;
import domain.usecases.VotingByPoliticalPartyUseCase;
import factory.repository.ElectionRepositoryFactory;

public class VotingByPoliticalPartyFactory {
    private ElectionRepository electionRepository = new ElectionRepositoryFactory().create();

    public VotingByPoliticalPartyUseCase create() {
        return new VotingByPoliticalPartyUseCase(electionRepository);
    }
}
