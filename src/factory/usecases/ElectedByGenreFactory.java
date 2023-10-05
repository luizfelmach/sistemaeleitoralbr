package factory.usecases;

import domain.repository.ElectionRepository;
import domain.usecases.ElectedByGenreUseCase;
import factory.repository.ElectionRepositoryFactory;

public class ElectedByGenreFactory {
    private ElectionRepository electionRepository = new ElectionRepositoryFactory().create();

    public ElectedByGenreUseCase create() {
        return new ElectedByGenreUseCase(electionRepository);
    }
}
