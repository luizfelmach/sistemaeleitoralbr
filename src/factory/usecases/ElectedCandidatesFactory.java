package factory.usecases;

import domain.repository.CandidateRepository;
import domain.usecases.ElectedCandidatesUseCase;
import factory.repository.CandidateRepositoryFactory;

public class ElectedCandidatesFactory {
    private CandidateRepository candidateRepository = new CandidateRepositoryFactory().create();

    public ElectedCandidatesUseCase create() {
        return new ElectedCandidatesUseCase(candidateRepository);
    }
}
