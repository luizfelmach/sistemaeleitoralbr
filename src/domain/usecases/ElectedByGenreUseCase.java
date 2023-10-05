package domain.usecases;

import java.util.Set;

import domain.entity.Candidate;
import domain.entity.Candidate.Genre;
import domain.repository.ElectionRepository;

public class ElectedByGenreUseCase {
    ElectionRepository electionRepository;

    public ElectedByGenreUseCase(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public Result execute() {
        Set<Candidate> electedCandidates = electionRepository.getElectedCandidates();
        int totalFemale = 0;
        int totalMale = 0;
        for (Candidate candidate : electedCandidates) {
            if (candidate.getGenre() == Genre.FEMALE) {
                totalFemale += 1;
            } else {
                totalMale += 1;
            }
        }
        return new Result(totalFemale, totalMale, electedCandidates.size());
    }

    public class Result {
        public int female;
        public int male;
        public int total;

        public Result(int female, int male, int total) {
            this.female = female;
            this.male = male;
            this.total = total;
        }
    }
}
