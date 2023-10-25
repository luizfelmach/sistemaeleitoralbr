package domain.usecases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domain.entity.Candidate;
import domain.repository.ElectionRepository;

public class ElectedCandidatesUseCase {
    ElectionRepository electionRepository;

    public ElectedCandidatesUseCase(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public List<Candidate> execute() {

        List<Candidate> electedCandidates = new ArrayList<>(electionRepository.getElectedCandidates());
        Collections.sort(electedCandidates, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate c1, Candidate c2) {
                int diff = c2.getTotalVotes() - c1.getTotalVotes();
                if (diff == 0) {
                    if (c2.getBirthdayDate().isBefore(c1.getBirthdayDate())) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return c2.getTotalVotes() - c1.getTotalVotes();
            }
        });
        return electedCandidates;
    }
}
