import adapters.InMemoryCandidateRepository;
import domain.usecases.ElectedCandidatesUseCase;
import domain.usecases.NumberOfElectedCandidatesUseCase;
import presentation.ElectedCandidatesView;
import presentation.NumberOfElectedCandidatesView;

public class App {
    public static void main(String[] args) {
        InMemoryCandidateRepository candidateRepository = new InMemoryCandidateRepository();
        NumberOfElectedCandidatesUseCase numberOfElectedCandidatesUseCase = new NumberOfElectedCandidatesUseCase(
                candidateRepository);
        NumberOfElectedCandidatesView numberOfelectedCandidatesView = new NumberOfElectedCandidatesView(
                numberOfElectedCandidatesUseCase);

        ElectedCandidatesUseCase electedCandidatesUseCase = new ElectedCandidatesUseCase(candidateRepository);
        ElectedCandidatesView electedCandidatesView = new ElectedCandidatesView(electedCandidatesUseCase);

        numberOfelectedCandidatesView.handle();
        electedCandidatesView.handle();
    }
}
