package factory.usecases;

import domain.repository.CandidateRepository;
import domain.usecases.ElectedCandidatesBenefitedProportionalUseCase;
import factory.repository.CandidateRepositoryFactory;

public class ElectedCandidatesBenefitedProportionalFactory {
    private CandidateRepository candidateRepository = new CandidateRepositoryFactory().create();

    public ElectedCandidatesBenefitedProportionalUseCase create() {
        return new ElectedCandidatesBenefitedProportionalUseCase(candidateRepository);
    }
}
