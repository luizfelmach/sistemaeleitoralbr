package factory.usecases;

import domain.repository.ElectionRepository;
import domain.usecases.TotalVotesUseCase;
import factory.repository.ElectionRepositoryFactory;

public class TotalVotesFactory {
    private ElectionRepository electionRepository = new ElectionRepositoryFactory().create();

    public TotalVotesUseCase create() {
        return new TotalVotesUseCase(electionRepository);
    }
}
