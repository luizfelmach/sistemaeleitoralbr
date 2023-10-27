package presentation.terminal;

import domain.usecases.ElectedCandidatesGenderDistribution;
import presentation.View;

public class ElectedCandidatesGenderDistributionView implements View {

  ElectedCandidatesGenderDistribution electedCandidatesGenderDistribution;

  public ElectedCandidatesGenderDistributionView(
    ElectedCandidatesGenderDistribution electedCandidatesGenderDistribution
  ) {
    this.electedCandidatesGenderDistribution =
      electedCandidatesGenderDistribution;
  }

  public void view() {
    ElectedCandidatesGenderDistribution.Result result = electedCandidatesGenderDistribution.execute();
    float femalePercent = (float) result.female / (result.total);
    float malePercent = (float) result.male / (result.total);
    System.out.println("Eleitos, por gênero:");
    System.out.printf(
      "Feminino:  %d (%.2f%%)\n",
      result.female,
      femalePercent * 100
    );
    System.out.printf(
      "Masculino: %d (%.2f%%)\n",
      result.male,
      malePercent * 100
    );
  }
}
