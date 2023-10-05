package domain.usecases;

import domain.repository.CandidateRepository;

public class NumberOfElectedCandidatesUseCase {
    CandidateRepository candidateRepository;

    public NumberOfElectedCandidatesUseCase(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public int execute() {
        return candidateRepository.getNumberOfElectedCandidates();
    }
}
