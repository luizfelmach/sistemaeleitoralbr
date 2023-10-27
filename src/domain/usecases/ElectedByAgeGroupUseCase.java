package domain.usecases;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import config.AppConfig;
import domain.entity.Candidate;
import domain.repository.ElectionRepository;

public class ElectedByAgeGroupUseCase {
    ElectionRepository electionRepository;

    public ElectedByAgeGroupUseCase(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public Result execute() {
        LocalDate electionDate = AppConfig.getElectionDate();
        List<Candidate> candidates = electionRepository.getElectedCandidates();
        int lessThan30 = 0;
        int between30and40 = 0;
        int between40and50 = 0;
        int between50and60 = 0;
        int greaterThan60 = 0;
        for (Candidate candidate : candidates) {
            Period period = Period.between(candidate.getBirthdayDate(), electionDate);
            int age = period.getYears();
            if (age < 30) {
                lessThan30 += 1;
                continue;
            }
            if (age < 40) {
                between30and40 += 1;
                continue;
            }
            if (age < 50) {
                between40and50 += 1;
                continue;
            }
            if (age < 60) {
                between50and60 += 1;
                continue;
            } else {
                greaterThan60 += 1;
            }
        }
        return new Result(
                lessThan30,
                between30and40,
                between40and50,
                between50and60,
                greaterThan60,
                candidates.size());
    }

    public class Result {
        public int lessThan30;
        public int between30and40;
        public int between40and50;
        public int between50and60;
        public int greaterThan60;
        public int total;

        public Result(
                int lessThan30,
                int between30and40,
                int between40and50,
                int between50and60,
                int greaterThan60,
                int total) {
            this.lessThan30 = lessThan30;
            this.between30and40 = between30and40;
            this.between40and50 = between40and50;
            this.between50and60 = between50and60;
            this.greaterThan60 = greaterThan60;
            this.total = total;
        }
    }
}
