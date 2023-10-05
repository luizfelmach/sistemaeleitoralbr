package domain.usecases;

import java.util.ArrayList;
import java.util.List;

import domain.entity.Candidate;
import domain.repository.ElectionRepository;

public class MostVotedCandidatesUseCase {
    ElectionRepository electionRepository;

    public MostVotedCandidatesUseCase(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public List<Candidate> execute() {
        List<Candidate> candidates = new ArrayList<>();
        List<Candidate> mostVotedCandidates = electionRepository.getMostVotedCandidates();
        int numberOfElectedCandidates = electionRepository.getNumberOfElectedCandidates();
        for (int i = 0; i < numberOfElectedCandidates; i++) {
            candidates.add(mostVotedCandidates.get(i));
        }
        return candidates;
    }
}
