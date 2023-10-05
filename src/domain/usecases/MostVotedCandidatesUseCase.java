package domain.usecases;

import java.util.ArrayList;
import java.util.List;

import domain.entity.Candidate;
import domain.repository.CandidateRepository;

public class MostVotedCandidatesUseCase {
    CandidateRepository candidateRepository;

    public MostVotedCandidatesUseCase(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> execute() {
        List<Candidate> candidates = new ArrayList<>();
        List<Candidate> mostVotedCandidates = candidateRepository.getMostVotedCandidates();
        int numberOfElectedCandidates = candidateRepository.getNumberOfElectedCandidates();
        for (int i = 0; i < numberOfElectedCandidates; i++) {
            candidates.add(mostVotedCandidates.get(i));
        }
        return candidates;
    }
}
