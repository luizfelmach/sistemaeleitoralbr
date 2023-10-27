package util.factory;

import domain.repository.ElectionRepository;
import domain.usecases.*;

public class UseCasesFactory {

  public NumberOfVacancies report1;
  public ElectedCandidates report2;
  public MostVotedCandidates report3;
  public CandidatesWouldBeElectedInMajority report4;
  public ElectedCandidatesInProportionalSystem report5;
  public VotesByPartyAndElectedCandidates report6;
  public FirstAndLastCandidatesOfEachParty report7;
  public ElectedCandidatesAgeDistribution report8;
  public ElectedCandidatesGenderDistribution report9;
  public TotalVotes report10;

  public UseCasesFactory(ElectionRepository electionRepository) {
    report1 = new NumberOfVacancies(electionRepository);
    report2 = new ElectedCandidates(electionRepository);
    report3 = new MostVotedCandidates(electionRepository);
    report4 = new CandidatesWouldBeElectedInMajority(electionRepository);
    report5 = new ElectedCandidatesInProportionalSystem(electionRepository);
    report6 = new VotesByPartyAndElectedCandidates(electionRepository);
    report7 = new FirstAndLastCandidatesOfEachParty(electionRepository);
    report8 = new ElectedCandidatesAgeDistribution(electionRepository);
    report9 = new ElectedCandidatesGenderDistribution(electionRepository);
    report10 = new TotalVotes(electionRepository);
  }
}
