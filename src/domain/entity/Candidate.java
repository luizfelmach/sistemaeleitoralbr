package domain.entity;

import java.time.LocalDate;

public class Candidate {
    private String name;
    private PoliticalParty politicalParty;
    private int totalVotes;
    private int rankingMostVoted;
    private Gender gender;
    private boolean isElected;
    private LocalDate birthdayDate;
    private int federationNumber;
    private boolean destCaptionVote;
    private boolean isRejected;

    public Candidate(String name, PoliticalParty politicalParty, boolean isElected, Gender genre,
            LocalDate birthdayDate, int federationNumber, boolean destCaptionVote, boolean isRejected) {
        this.name = name;
        this.politicalParty = politicalParty;
        this.isElected = isElected;
        this.gender = genre;
        this.birthdayDate = birthdayDate;
        politicalParty.addCandidate(this);
        this.federationNumber = federationNumber;
        this.destCaptionVote = destCaptionVote;
        this.isRejected = isRejected;
    }

    public enum Gender {
        MALE, FEMALE;
    }

    public String getName() {
        return name;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void addVotes(int partial) {
        if (isRejected) {
            if (destCaptionVote) {
                politicalParty.addCaptionVote(partial);
            }
            return;
        }
        if (destCaptionVote) {
            politicalParty.addCaptionVote(partial);

        } else {
            totalVotes += partial;
            politicalParty.addRollCallVote(partial);
        }
    }

    public PoliticalParty getPoliticalParty() {
        return politicalParty;
    }

    public void setIsElected(boolean isElected) {
        this.isElected = isElected;
    }

    public boolean isElected() {
        return isElected;
    }

    public void setRankingMostVoted(int rankingMostVoted) {
        this.rankingMostVoted = rankingMostVoted;
    }

    public int getRankingMostVoted() {
        return rankingMostVoted;
    }

    public int getFederationNumber() {
        return federationNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }
}
