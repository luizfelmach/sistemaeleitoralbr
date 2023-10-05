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
        int totalElectedCandidates = electedCandidates.size();
        for (Candidate candidate : electedCandidates) {
            if (candidate.getGenre() == Genre.FEMALE) {
                totalFemale += 1;
            } else {
                totalMale += 1;
            }
        }
        return new Result(totalFemale / totalElectedCandidates, totalMale / totalElectedCandidates);
    }

    public class Result {
        public float female;
        public float male;

        public Result(float female, float male) {
            this.female = female;
            this.male = male;
        }
    }
}
