package util.factory;

import presentation.terminal.*;

public class ViewFactory {

  public NumberOfElectedCandidatesView report1;
  public ElectedCandidatesView report2;
  public MostVotedCandidatesView report3;
  public ElectedCandidatesIfWasMajorityView report4;
  public ElectedCandidatesBenefitedProportionalView report5;
  public VotingByPoliticalPartyView report6;
  public FirstAndLastByPoliticalPartyView report7;
  public ElectedByAgeGroupView report8;
  public ElectedByGenderView report9;
  public TotalVotesView report10;

  public ViewFactory(UseCasesFactory useCases) {
    report1 = new NumberOfElectedCandidatesView(useCases.report1);
    report2 = new ElectedCandidatesView(useCases.report2);
    report3 = new MostVotedCandidatesView(useCases.report3);
    report4 = new ElectedCandidatesIfWasMajorityView(useCases.report4);
    report5 = new ElectedCandidatesBenefitedProportionalView(useCases.report5);
    report6 = new VotingByPoliticalPartyView(useCases.report6);
    report7 = new FirstAndLastByPoliticalPartyView(useCases.report7);
    report8 = new ElectedByAgeGroupView(useCases.report8);
    report9 = new ElectedByGenderView(useCases.report9);
    report10 = new TotalVotesView(useCases.report10);
  }
}
