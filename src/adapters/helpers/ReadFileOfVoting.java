package adapters.helpers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import config.AppConfig;

public class ReadFileOfVoting {
    private FileInputStream fin;
    private InputStreamReader r;
    private BufferedReader br;
    private String nextLine;

    public ReadFileOfVoting() {
        try {
            fin = new FileInputStream(AppConfig.fileOfCandidate);
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
        String CD_CARGO = "";
        String NR_VOTAVEL = "";
        int QT_VOTOS = 0;

        try {

            String[] fields = nextLine.split(";");

            CD_CARGO = fields[17].split("\"")[1];
            NR_VOTAVEL = fields[19].split("\"")[1];
            try {
                QT_VOTOS = Integer.parseInt(fields[21].split("\"")[1]);
            } catch (NumberFormatException e) {

            } finally {
                QT_VOTOS = 0;
            }

            nextLine = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new FieldsFileOfVoting(
                CD_CARGO,
                NR_VOTAVEL,
                QT_VOTOS);
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
        public final String CD_CARGO;
        public final String NR_VOTAVEL;
        public final int QT_VOTOS;

        public FieldsFileOfVoting(
                String CD_CARGO,
                String NR_VOTAVEL,
                int QT_VOTOS) {
            this.CD_CARGO = CD_CARGO;
            this.NR_VOTAVEL = NR_VOTAVEL;
            this.QT_VOTOS = QT_VOTOS;
        }
    }
}
