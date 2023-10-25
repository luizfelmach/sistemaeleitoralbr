import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import adapters.InMemoryElectionRepository;
import config.AppConfig;
import config.AppConfig.ElectionType;
import domain.usecases.ElectedCandidatesBenefitedProportionalUseCase;
import domain.usecases.ElectedCandidatesIfWasMajorityUseCase;
import domain.usecases.ElectedCandidatesUseCase;
import domain.usecases.MostVotedCandidatesUseCase;
import domain.usecases.NumberOfElectedCandidatesUseCase;
import domain.usecases.TotalVotesUseCase;
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
                // AppConfig.show();

                // Election Repository
                InMemoryElectionRepository inMemoryElectionRepository = new InMemoryElectionRepository();

                // Use Cases
                NumberOfElectedCandidatesUseCase numberOfElectedCandidatesUseCase = new NumberOfElectedCandidatesUseCase(
                                inMemoryElectionRepository);
                ElectedCandidatesUseCase electedCandidatesUseCase = new ElectedCandidatesUseCase(
                                inMemoryElectionRepository);
                MostVotedCandidatesUseCase mostVotedCandidatesUseCase = new MostVotedCandidatesUseCase(
                                inMemoryElectionRepository);
                ElectedCandidatesIfWasMajorityUseCase electedCandidatesIfWasMajorityUseCase = new ElectedCandidatesIfWasMajorityUseCase(
                                inMemoryElectionRepository);
                ElectedCandidatesBenefitedProportionalUseCase electedCandidatesBenefitedProportionalUseCase = new ElectedCandidatesBenefitedProportionalUseCase(
                                inMemoryElectionRepository);
                TotalVotesUseCase totalVotesUseCase = new TotalVotesUseCase(inMemoryElectionRepository);

                // Presentation

                View numberOfElectedCandidates = new NumberOfElectedCandidatesView(numberOfElectedCandidatesUseCase);
                View electedCandidates = new ElectedCandidatesView(electedCandidatesUseCase);
                View mostVotedCandidates = new MostVotedCandidatesView(mostVotedCandidatesUseCase);
                View electedCandidatesIfWasMajority = new ElectedCandidatesIfWasMajorityView(
                                electedCandidatesIfWasMajorityUseCase);
                View electedCandidatesBenefitedProportionalView = new ElectedCandidatesBenefitedProportionalView(
                                electedCandidatesBenefitedProportionalUseCase);
                View totalVotesView = new TotalVotesView(totalVotesUseCase);

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
