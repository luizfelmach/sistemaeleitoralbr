package config;

import java.time.LocalDate;

public class AppConfig {

  public static ElectionType electionType = ElectionType.FEDERAL;
  public static String fileOfCandidates;
  public static String fileOfVoting;
  public static LocalDate electionDate = LocalDate.now();

  public enum ElectionType {
    FEDERAL,
    STATE,
  }

  public static void show() {
    System.out.printf("Election Type: %s\n", electionType);
    System.out.printf("Election Date: %s\n", electionDate);
    System.out.printf("File of Candidates: %s\n", fileOfCandidates);
    System.out.printf("File of voting: %s\n", fileOfVoting);
  }
}
