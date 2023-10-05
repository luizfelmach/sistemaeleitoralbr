package domain.entity;

public class Candidate {
    private String name;
    private PoliticalParty politicalParty;
    private int totalVotes;
    private int rankingMostVoted;
    private boolean isElected;

    public Candidate(String name, int totalVotes, boolean isElected) {
        this.name = name;
        this.totalVotes = totalVotes;
        this.isElected = isElected;
    }

    public String getName() {
        return name;
    }

    public int getTotalVotes() {
        return totalVotes;
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

}
