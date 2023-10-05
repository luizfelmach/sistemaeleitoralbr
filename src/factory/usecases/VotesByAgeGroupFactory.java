package factory.usecases;

import domain.repository.ElectionRepository;
import domain.usecases.VotesByAgeGroupUseCase;
import factory.repository.ElectionRepositoryFactory;

public class VotesByAgeGroupFactory {
    private ElectionRepository electionRepository = new ElectionRepositoryFactory().create();

    public VotesByAgeGroupUseCase create() {
        return new VotesByAgeGroupUseCase(electionRepository);
    }
}
