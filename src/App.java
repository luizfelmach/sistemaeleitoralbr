import adapters.CsvElectionRepository;
import config.AppConfig;
import domain.repository.ElectionRepository;
import util.factory.UseCasesFactory;
import util.factory.ViewFactory;

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
    ViewFactory views = new ViewFactory(useCases);

    views.report1.view();
    System.out.println();

    views.report2.view();
    System.out.println();

    views.report3.view();
    System.out.println();

    views.report4.view();
    System.out.println();

    views.report5.view();
    System.out.println();

    views.report6.view();
    System.out.println();

    views.report7.view();
    System.out.println();

    views.report8.view();
    System.out.println();

    views.report9.view();
    System.out.println();

    views.report10.view();
    System.out.println();
  }
}
