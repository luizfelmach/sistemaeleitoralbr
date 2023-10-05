package factory.usecases;

import domain.repository.CandidateRepository;
import domain.usecases.MostVotedCandidatesUseCase;
import factory.repository.CandidateRepositoryFactory;

public class MostVotedCandidatesFactory {
    private CandidateRepository candidateRepository = new CandidateRepositoryFactory().create();

    public MostVotedCandidatesUseCase create() {
        return new MostVotedCandidatesUseCase(candidateRepository);
    }
}
