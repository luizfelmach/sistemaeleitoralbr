import adapters.InMemoryElectionRepository;
import config.AppConfig;
import config.AppConfig.ElectionType;
import domain.repository.ElectionRepository;
import domain.usecases.ElectedByAgeGroupUseCase;
import domain.usecases.ElectedByGenderUseCase;
import domain.usecases.ElectedCandidatesBenefitedProportionalUseCase;
import domain.usecases.ElectedCandidatesIfWasMajorityUseCase;
import domain.usecases.ElectedCandidatesUseCase;
import domain.usecases.FirstAndLastByPoliticalPartyUseCase;
import domain.usecases.MostVotedCandidatesUseCase;
import domain.usecases.NumberOfElectedCandidatesUseCase;
import domain.usecases.TotalVotesUseCase;
import domain.usecases.VotingByPoliticalPartyUseCase;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import presentation.View;
import presentation.terminal.ElectedByAgeGroupView;
import presentation.terminal.ElectedByGenderView;
import presentation.terminal.ElectedCandidatesBenefitedProportionalView;
import presentation.terminal.ElectedCandidatesIfWasMajorityView;
import presentation.terminal.ElectedCandidatesView;
import presentation.terminal.FirstAndLastByPoliticalPartyView;
import presentation.terminal.MostVotedCandidatesView;
import presentation.terminal.NumberOfElectedCandidatesView;
import presentation.terminal.TotalVotesView;
import presentation.terminal.VotingByPoliticalPartyView;
import util.exceptions.IllegalArgumentException;

public class App {

  public static void main(String[] args) {
    if (args.length != 4) {
      System.err.println(
        "usage: java -jar deputados.jar [--estadual/--federal] [file of candidates] [file of voting] dd/mm/yyyy]"
      );
      System.exit(1);
    }
    setupElectionType(args[0]);
    setupFileOfCandidates(args[1]);
    setupFileOfVoting(args[2]);
    setupElectionDate(args[3]);

    ElectionRepository electionRepository = new InMemoryElectionRepository();

    NumberOfElectedCandidatesUseCase numberOfElectedCandidatesUseCase = new NumberOfElectedCandidatesUseCase(
      electionRepository
    );
    ElectedCandidatesUseCase electedCandidatesUseCase = new ElectedCandidatesUseCase(
      electionRepository
    );
    MostVotedCandidatesUseCase mostVotedCandidatesUseCase = new MostVotedCandidatesUseCase(
      electionRepository
    );
    ElectedCandidatesIfWasMajorityUseCase electedCandidatesIfWasMajorityUseCase = new ElectedCandidatesIfWasMajorityUseCase(
      electionRepository
    );
    ElectedCandidatesBenefitedProportionalUseCase electedCandidatesBenefitedProportionalUseCase = new ElectedCandidatesBenefitedProportionalUseCase(
      electionRepository
    );
    VotingByPoliticalPartyUseCase votingByPoliticalPartyUseCase = new VotingByPoliticalPartyUseCase(
      electionRepository
    );
    FirstAndLastByPoliticalPartyUseCase firstAndLastByPoliticalPartyUseCase = new FirstAndLastByPoliticalPartyUseCase(
      electionRepository
    );
    ElectedByAgeGroupUseCase electedByAgeGroupUseCase = new ElectedByAgeGroupUseCase(
      electionRepository
    );
    ElectedByGenderUseCase electedByGenderUseCase = new ElectedByGenderUseCase(
      electionRepository
    );
    TotalVotesUseCase totalVotesUseCase = new TotalVotesUseCase(
      electionRepository
    );

    View numberOfElectedCandidates = new NumberOfElectedCandidatesView(
      numberOfElectedCandidatesUseCase
    );
    View electedCandidates = new ElectedCandidatesView(
      electedCandidatesUseCase
    );
    View mostVotedCandidates = new MostVotedCandidatesView(
      mostVotedCandidatesUseCase
    );
    View electedCandidatesIfWasMajority = new ElectedCandidatesIfWasMajorityView(
      electedCandidatesIfWasMajorityUseCase
    );
    View electedCandidatesBenefitedProportionalView = new ElectedCandidatesBenefitedProportionalView(
      electedCandidatesBenefitedProportionalUseCase
    );
    View votingByPoliticalPartyView = new VotingByPoliticalPartyView(
      votingByPoliticalPartyUseCase
    );
    View firstAndLastByPoliticalPartyView = new FirstAndLastByPoliticalPartyView(
      firstAndLastByPoliticalPartyUseCase
    );
    View electedByAgeGroupView = new ElectedByAgeGroupView(
      electedByAgeGroupUseCase
    );
    View electedByGenderView = new ElectedByGenderView(electedByGenderUseCase);
    View totalVotesView = new TotalVotesView(totalVotesUseCase);

    numberOfElectedCandidates.view();
    System.out.println();

    electedCandidates.view();
    System.out.println();

    mostVotedCandidates.view();
    System.out.println();

    electedCandidatesIfWasMajority.view();
    System.out.println();

    electedCandidatesBenefitedProportionalView.view();
    System.out.println();

    votingByPoliticalPartyView.view();
    System.out.println();

    firstAndLastByPoliticalPartyView.view();
    System.out.println();

    electedByAgeGroupView.view();
    System.out.println();

    electedByGenderView.view();
    System.out.println();

    totalVotesView.view();
    System.out.println();
  }

  public static void setupElectionType(String electionType) {
    if (electionType.equals("--estadual")) {
      AppConfig.setElectionType(ElectionType.STATE);
      return;
    }
    if (electionType.equals("--federal")) {
      AppConfig.setElectionType(ElectionType.FEDERAL);
      return;
    }
    throw new IllegalArgumentException(electionType);
  }

  public static void setupFileOfCandidates(String fileOfCandidates) {
    AppConfig.fileOfCandidate = fileOfCandidates;
  }

  public static void setupFileOfVoting(String fileOfVoting) {
    AppConfig.fileOfVoting = fileOfVoting;
  }

  public static void setupElectionDate(String electionDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
    AppConfig.setElectionDate(LocalDate.parse(electionDate, formatter));
  }
}
