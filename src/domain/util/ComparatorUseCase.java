package domain.util;

import java.util.Comparator;

import domain.entity.Candidate;
import domain.entity.PoliticalParty;

public class ComparatorUseCase {
    public static Comparator<Candidate> candidateMostVoted = new Comparator<Candidate>() {
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
            return diff;
        }
    };

    public static Comparator<PoliticalParty> politicalPartyMostVoted = new Comparator<PoliticalParty>() {
        @Override
        public int compare(PoliticalParty p1, PoliticalParty p2) {
            int diff = p2.getMostVoted().getTotalVotes() - p1.getMostVoted().getTotalVotes();
            if (diff == 0) {
                return p1.getPoliticalPartyNumber() - p2.getPoliticalPartyNumber();
            }
            return diff;
        }
    };
}
