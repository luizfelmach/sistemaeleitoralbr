import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import config.AppConfig;
import config.AppConfig.ElectionType;
import presentation.View;
import presentation.terminal.ElectedCandidatesBenefitedProportionalView;
import presentation.terminal.ElectedCandidatesIfWasMajorityView;
import presentation.terminal.ElectedCandidatesView;
import presentation.terminal.MostVotedCandidatesView;
import presentation.terminal.NumberOfElectedCandidatesView;
import presentation.terminal.TotalVotesView;

public class App {
    public static void main(String[] args) {
        if (args.length != 4) {
            throw new Error(
                    "usage: java -jar deputados.jar <type> <file of candidates> <file of votings> <election date DD/MM/YYYY>");
        }
        setup(args);

        View numberOfElectedCandidates = new NumberOfElectedCandidatesView();
        View electedCandidates = new ElectedCandidatesView();
        View mostVotedCandidates = new MostVotedCandidatesView();
        View electedCandidatesIfWasMajority = new ElectedCandidatesIfWasMajorityView();
        View electedCandidatesBenefitedProportionalView = new ElectedCandidatesBenefitedProportionalView();
        View totalVotesView = new TotalVotesView();

        numberOfElectedCandidates.view();
        electedCandidates.view();
        mostVotedCandidates.view();
        electedCandidatesIfWasMajority.view();
        electedCandidatesBenefitedProportionalView.view();
        totalVotesView.view();
    }

    public static void setup(String args[]) {
        if (args[0].equals("--estadual")) {
            AppConfig.setElectionType(ElectionType.STATE);
        } else {
            AppConfig.setElectionType(ElectionType.FEDERAL);
        }
        AppConfig.fileOfCandidate = args[1];
        AppConfig.fileOfVoting = args[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        AppConfig.setElectionDate(LocalDate.parse(args[3], formatter));
    }
}
