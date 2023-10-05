package domain.entity;

public class Candidate {
    private String name;
    private String politicalParty;
    private int totalVotes;
    private boolean isElected;

    public Candidate(String name, String politicalParty, int totalVotes, boolean isElected) {
        this.name = name;
        this.politicalParty = politicalParty;
        this.totalVotes = totalVotes;
        this.isElected = isElected;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setPoliticalParty(String politicalParty) {
        this.politicalParty = politicalParty;
    }

    public String getPoliticalParty() {
        return politicalParty;
    }

    public void setIsElected(boolean isElected) {
        this.isElected = isElected;
    }

    public boolean isElected() {
        return isElected;
    }

}
