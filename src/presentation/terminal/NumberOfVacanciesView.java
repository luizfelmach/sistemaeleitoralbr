package presentation.terminal;

import domain.usecases.NumberOfVacancies;
import presentation.View;

public class NumberOfVacanciesView implements View {

  NumberOfVacancies numberOfVacancies;

  public NumberOfVacanciesView(NumberOfVacancies numberOfVacancies) {
    this.numberOfVacancies = numberOfVacancies;
  }

  public void view() {
    int totalElectedCandidates = numberOfVacancies.execute();
    System.out.printf("Número de vagas: %d\n", totalElectedCandidates);
  }
}
