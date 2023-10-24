package adapters;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import config.AppConfig;
import domain.entity.Candidate;
import domain.entity.PoliticalParty;
import domain.repository.ElectionRepository;

public class InMemoryElectionRepository implements ElectionRepository {
    private Map<String, Candidate> candidates = new HashMap<>();
    private Map<String, PoliticalParty> politicalParties = new HashMap<>();

    public InMemoryElectionRepository() {
        try (
                FileInputStream fin = new FileInputStream(AppConfig.fileOfCandidate);
                InputStreamReader r = new InputStreamReader(fin, "ISO-8859-1");
                BufferedReader br = new BufferedReader(r);) {

            String line;
            line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] fields = line.split(";");

                String CD_CARGO = fields[13].split("\"")[1];
                String CD_SITUACAO_CANDIDATO_TOT = fields[69].split("\"")[1];
                String NM_URNA_CANDIDATO = fields[18].split("\"")[1];
                String NR_CANDIDATO = fields[16].split("\"")[1];
                String NR_PARTIDO = fields[27].split("\"")[1];
                String SG_PARTIDO = fields[28].split("\"")[1];
                String NR_FEDERACAO = fields[30].split("\"")[1];
                String DT_NASCIMENTO = fields[42].split("\"")[1];
                String CD_SIT_TOT_TURNO = fields[56].split("\"")[1];
                String CD_GENERO = fields[45].split("\"")[1];
                String NM_TIPO_DESTINACAO_VOTOS = fields[68].split("\"")[1];

                // Candidate candidate = new Candidate(line, null, false, null, null);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Candidate> getAllCandidates() {
        return new HashSet<>(candidates.values());
    }

    @Override
    public Set<Candidate> getElectedCandidates() {
        Set<Candidate> electedCandidates = new HashSet<>();
        for (Candidate candidate : candidates.values()) {
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
        List<Candidate> allCandidates = new ArrayList<>(candidates.values());
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
        return new HashSet<>(politicalParties.values());
    }
}
