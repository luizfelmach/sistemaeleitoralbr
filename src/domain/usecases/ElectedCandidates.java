package domain.usecases;

import domain.model.Candidate;
import repository.CandidateRepository;

public class ElectedCandidates {
    CandidateRepository candidateRepository;

    public ElectedCandidates(CandidateRepository candidateRepository) {
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
