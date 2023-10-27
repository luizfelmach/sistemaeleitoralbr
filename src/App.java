import adapters.CsvElectionRepository;
import config.AppConfig;
import domain.repository.ElectionRepository;
import presentation.View;
import util.factory.UseCasesFactory;
import util.factory.ViewsFactory;

public class App {

  public static void main(String[] args) {
    if (args.length != 4) {
      System.err.println(
        "usage: java -jar deputados.jar [--estadual/--federal] [file of candidates] [file of voting] dd/mm/yyyy]"
      );
      System.exit(1);
    }

    AppConfig.setupElectionType(args[0]);
    AppConfig.setupFileOfCandidates(args[1]);
    AppConfig.setupFileOfVoting(args[2]);
    AppConfig.setupElectionDate(args[3]);

    ElectionRepository electionRepository = new CsvElectionRepository();
    UseCasesFactory useCases = new UseCasesFactory(electionRepository);
    ViewsFactory views = new ViewsFactory(useCases);

    for (View report : views.all()) {
      report.view();
      System.out.println();
    }
  }
}
