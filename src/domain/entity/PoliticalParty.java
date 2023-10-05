package domain.entity;

import java.util.HashSet;
import java.util.Set;

public class PoliticalParty {
    private String name;
    private int politicalPartyNumber;
    private int rollCallVotes;
    private int captionVotes;
    Set<Candidate> candidates = new HashSet<>();

    public PoliticalParty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getRollCallVotes() {
        return rollCallVotes;
    }

    public int getCaptionVotes() {
        return captionVotes;
    }

    public int getTotalVotes() {
        return getRollCallVotes() + getCaptionVotes();
    }

    public Set<Candidate> getCandidates() {
        return new HashSet<>(candidates);
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public void addRollCallVote(int partial) {
        rollCallVotes += partial;
    }

    public void addCaptionVote(int partial) {
        rollCallVotes += partial;
    }

    public int getPoliticalPartyNumber() {
        return politicalPartyNumber;
    }
}