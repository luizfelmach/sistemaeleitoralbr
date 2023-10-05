package domain.usecases;

import java.util.Set;

import domain.entity.Candidate;
import domain.repository.ElectionRepository;

public class ElectedCandidatesUseCase {
    ElectionRepository electionRepository;

    public ElectedCandidatesUseCase(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public Set<Candidate> execute() {
        return electionRepository.getElectedCandidates();
    }
}
