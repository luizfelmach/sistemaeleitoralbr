package domain.usecases;

import domain.entity.Candidate;
import domain.repository.ElectionRepository;
import domain.util.ComparatorUseCase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ElectedCandidatesInProportionalSystem {

  ElectionRepository electionRepository;

  public ElectedCandidatesInProportionalSystem(
    ElectionRepository electionRepository
  ) {
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
