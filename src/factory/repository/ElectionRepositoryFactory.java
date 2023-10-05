package factory.repository;

import adapters.InMemoryElectionRepository;
import domain.repository.ElectionRepository;

public class ElectionRepositoryFactory {
    private ElectionRepository candidateRepository = new InMemoryElectionRepository();

    public ElectionRepository create() {
        return candidateRepository;
    }
}
