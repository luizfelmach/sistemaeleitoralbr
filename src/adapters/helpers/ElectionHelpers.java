package adapters.helpers;

import config.AppConfig;
import config.AppConfig.ElectionType;
import domain.entity.Candidate;

public class ElectionHelpers {
    static public boolean isCandidatePositionInvalid(int candidatePosition) {
        if (candidatePosition == 6 && AppConfig.electionType == ElectionType.FEDERAL) {
            return false;
        }
        if (candidatePosition == 7 && AppConfig.electionType == ElectionType.STATE) {
            return false;
        }
        return true;
    }

    static public boolean isInvalidVote(int number) {
        if (number >= 95 && number <= 98) {
            return true;
        }
        return false;
    }

    static public boolean isToSkipCandidate(int code) {
        if (code == 16 || code == 2) {
            return false;
        }
        return true;
    }

    static public Candidate.Gender getCandidatGender(int code) {
        if (code == 4) {
            return Candidate.Gender.FEMALE;
        }
        return Candidate.Gender.MALE;
    }

    static public boolean isCandidateElected(int code) {
        if (code == 2 || code == 3) {
            return true;
        }
        return false;
    }

    static public boolean destCaptionVote(String code) {
        if (code.equals("Válido (legenda)")) {
            return true;
        }
        return false;
    }
}
