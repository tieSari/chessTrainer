package chesstrainer.peliosat;

import chesstrainer.apuluokat.Kirjain;
import chesstrainer.apuluokat.Sijainti;
import chesstrainer.apuluokat.Suunta;
import java.util.ArrayList;

/**
 *
 * @author sariraut
 */
public class Pelilauta {

    private final Ruutu[][] ruudut;
    private ArrayList<Nappula> nappulat; 

    public Pelilauta() {
        this.ruudut = new Ruutu[8][8];
        this.nappulat = new ArrayList<>();
        luoLauta();
    }

    public ArrayList<Nappula> getNappulat() {
        return nappulat;
    }

    public void setNappulat(ArrayList<Nappula> nappulat) {
        this.nappulat = nappulat;
    }

    public void addNappula(Nappula nappula) {
        this.nappulat.add(nappula);
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

    public Ruutu[][] getRuudut() {
        return ruudut;
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
                    ruudut[i][j].setNaapuriRuutu(ruudut[i + 1][j], Suunta.pohjoinen);

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

    public void TeeSiirronJalkeisetToimet() {
        TyhjennaRuudutShakeista();
        AsetaNappuloidenVaikutusRuudut();
    }

    private void TyhjennaRuudutShakeista() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ruudut[i][j].setValkeaShakkaa(false);
                ruudut[i][j].setMustaShakkaa(false);
            }

        }
    }

    private void AsetaNappuloidenVaikutusRuudut() {
        for (Nappula nappula : getNappulat()) {
            nappula.asetaShakkiruudut();
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
