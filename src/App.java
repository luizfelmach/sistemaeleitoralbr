import presentation.View;
import presentation.terminal.ElectedCandidatesView;
import presentation.terminal.MostVotedCandidatesView;
import presentation.terminal.NumberOfElectedCandidatesView;

public class App {
    public static void main(String[] args) {
        View numberOfElectedCandidates = new NumberOfElectedCandidatesView();
        View electedCandidates = new ElectedCandidatesView();
        View mostVotedCandidates = new MostVotedCandidatesView();

        numberOfElectedCandidates.view();
        electedCandidates.view();
        mostVotedCandidates.view();

    }
}
