package config;

public class AppConfig {
    static ElectionType electionType = ElectionType.FEDERAL;

    public static void setElectionType(ElectionType electionType) {
        AppConfig.electionType = electionType;
    }

    public enum ElectionType {
        FEDERAL, STATE
    }
}
