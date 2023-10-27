package util.factory;

import java.util.Arrays;
import java.util.List;
import presentation.View;
import presentation.terminal.*;

public class ViewsFactory {

  public NumberOfVacanciesView report1;
  public ElectedCandidatesView report2;
  public MostVotedCandidatesView report3;
  public CandidatesWouldBeElectedInMajorityView report4;
  public ElectedCandidatesInProportionalSystemView report5;
  public VotesByPartyAndElectedCandidatesView report6;
  public FirstAndLastCandidatesOfEachPartyView report7;
  public ElectedByAgeGroupView report8;
  public ElectedByGenderView report9;
  public TotalVotesView report10;

  public ViewsFactory(UseCasesFactory useCases) {
    report1 = new NumberOfVacanciesView(useCases.report1);
    report2 = new ElectedCandidatesView(useCases.report2);
    report3 = new MostVotedCandidatesView(useCases.report3);
    report4 = new CandidatesWouldBeElectedInMajorityView(useCases.report4);
    report5 = new ElectedCandidatesInProportionalSystemView(useCases.report5);
    report6 = new VotesByPartyAndElectedCandidatesView(useCases.report6);
    report7 = new FirstAndLastCandidatesOfEachPartyView(useCases.report7);
    report8 = new ElectedByAgeGroupView(useCases.report8);
    report9 = new ElectedByGenderView(useCases.report9);
    report10 = new TotalVotesView(useCases.report10);
  }

  public List<View> all() {
    return Arrays.asList(
      report1,
      report2,
      report3,
      report4,
      report5,
      report6,
      report7,
      report8,
      report9,
      report10
    );
  }
}
