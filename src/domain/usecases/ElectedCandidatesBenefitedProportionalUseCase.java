package domain.usecases;

import java.util.ArrayList;
import java.util.List;

import domain.entity.Candidate;
import domain.repository.CandidateRepository;

public class ElectedCandidatesBenefitedProportionalUseCase {
    CandidateRepository candidateRepository;

    public ElectedCandidatesBenefitedProportionalUseCase(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> execute() {
        List<Candidate> candidates = new ArrayList<>();
        List<Candidate> mostVotedCandidates = candidateRepository.getMostVotedCandidates();
        int start = candidateRepository.getNumberOfElectedCandidates();
        for (int i = start; i < mostVotedCandidates.size(); i++) {
            Candidate candidate = mostVotedCandidates.get(i);
            if (candidate.isElected()) {
                candidates.add(candidate);
            }
        }
        return candidates;
    }
}
