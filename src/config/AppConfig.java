package config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppConfig {

  public static ElectionType electionType;
  public static String fileOfCandidates;
  public static String fileOfVoting;
  public static LocalDate electionDate;

  public enum ElectionType {
    FEDERAL,
    STATE,
  }

  public static void setupElectionType(String electionType) {
    if (electionType.equals("--estadual")) {
      AppConfig.electionType = ElectionType.STATE;
      return;
    }
    if (electionType.equals("--federal")) {
      AppConfig.electionType = ElectionType.FEDERAL;
      return;
    }
    throw new IllegalArgumentException(electionType);
  }

  public static void setupFileOfCandidates(String fileOfCandidates) {
    AppConfig.fileOfCandidates = fileOfCandidates;
  }

  public static void setupFileOfVoting(String fileOfVoting) {
    AppConfig.fileOfVoting = fileOfVoting;
  }

  public static void setupElectionDate(String electionDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    AppConfig.electionDate = LocalDate.parse(electionDate, formatter);
  }

  public static void show() {
    System.out.printf("Election Type: %s\n", electionType);
    System.out.printf("Election Date: %s\n", electionDate);
    System.out.printf("File of Candidates: %s\n", fileOfCandidates);
    System.out.printf("File of voting: %s\n", fileOfVoting);
  }
}
