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

    public Candidate(String name, PoliticalParty politicalParty, boolean isElected, Gender genre,
            LocalDate birthdayDate) {
        this.name = name;
        this.politicalParty = politicalParty;
        this.isElected = isElected;
        this.gender = genre;
        this.birthdayDate = birthdayDate;
        politicalParty.addCandidate(this);
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
        totalVotes += partial;
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

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }
}
