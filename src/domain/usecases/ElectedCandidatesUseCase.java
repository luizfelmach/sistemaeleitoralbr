package domain.usecases;

import java.util.HashSet;
import java.util.Set;

import domain.entity.Candidate;
import domain.repository.CandidateRepository;

public class ElectedCandidatesUseCase {
    CandidateRepository candidateRepository;

    public ElectedCandidatesUseCase(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Set<Candidate> execute() {
        Set<Candidate> candidatesElected = new HashSet<>();
        for (Candidate candidate : candidateRepository.getAllCandidates()) {
            if (candidate.isElected()) {
                candidatesElected.add(candidate);
            }
        }
        return candidatesElected;
    }
}
