package presentation.terminal;

import domain.entity.Candidate;
import domain.usecases.ElectedCandidatesIfWasMajorityUseCase;
import factory.usecases.ElectedCandidatesIfWasMajorityFactory;
import presentation.View;

public class ElectedCandidatesIfWasMajorityView implements View {
    ElectedCandidatesIfWasMajorityUseCase electedCandidatesIfWasMajorityUseCase;

    public ElectedCandidatesIfWasMajorityView() {
        this.electedCandidatesIfWasMajorityUseCase = new ElectedCandidatesIfWasMajorityFactory().create();
    }

    @Override
    public void view() {
        System.out.println("Teriam sido eleitos se a votação fosse majoritária, e não foram eleitos:");
        int position = 1;
        for (Candidate candidate : electedCandidatesIfWasMajorityUseCase.execute()) {
            System.out.printf("%d - %s (%s, %d votos)\n",
                    position, candidate.getName(),
                    candidate.getPoliticalParty(),
                    candidate.getTotalVotes());
            position += 1;
        }
    }

}
