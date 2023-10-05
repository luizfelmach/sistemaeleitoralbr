package factory.usecases;

import domain.repository.ElectionRepository;
import domain.usecases.NumberOfElectedCandidatesUseCase;
import factory.repository.ElectionRepositoryFactory;

public class NumberOfElectedCandidatesFactory {
    private ElectionRepository electionRepository = new ElectionRepositoryFactory().create();

    public NumberOfElectedCandidatesUseCase create() {
        return new NumberOfElectedCandidatesUseCase(electionRepository);
    }
}
