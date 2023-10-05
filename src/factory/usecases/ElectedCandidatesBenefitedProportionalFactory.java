package factory.usecases;

import domain.repository.ElectionRepository;
import domain.usecases.ElectedCandidatesBenefitedProportionalUseCase;
import factory.repository.ElectionRepositoryFactory;

public class ElectedCandidatesBenefitedProportionalFactory {
    private ElectionRepository electionRepository = new ElectionRepositoryFactory().create();

    public ElectedCandidatesBenefitedProportionalUseCase create() {
        return new ElectedCandidatesBenefitedProportionalUseCase(electionRepository);
    }
}
