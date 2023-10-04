package factory.repository;

import adapters.InMemoryCandidateRepository;
import domain.repository.CandidateRepository;

public class CandidateRepositoryFactory {
    private CandidateRepository candidateRepository = new InMemoryCandidateRepository();

    public CandidateRepository create() {
        return candidateRepository;
    }
}
