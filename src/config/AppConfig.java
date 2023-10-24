package config;

import java.time.LocalDate;

public class AppConfig {
    public static ElectionType electionType = ElectionType.FEDERAL;
    static LocalDate electionDate = LocalDate.now();
    static public String fileOfCandidate;
    static public String fileOfVoting;

    public static void setElectionType(ElectionType electionType) {
        AppConfig.electionType = electionType;
    }

    public static String getElectionType() {
        if (electionType == ElectionType.FEDERAL) {
            return "federais";
        }
        return "estaduais";
    }

    public static LocalDate getElectionDate() {
        return electionDate;
    }

    public static void setElectionDate(LocalDate date) {
        electionDate = date;
    }

    public enum ElectionType {
        FEDERAL, STATE
    }

    public static void show() {
        System.out.printf("Election Type: %s\n", electionType);
        System.out.printf("Election Date: %s\n", electionDate);
        System.out.printf("File of Candidate: %s\n", fileOfCandidate);
        System.out.printf("File of voting: %s\n", fileOfVoting);
    }
}
