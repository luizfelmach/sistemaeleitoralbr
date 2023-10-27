package domain.util;

import java.util.Comparator;

import domain.entity.Candidate;

public class ComparatorUseCase {
    public static Comparator<Candidate> mostVoted = new Comparator<Candidate>() {
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
    };
}
