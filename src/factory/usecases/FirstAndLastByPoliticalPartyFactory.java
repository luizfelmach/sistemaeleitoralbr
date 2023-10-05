package factory.usecases;

import domain.repository.ElectionRepository;
import domain.usecases.FirstAndLastByPoliticalPartyUseCase;
import factory.repository.ElectionRepositoryFactory;

public class FirstAndLastByPoliticalPartyFactory {
    private ElectionRepository electionRepository = new ElectionRepositoryFactory().create();

    public FirstAndLastByPoliticalPartyUseCase create() {
        return new FirstAndLastByPoliticalPartyUseCase(electionRepository);
    }
}
