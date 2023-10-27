package presentation.helpers;

import config.AppConfig;
import config.AppConfig.ElectionType;
import domain.entity.Candidate;
import java.text.NumberFormat;
import java.util.Locale;

public class ViewHelpers {

  public static String toInt(int value) {
    NumberFormat formatter = NumberFormat.getInstance(new Locale("pt", "BR"));
    return formatter.format(value);
  }

  public static String showCandidateName(Candidate candidate) {
    String withoutFederation = "*";
    if (candidate.getFederationNumber() == -1) {
      withoutFederation = "";
    }
    return withoutFederation + candidate.getName();
  }

  public static String getSlugVote(int votes) {
    if (votes <= 1) return "voto";
    return "votos";
  }

  public static String getElectionType() {
    if (AppConfig.electionType == ElectionType.FEDERAL) {
      return "federais";
    }
    return "estaduais";
  }
}
