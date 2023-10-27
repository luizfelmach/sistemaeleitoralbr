package adapters.helpers;

import config.AppConfig;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFileOfVoting {

  private FileInputStream fin;
  private InputStreamReader r;
  private BufferedReader br;
  private String nextLine;

  public ReadFileOfVoting() {
    try {
      fin = new FileInputStream(AppConfig.fileOfVoting);
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

  public FieldsFileOfVoting next() {
    int CD_CARGO = 0;
    int NR_VOTAVEL = 0;
    int QT_VOTOS = 0;

    try {
      String[] fields = nextLine.split(";");

      CD_CARGO = Integer.parseInt(fields[17].split("\"")[1]);
      NR_VOTAVEL = Integer.parseInt(fields[19].split("\"")[1]);
      QT_VOTOS = Integer.parseInt(fields[21].split("\"")[1]);

      nextLine = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return new FieldsFileOfVoting(CD_CARGO, NR_VOTAVEL, QT_VOTOS);
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

  public class FieldsFileOfVoting {

    public final int CD_CARGO;
    public final int NR_VOTAVEL;
    public final int QT_VOTOS;

    public FieldsFileOfVoting(int CD_CARGO, int NR_VOTAVEL, int QT_VOTOS) {
      this.CD_CARGO = CD_CARGO;
      this.NR_VOTAVEL = NR_VOTAVEL;
      this.QT_VOTOS = QT_VOTOS;
    }
  }
}
