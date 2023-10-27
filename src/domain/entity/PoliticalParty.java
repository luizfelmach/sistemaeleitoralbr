package domain.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PoliticalParty {
    private String name;
    private int politicalPartyNumber;
    private int rollCallVotes;
    private int captionVotes;
    Set<Candidate> candidates = new HashSet<>();

    public PoliticalParty(int politicalPartyNumber, String name) {
        this.politicalPartyNumber = politicalPartyNumber;
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
        captionVotes += partial;
    }

    public int getPoliticalPartyNumber() {
        return politicalPartyNumber;
    }

    public int getElectedCandidatesSize() {
        List<Candidate> electedCandidates = candidates.stream().filter(c -> c.isElected()).collect(Collectors.toList());
        return electedCandidates.size();
    }

    public Candidate getMostVoted() {
        Candidate candidateMostVoted = null;
        for (Candidate candidate : candidates) {
            if (!candidate.isRejected()) {
                if (candidateMostVoted == null) {
                    candidateMostVoted = candidate;
                    continue;
                }
                if (candidateMostVoted.getTotalVotes() == candidate.getTotalVotes()) {
                    if (candidateMostVoted.getBirthdayDate().isBefore(candidate.getBirthdayDate())) {
                        candidateMostVoted = candidate;
                    }
                }
                if (candidateMostVoted.getTotalVotes() < candidate.getTotalVotes()) {
                    candidateMostVoted = candidate;
                }
            }
        }
        return candidateMostVoted;
    }

    public Candidate getLeastVoted() {
        Candidate candidateLeastVoted = null;
        for (Candidate candidate : candidates) {
            if (!candidate.isRejected() && !candidate.isCaptionCandidate()) {
                if (candidateLeastVoted == null) {
                    candidateLeastVoted = candidate;
                    continue;
                }
                if (candidateLeastVoted.getTotalVotes() == candidate.getTotalVotes()) {
                    if (candidateLeastVoted.getBirthdayDate().isBefore(candidate.getBirthdayDate())) {
                        candidateLeastVoted = candidate;
                    }
                }
                if (candidateLeastVoted.getTotalVotes() > candidate.getTotalVotes()) {
                    candidateLeastVoted = candidate;
                }
            }
        }
        return candidateLeastVoted;
    }
}
