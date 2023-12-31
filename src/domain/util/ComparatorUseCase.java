package domain.util;

import domain.entity.Candidate;
import domain.entity.PoliticalParty;
import java.util.Comparator;

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
      int diff = p2.getTotalVotes() - p1.getTotalVotes();
      if (diff == 0) {
        return p1.getNumber() - p2.getNumber();
      }
      return diff;
    }
  };

  public static Comparator<PoliticalParty> politicalPartyMostVotedCandidate = new Comparator<PoliticalParty>() {
    @Override
    public int compare(PoliticalParty p1, PoliticalParty p2) {
      int diff =
        p2.getMostVoted().getTotalVotes() - p1.getMostVoted().getTotalVotes();
      if (diff == 0) {
        return p1.getNumber() - p2.getNumber();
      }
      return diff;
    }
  };
}
