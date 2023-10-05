package domain.usecases;

import java.time.LocalDate;
import java.util.Set;

import config.AppConfig;
import domain.entity.Candidate;
import domain.repository.ElectionRepository;

public class VotesByAgeGroupUseCase {
    ElectionRepository electionRepository;

    public VotesByAgeGroupUseCase(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public Result execute() {
        LocalDate electionDate = AppConfig.getElectionDate();
        Set<Candidate> candidates = electionRepository.getElectedCandidates();
        int lessThan30 = 0;
        int between30and40 = 0;
        int between40and50 = 0;
        int between50and60 = 0;
        int greaterThan60 = 0;
        for (Candidate candidate : candidates) {
            if (electionDate.getYear() - candidate.getBirthdayDate().getYear() < 30) {
                lessThan30 += 1;
            }
            if (electionDate.getYear() - candidate.getBirthdayDate().getYear() < 40) {
                between30and40 += 1;
            }
            if (electionDate.getYear() - candidate.getBirthdayDate().getYear() < 50) {
                between40and50 += 1;
            }
            if (electionDate.getYear() - candidate.getBirthdayDate().getYear() < 60) {
                between50and60 += 1;
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
        int lessThan30;
        int between30and40;
        int between40and50;
        int between50and60;
        int greaterThan60;
        int total;

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
