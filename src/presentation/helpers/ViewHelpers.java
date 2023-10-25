package presentation.helpers;

import java.text.NumberFormat;
import java.util.Locale;

import domain.entity.Candidate;

public class ViewHelpers {
    public static String toInt(int value) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.of("pt", "BR"));
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
        if (votes <= 1)
            return "voto";
        return "votos";
    }
}
