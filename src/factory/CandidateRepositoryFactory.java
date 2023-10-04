package factory;

import adapters.InMemoryCandidateRepository;
import domain.repository.CandidateRepository;

public class CandidateRepositoryFactory {
    CandidateRepository candidateRepository = new InMemoryCandidateRepository();

    public CandidateRepository execute() {
        return candidateRepository;
    }
}
