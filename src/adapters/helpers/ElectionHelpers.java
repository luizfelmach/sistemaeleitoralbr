package adapters.helpers;

import config.AppConfig;
import config.AppConfig.ElectionType;
import domain.entity.Candidate;

public class ElectionHelpers {

  public static boolean isCandidatePositionInvalid(int candidatePosition) {
    if (
      candidatePosition == 6 && AppConfig.electionType == ElectionType.FEDERAL
    ) {
      return false;
    }
    if (
      candidatePosition == 7 && AppConfig.electionType == ElectionType.STATE
    ) {
      return false;
    }
    return true;
  }

  public static boolean isInvalidVote(int number) {
    if (number >= 95 && number <= 98) {
      return true;
    }
    return false;
  }

  public static boolean isCandidateRejected(int code) {
    if (code == 16 || code == 2) {
      return false;
    }
    return true;
  }

  public static boolean isValidVote(int CD_CARGO, int NR_NOTAVEL) {
    if (isCandidatePositionInvalid(CD_CARGO)) {
      return false;
    }
    if (isInvalidVote(NR_NOTAVEL)) {
      return false;
    }
    return true;
  }

  public static Candidate.Gender getCandidatGender(int code) {
    if (code == 4) {
      return Candidate.Gender.FEMALE;
    }
    return Candidate.Gender.MALE;
  }

  public static boolean isCandidateElected(int code) {
    if (code == 2 || code == 3) {
      return true;
    }
    return false;
  }

  public static boolean destCaptionVote(String code) {
    if (code.equals("Válido (legenda)")) {
      return true;
    }
    return false;
  }
}
