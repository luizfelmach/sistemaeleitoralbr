package factory.usecases;

import domain.repository.ElectionRepository;
import domain.usecases.ElectedCandidatesUseCase;
import factory.repository.ElectionRepositoryFactory;

public class ElectedCandidatesFactory {
    private ElectionRepository electionRepository = new ElectionRepositoryFactory().create();

    public ElectedCandidatesUseCase create() {
        return new ElectedCandidatesUseCase(electionRepository);
    }
}
