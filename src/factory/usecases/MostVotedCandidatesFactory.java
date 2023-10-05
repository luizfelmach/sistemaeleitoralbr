package factory.usecases;

import domain.repository.ElectionRepository;
import domain.usecases.MostVotedCandidatesUseCase;
import factory.repository.ElectionRepositoryFactory;

public class MostVotedCandidatesFactory {
    private ElectionRepository electionRepository = new ElectionRepositoryFactory().create();

    public MostVotedCandidatesUseCase create() {
        return new MostVotedCandidatesUseCase(electionRepository);
    }
}
