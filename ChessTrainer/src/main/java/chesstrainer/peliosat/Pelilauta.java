package chesstrainer.peliosat;

import chesstrainer.rakenteet.Nappula;
import chesstrainer.apuluokat.*;
import java.util.ArrayList;

/**
 * Pelilauta-luokka vastaa ruutujen luonnista ja niiden naapuriruutujen
 * tallennuksesta. Se tietää laudalla olevat nappulat ja huolehtii niiden
 * vaikutusruutujen ylläpidosta.
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

    public Nappula getNappula(Sijainti sijainti) {
        for (Nappula nappula : getNappulat()) {
            if (nappula.getSijaintiRuutu().equals(new Ruutu(sijainti))) {
                return nappula;
            }
        }
        return null;
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

    /**
     * Kun uusi peli aloitetaan tyhjennetään lauta shakeista ja nappuloista.
     *
     */
    public void tyhjennaLauta() {
        TyhjennaRuudutShakeista();
        TyhjennaRuudut();
        setNappulat(new ArrayList<Nappula>());
    }

    private void luoRuudut() {

        Vari vari = Vari.Musta;
        for (int i = 0; i < 8; i++) {
            vari = vari == Vari.Valkea ? Vari.Musta : Vari.Valkea;
            for (int j = 0; j < 8; j++) {

                ruudut[i][j] = new Ruutu(new Sijainti(Kirjain.get(j), 8 - i), vari);
                vari = vari == Vari.Valkea ? Vari.Musta : Vari.Valkea;
            }
        }
    }

    public Ruutu[][] getRuudut() {
        return ruudut;
    }

    public Ruutu getRuutu(Sijainti sijainti) {

        return ruudut[7 - (sijainti.getNumero() - 1)][sijainti.getKirjain().getValue()];
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

    /**
     * Jokaisen valkean ja mustan siirron jälkeen tyhjentää pelilaudan ruudut
     * shakeista ja asettaa nappuloiden vaikutusruudut uudelleen, koska nappulan
     * siirrolla voi olla vaikutusta toisten nappuloiden vaikutusruutuihin.
     */
    public void TeeSiirronJalkeisetToimet() {
        TyhjennaRuudutShakeista();
        AsetaNappuloidenVaikutusRuudut();
        TarkistaSuojaukset();
    }

    private void TyhjennaRuudutShakeista() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ruudut[i][j].setValkeaShakkaa(false);
                ruudut[i][j].setMustaShakkaa(false);
            }

        }
    }

    private void TyhjennaRuudut() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ruudut[i][j].setNappula(null);
            }

        }
    }

    private void AsetaNappuloidenVaikutusRuudut() {
        for (Nappula nappula : getNappulat()) {
            nappula.asetaShakkiruudut();
            System.out.println(nappula.getArvo() + nappula.getVari().toString() + nappula.getShakkiRuudut());
        }
        System.out.println("");

    }

    private void TarkistaSuojaukset() {
        for (Nappula nappula : getNappulat()) {

            if (nappula.getVari() == Vari.Musta || nappula.getSijaintiRuutu() == null) {
                continue;
            }
            nappula.setOnSuojattu(false);

            if (nappula.getSijaintiRuutu().isValkeaShakkaa()) {
                nappula.setOnSuojattu(true);
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
