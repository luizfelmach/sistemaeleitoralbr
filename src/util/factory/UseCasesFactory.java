package util.factory;

import domain.repository.ElectionRepository;
import domain.usecases.*;

public class UseCasesFactory {

  public NumberOfVacancies report1;
  public ElectedCandidates report2;
  public MostVotedCandidates report3;
  public CandidatesWouldBeElectedInMajority report4;
  public ElectedCandidatesBenefitedProportionalUseCase report5;
  public VotingByPoliticalPartyUseCase report6;
  public FirstAndLastByPoliticalPartyUseCase report7;
  public ElectedByAgeGroupUseCase report8;
  public ElectedByGenderUseCase report9;
  public TotalVotesUseCase report10;

  public UseCasesFactory(ElectionRepository electionRepository) {
    report1 = new NumberOfVacancies(electionRepository);
    report2 = new ElectedCandidates(electionRepository);
    report3 = new MostVotedCandidates(electionRepository);
    report4 = new CandidatesWouldBeElectedInMajority(electionRepository);
    report5 =
      new ElectedCandidatesBenefitedProportionalUseCase(electionRepository);
    report6 = new VotingByPoliticalPartyUseCase(electionRepository);
    report7 = new FirstAndLastByPoliticalPartyUseCase(electionRepository);
    report8 = new ElectedByAgeGroupUseCase(electionRepository);
    report9 = new ElectedByGenderUseCase(electionRepository);
    report10 = new TotalVotesUseCase(electionRepository);
  }
}
