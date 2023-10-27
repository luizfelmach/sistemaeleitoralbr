package adapters.helpers;

import config.AppConfig;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReadFileOfCandidate {

  private FileInputStream fin;
  private InputStreamReader r;
  private BufferedReader br;
  private String nextLine;

  public ReadFileOfCandidate() {
    try {
      fin = new FileInputStream(AppConfig.fileOfCandidates);
      r = new InputStreamReader(fin, "ISO-8859-1");
      br = new BufferedReader(r);
      nextLine = br.readLine();
      nextLine = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean hasMore() {
    return nextLine != null;
  }

  public FieldsFileOfCandidate next() {
    int CD_CARGO = 0;
    int CD_SITUACAO_CANDIDATO_TOT = 0;
    String NM_URNA_CANDIDATO = "";
    int NR_CANDIDATO = 0;
    int NR_PARTIDO = 0;
    String SG_PARTIDO = "";
    int NR_FEDERACAO = 0;
    LocalDate DT_NASCIMENTO = null;
    int CD_SIT_TOT_TURNO = 0;
    int CD_GENERO = 0;
    String NM_TIPO_DESTINACAO_VOTOS = "";

    try {
      String[] fields = nextLine.split(";");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

      CD_CARGO = Integer.parseInt(fields[13].split("\"")[1]);
      CD_SITUACAO_CANDIDATO_TOT = Integer.parseInt(fields[68].split("\"")[1]);
      NM_URNA_CANDIDATO = fields[18].split("\"")[1];
      NR_CANDIDATO = Integer.parseInt(fields[16].split("\"")[1]);
      NR_PARTIDO = Integer.parseInt(fields[27].split("\"")[1]);
      SG_PARTIDO = fields[28].split("\"")[1];
      NR_FEDERACAO = Integer.parseInt(fields[30].split("\"")[1]);
      DT_NASCIMENTO =
        LocalDate.parse(
          fields[42].split("\"").length > 0
            ? fields[42].split("\"")[1]
            : "02/02/2022",
          formatter
        );
      CD_SIT_TOT_TURNO = Integer.parseInt(fields[56].split("\"")[1]);
      CD_GENERO = Integer.parseInt(fields[45].split("\"")[1]);
      NM_TIPO_DESTINACAO_VOTOS = fields[67].split("\"")[1];

      nextLine = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return new FieldsFileOfCandidate(
      CD_CARGO,
      CD_SITUACAO_CANDIDATO_TOT,
      NM_URNA_CANDIDATO,
      NR_CANDIDATO,
      NR_PARTIDO,
      SG_PARTIDO,
      NR_FEDERACAO,
      DT_NASCIMENTO,
      CD_SIT_TOT_TURNO,
      CD_GENERO,
      NM_TIPO_DESTINACAO_VOTOS
    );
  }

  public void close() {
    try {
      fin.close();
      r.close();
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public class FieldsFileOfCandidate {

    public final int CD_CARGO;
    public final int CD_SITUACAO_CANDIDATO_TOT;
    public final String NM_URNA_CANDIDATO;
    public final int NR_CANDIDATO;
    public final int NR_PARTIDO;
    public final String SG_PARTIDO;
    public final int NR_FEDERACAO;
    public final LocalDate DT_NASCIMENTO;
    public final int CD_SIT_TOT_TURNO;
    public final int CD_GENERO;
    public final String NM_TIPO_DESTINACAO_VOTOS;

    public FieldsFileOfCandidate(
      int CD_CARGO,
      int CD_SITUACAO_CANDIDATO_TOT,
      String NM_URNA_CANDIDATO,
      int NR_CANDIDATO,
      int NR_PARTIDO,
      String SG_PARTIDO,
      int NR_FEDERACAO,
      LocalDate DT_NASCIMENTO,
      int CD_SIT_TOT_TURNO,
      int CD_GENERO,
      String NM_TIPO_DESTINACAO_VOTOS
    ) {
      this.CD_CARGO = CD_CARGO;
      this.CD_SITUACAO_CANDIDATO_TOT = CD_SITUACAO_CANDIDATO_TOT;
      this.NM_URNA_CANDIDATO = NM_URNA_CANDIDATO;
      this.NR_CANDIDATO = NR_CANDIDATO;
      this.NR_PARTIDO = NR_PARTIDO;
      this.SG_PARTIDO = SG_PARTIDO;
      this.NR_FEDERACAO = NR_FEDERACAO;
      this.DT_NASCIMENTO = DT_NASCIMENTO;
      this.CD_SIT_TOT_TURNO = CD_SIT_TOT_TURNO;
      this.CD_GENERO = CD_GENERO;
      this.NM_TIPO_DESTINACAO_VOTOS = NM_TIPO_DESTINACAO_VOTOS;
    }
  }
}
