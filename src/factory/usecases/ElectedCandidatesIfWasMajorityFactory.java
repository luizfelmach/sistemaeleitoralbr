package factory.usecases;

import domain.repository.CandidateRepository;
import domain.usecases.ElectedCandidatesIfWasMajorityUseCase;
import factory.repository.CandidateRepositoryFactory;

public class ElectedCandidatesIfWasMajorityFactory {
    private CandidateRepository candidateRepository = new CandidateRepositoryFactory().create();

    public ElectedCandidatesIfWasMajorityUseCase create() {
        return new ElectedCandidatesIfWasMajorityUseCase(candidateRepository);
    }
}
