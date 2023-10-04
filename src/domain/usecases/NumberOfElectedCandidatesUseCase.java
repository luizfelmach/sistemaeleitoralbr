package domain.usecases;

import domain.entity.Candidate;
import domain.repository.CandidateRepository;

public class NumberOfElectedCandidatesUseCase {
    CandidateRepository candidateRepository;

    public NumberOfElectedCandidatesUseCase(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public int execute() {
        int totalElected = 0;
        for (Candidate candidate : candidateRepository.getAllCandidates()) {
            if (candidate.isElected()) {
                totalElected += 1;
            }
        }
        return totalElected;
    }
}
