import presentation.View;
import presentation.terminal.ElectedCandidatesBenefitedProportionalView;
import presentation.terminal.ElectedCandidatesIfWasMajorityView;
import presentation.terminal.ElectedCandidatesView;
import presentation.terminal.MostVotedCandidatesView;
import presentation.terminal.NumberOfElectedCandidatesView;
import presentation.terminal.TotalVotesView;

public class App {
    public static void main(String[] args) {
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
}
