package presentation.terminal;

import domain.usecases.ElectedByAgeGroupUseCase;
import presentation.View;

public class ElectedByAgeGroupView implements View {
    ElectedByAgeGroupUseCase electedByAgeGroupUseCase;

    public ElectedByAgeGroupView(ElectedByAgeGroupUseCase electedByAgeGroupUseCase) {
        this.electedByAgeGroupUseCase = electedByAgeGroupUseCase;
    }

    @Override
    public void view() {
        ElectedByAgeGroupUseCase.Result result = electedByAgeGroupUseCase.execute();
        float f1 = ((float) result.lessThan30 / result.total) * 100;
        float f2 = ((float) result.between30and40 / result.total) * 100;
        float f3 = ((float) result.between40and50 / result.total) * 100;
        float f4 = ((float) result.between50and60 / result.total) * 100;
        float f5 = ((float) result.greaterThan60 / result.total) * 100;
        System.out.println("Eleitos, por faixa etária (na data da eleição):");
        System.out.printf("      Idade < 30: %d (%.2f%%)\n", result.lessThan30, f1);
        System.out.printf("30 <= Idade < 40: %d (%.2f%%)\n", result.between30and40, f2);
        System.out.printf("40 <= Idade < 50: %d (%.2f%%)\n", result.between40and50, f3);
        System.out.printf("50 <= Idade < 60: %d (%.2f%%)\n", result.between50and60, f4);
        System.out.printf("60 <= Idade     : %d (%.2f%%)\n", result.greaterThan60, f5);

    }
}
