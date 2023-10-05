package config;

import java.time.LocalDate;

public class AppConfig {
    static ElectionType electionType = ElectionType.FEDERAL;
    static LocalDate electionDate = LocalDate.now();

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
