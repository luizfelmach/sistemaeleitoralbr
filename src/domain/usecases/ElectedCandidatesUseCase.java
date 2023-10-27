package domain.usecases;

import java.util.Collections;
import java.util.List;

import domain.entity.Candidate;
import domain.repository.ElectionRepository;
import domain.util.ComparatorUseCase;

public class ElectedCandidatesUseCase {
    ElectionRepository electionRepository;

    public ElectedCandidatesUseCase(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public List<Candidate> execute() {
        List<Candidate> electedCandidates = electionRepository.getElectedCandidates();
        Collections.sort(electedCandidates, ComparatorUseCase.mostVoted);
        return electedCandidates;
    }
}
