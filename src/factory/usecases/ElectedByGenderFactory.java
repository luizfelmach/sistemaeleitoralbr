package factory.usecases;

import domain.repository.ElectionRepository;
import domain.usecases.ElectedByGenderUseCase;
import factory.repository.ElectionRepositoryFactory;

public class ElectedByGenderFactory {
    private ElectionRepository electionRepository = new ElectionRepositoryFactory().create();

    public ElectedByGenderUseCase create() {
        return new ElectedByGenderUseCase(electionRepository);
    }
}
