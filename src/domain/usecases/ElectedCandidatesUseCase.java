package domain.usecases;

import java.util.Set;

import domain.entity.Candidate;
import domain.repository.CandidateRepository;

public class ElectedCandidatesUseCase {
    CandidateRepository candidateRepository;

    public ElectedCandidatesUseCase(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Set<Candidate> execute() {
        return candidateRepository.getElectedCandidates();
    }
}
