import adapters.InMemoryCandidateRepository;
import domain.usecases.NumberOfElectedCandidatesUseCase;
import presentation.NumberOfElectedCandidatesView;

public class App {
    public static void main(String[] args) {
        InMemoryCandidateRepository candidateRepository = new InMemoryCandidateRepository();
        NumberOfElectedCandidatesUseCase numberOfElectedCandidatesUseCase = new NumberOfElectedCandidatesUseCase(candidateRepository);
        NumberOfElectedCandidatesView numberOfelectedCandidatesView = new NumberOfElectedCandidatesView(numberOfElectedCandidatesUseCase);
        numberOfelectedCandidatesView.handle();
    }
}
