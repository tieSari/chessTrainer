package chesstrainer.peliosat;

import chesstrainer.apuluokat.Kirjain;
import chesstrainer.apuluokat.Sijainti;
import chesstrainer.apuluokat.Suunta;

/**
 *
 * @author sariraut
 */
public class Pelilauta {

    private final Ruutu[][] ruudut;

    public Pelilauta() {
        this.ruudut = new Ruutu[8][8];
        luoLauta();
    }

    private void luoLauta() {
        luoRuudut();
        asetaNaapuriRuudut();
    }

    private void luoRuudut() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                ruudut[i][j] = new Ruutu(new Sijainti(Kirjain.get(i), j + 1));
            }

        }

    }

    public Ruutu getRuutu(Sijainti sijainti) {
        return ruudut[sijainti.getKirjain().getValue()][sijainti.getNumero() - 1];
    }

    private void asetaNaapuriRuudut() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (j < 7) {
                    ruudut[i][j].setNaapuriRuutu(ruudut[i][j + 1], Suunta.ita);
                    if (i < 7) {
                        ruudut[i][j].setNaapuriRuutu(ruudut[i + 1][j + 1], Suunta.koillinen);
                    }
                    if (i > 0) {
                        ruudut[i][j].setNaapuriRuutu(ruudut[i - 1][j + 1], Suunta.kaakko);
                    }
                }
                if (i < 7) {
                    ruudut[i][j].setNaapuriRuutu(ruudut[i + 1][j],Suunta.pohjoinen);

                    if (j > 0) {
                        ruudut[i][j].setNaapuriRuutu(ruudut[i + 1][j - 1], Suunta.luode);
                    }
                }
                if (j > 0) {
                    ruudut[i][j].setNaapuriRuutu(ruudut[i][j - 1], Suunta.lansi);
                    if (i > 0) {
                        ruudut[i][j].setNaapuriRuutu(ruudut[i - 1][j - 1], Suunta.lounas);
                    }
                }
                if (i > 0) {
                    ruudut[i][j].setNaapuriRuutu(ruudut[i - 1][j], Suunta.etela);
                }

            }

        }
    }

    @Override
    public String toString() {
        String tulostus = "";
        for (int i = 0; i < 8; i++) {
            tulostus += "\n";
            for (int j = 0; j < 8; j++) {

                tulostus += ruudut[i][j].toString();
            }
        }

        return tulostus;
    }
}
