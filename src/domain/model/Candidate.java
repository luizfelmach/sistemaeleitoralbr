package domain.model;

public class Candidate {
    private String name;
    private String politicalParty;
    private int totalVotes;
    private boolean isElected;

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
