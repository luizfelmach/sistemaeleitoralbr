package presentation.terminal;

import domain.usecases.ElectedByGenderUseCase;
import presentation.View;

public class ElectedByGenderView implements View {
    ElectedByGenderUseCase electedByGenderUseCase;

    public ElectedByGenderView(ElectedByGenderUseCase electedByGenderUseCase) {
        this.electedByGenderUseCase = electedByGenderUseCase;
    }

    public void view() {
        ElectedByGenderUseCase.Result result = electedByGenderUseCase.execute();
        float femalePercent = (float) result.female / (result.total);
        float malePercent = (float) result.male / (result.total);
        System.out.println("Eleitos, por gênero:");
        System.out.printf("Feminino:  %d (%.2f%%)\n", result.female, femalePercent * 100);
        System.out.printf("Masculino: %d (%.2f%%)\n", result.male, malePercent * 100);
    }
}
