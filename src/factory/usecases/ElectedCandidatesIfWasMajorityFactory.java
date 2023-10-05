package factory.usecases;

import domain.repository.ElectionRepository;
import domain.usecases.ElectedCandidatesIfWasMajorityUseCase;
import factory.repository.ElectionRepositoryFactory;

public class ElectedCandidatesIfWasMajorityFactory {
    private ElectionRepository electionRepository = new ElectionRepositoryFactory().create();

    public ElectedCandidatesIfWasMajorityUseCase create() {
        return new ElectedCandidatesIfWasMajorityUseCase(electionRepository);
    }
}
