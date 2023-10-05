package domain.usecases;

import domain.repository.ElectionRepository;

public class NumberOfElectedCandidatesUseCase {
    ElectionRepository electionRepository;

    public NumberOfElectedCandidatesUseCase(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public int execute() {
        return electionRepository.getNumberOfElectedCandidates();
    }
}
