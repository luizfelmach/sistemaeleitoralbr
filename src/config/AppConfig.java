package config;

public class AppConfig {
    static ElectionType electionType = ElectionType.FEDERAL;

    public static void setElectionType(ElectionType electionType) {
        AppConfig.electionType = electionType;
    }

    public static String getElectionType() {
        if (electionType == ElectionType.FEDERAL) {
            return "federais";
        }
        return "estaduais";
    }

    public enum ElectionType {
        FEDERAL, STATE
    }
}
