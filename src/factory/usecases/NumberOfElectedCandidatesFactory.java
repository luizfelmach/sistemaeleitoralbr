package factory.usecases;

import domain.repository.CandidateRepository;
import domain.usecases.NumberOfElectedCandidatesUseCase;
import factory.repository.CandidateRepositoryFactory;

public class NumberOfElectedCandidatesFactory {
    private CandidateRepository candidateRepository = new CandidateRepositoryFactory().create();

    public NumberOfElectedCandidatesUseCase create() {
        return new NumberOfElectedCandidatesUseCase(candidateRepository);
    }
}
