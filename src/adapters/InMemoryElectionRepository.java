package adapters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.entity.Candidate;
import domain.entity.PoliticalParty;
import domain.repository.ElectionRepository;

public class InMemoryElectionRepository implements ElectionRepository {
    private Set<Candidate> candidates = new HashSet<>();

    public InMemoryElectionRepository() {
        candidates.add(new Candidate("Lula", new PoliticalParty("PT"), true));
        candidates.add(new Candidate("Fulano", new PoliticalParty("PT"), true));
        candidates.add(new Candidate("John Doe", new PoliticalParty("PSOl"), true));
        candidates.add(new Candidate("Sicrano", new PoliticalParty("PTdoB"), true));
        candidates.add(new Candidate("Bolsonaro", new PoliticalParty("PTB"), true));
        candidates.add(new Candidate("MARCELO SANTOS", new PoliticalParty("PTB"), false));
        candidates.add(new Candidate("BRUNO SILVA", new PoliticalParty("PC"), false));
        candidates.add(new Candidate("PEDRO SILVA", new PoliticalParty("REPUBLICANOS"), false));
        candidates.add(new Candidate("JOAO SILVA", new PoliticalParty("PTB"), false));
        candidates.add(new Candidate("MARIA SILVA", new PoliticalParty("PCB"), false));
    }

    @Override
    public Set<Candidate> getAllCandidates() {
        return new HashSet<>(candidates);
    }

    @Override
    public Set<Candidate> getElectedCandidates() {
        Set<Candidate> electedCandidates = new HashSet<>();
        for (Candidate candidate : candidates) {
            if (candidate.isElected()) {
                electedCandidates.add(candidate);
            }
        }
        return electedCandidates;
    }

    @Override
    public int getNumberOfElectedCandidates() {
        return getElectedCandidates().size();
    }

    @Override
    public List<Candidate> getMostVotedCandidates() {
        List<Candidate> allCandidates = new ArrayList<>(candidates);
        Collections.sort(allCandidates, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate c1, Candidate c2) {
                return c2.getTotalVotes() - c1.getTotalVotes();
            }
        });
        int position = 1;
        for (Candidate candidate : allCandidates) {
            candidate.setRankingMostVoted(position);
            position += 1;
        }
        return allCandidates;
    }

    @Override
    public Set<PoliticalParty> getAllPoliticalParty() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllPoliticalParty'");
    }
}
