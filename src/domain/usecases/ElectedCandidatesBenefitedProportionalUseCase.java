package domain.usecases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.entity.Candidate;
import domain.repository.ElectionRepository;
import domain.util.ComparatorUseCase;

public class ElectedCandidatesBenefitedProportionalUseCase {
    ElectionRepository electionRepository;

    public ElectedCandidatesBenefitedProportionalUseCase(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public List<Candidate> execute() {
        List<Candidate> candidates = new ArrayList<>();
        List<Candidate> mostVotedCandidates = electionRepository.getAllCandidates();
        Collections.sort(mostVotedCandidates, ComparatorUseCase.candidateMostVoted);
        int start = electionRepository.getNumberOfElectedCandidates();
        for (int i = start; i < mostVotedCandidates.size(); i++) {
            Candidate candidate = mostVotedCandidates.get(i);
            candidate.setRankingMostVoted(i + 1);
            if (candidate.isElected()) {
                candidates.add(candidate);
            }
        }
        return candidates;
    }
}
