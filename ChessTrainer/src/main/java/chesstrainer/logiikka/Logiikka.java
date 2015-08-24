package chesstrainer.logiikka;

import chesstrainer.apuluokat.*;
import chesstrainer.peliosat.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Ohjelman pelilogiikkaan liittyvät toiminnot
 *
 */
public class Logiikka {

    private int siirtojaTehty = 0;
    private final Random randomGenerator = new Random();

    public int getSiirtojaTehty() {
        return siirtojaTehty;
    }

    public void setSiirtojaTehty() {
        this.siirtojaTehty++;
    }

    /**
     * Pelin alussa arvotaan loppupeliin kuuluvien nappuloiden alkuasemat. Jos
     * arvottu sijainti on vastustajan nappulan vaikutusruudulla, arvotaan uusi
     * sijainti.
     *
     * @param lauta
     */
    public void ArvoAlkuasema(Pelilauta lauta) {

        ArrayList<Nappula> nappulat = lauta.getNappulat();

        for (Nappula nappula : nappulat) {
            nappula.setSijaintiRuutu(ArvoRuutu(lauta, nappula.getVari()));
            lauta.TeeSiirronJalkeisetToimet();
            System.out.println(nappula.toString());
        }
    }

    private Ruutu ArvoRuutu(Pelilauta lauta, Vari vari) {

        while (true) {
            Ruutu ruutu = lauta.getRuutu(ArvoSijainti());
            if (ruutu.getNappula() == null) {
                if ((vari == Vari.Valkea && !ruutu.isMustaShakkaa())
                        || (vari == Vari.Musta && !ruutu.isValkeaShakkaa())) {
                    return ruutu;
                }
            }
        }
    }

    private Sijainti ArvoSijainti() {

        Kirjain k = Kirjain.get(randomGenerator.nextInt(8));
        int luku = randomGenerator.nextInt(8) + 1;

        return new Sijainti(k, luku);
    }

    public Tilanne SiirraMustaKunkku(Nappula kunkku) {
        try {

            setSiirtojaTehty();
            if (siirtojaTehty >= 50) {
                return Tilanne.SIIRROT_TAYNNA;
            }

            ArrayList<Ruutu> vierusRuudut = kunkku.getShakkiRuudut();
            int lkm = vierusRuudut.size();
            //arvotaan ruutu, josta mahdollisten siirtojen tutkiminen aloitetaan
            int eka = randomGenerator.nextInt(lkm);

            for (int i = 0; i < lkm; i++) {
                Ruutu ruutu = vierusRuudut.get(eka);
                if (!ruutu.isValkeaShakkaa() && ruutu.getNappula() == null) {
                    kunkku.Liikkuu(ruutu);
                    return Tilanne.OK;
                }
                eka = eka < (lkm - 1) ? eka + 1 : 0;
            }
            if (kunkku.getSijaintiRuutu().isValkeaShakkaa()) {
                return Tilanne.MATTI;
            } else {
                return Tilanne.PATTI;
            }
        } catch (Exception e) {
            System.out.println("Virhe mustan kunkun siirrossa."+e.getMessage());
        }
        return Tilanne.VIRHE;
    }
}
