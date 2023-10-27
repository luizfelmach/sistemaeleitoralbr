package util.factory;

import domain.repository.ElectionRepository;
import domain.usecases.*;

public class UseCasesFactory {

  public NumberOfElectedCandidatesUseCase report1;
  public ElectedCandidatesUseCase report2;
  public MostVotedCandidatesUseCase report3;
  public ElectedCandidatesIfWasMajorityUseCase report4;
  public ElectedCandidatesBenefitedProportionalUseCase report5;
  public VotingByPoliticalPartyUseCase report6;
  public FirstAndLastByPoliticalPartyUseCase report7;
  public ElectedByAgeGroupUseCase report8;
  public ElectedByGenderUseCase report9;
  public TotalVotesUseCase report10;

  public UseCasesFactory(ElectionRepository electionRepository) {
    report1 = new NumberOfElectedCandidatesUseCase(electionRepository);
    report2 = new ElectedCandidatesUseCase(electionRepository);
    report3 = new MostVotedCandidatesUseCase(electionRepository);
    report4 = new ElectedCandidatesIfWasMajorityUseCase(electionRepository);
    report5 =
      new ElectedCandidatesBenefitedProportionalUseCase(electionRepository);
    report6 = new VotingByPoliticalPartyUseCase(electionRepository);
    report7 = new FirstAndLastByPoliticalPartyUseCase(electionRepository);
    report8 = new ElectedByAgeGroupUseCase(electionRepository);
    report9 = new ElectedByGenderUseCase(electionRepository);
    report10 = new TotalVotesUseCase(electionRepository);
  }
}
