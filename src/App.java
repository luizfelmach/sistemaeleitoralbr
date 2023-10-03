import adapters.InMemoryCandidateRepository;
import domain.usecases.ElectedCandidates;
import presentation.ElectedCandidatesView;

public class App {
    public static void main(String[] args) {
        InMemoryCandidateRepository candidateRepository = new InMemoryCandidateRepository();
        ElectedCandidates electedCandidates = new ElectedCandidates(candidateRepository);
        ElectedCandidatesView electedCandidatesView = new ElectedCandidatesView(electedCandidates);
        electedCandidatesView.handle();
    }
}
