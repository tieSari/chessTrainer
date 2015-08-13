/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer.logiikka;

import chesstrainer.apuluokat.Kirjain;
import chesstrainer.apuluokat.Sijainti;
import chesstrainer.apuluokat.Tilanne;
import chesstrainer.apuluokat.Vari;
import chesstrainer.peliosat.Nappula;
import chesstrainer.peliosat.Pelilauta;
import chesstrainer.peliosat.Ruutu;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sariraut
 */
public class Logiikka {

    private int siirtojaTehty = 0;
    private final Random randomGenerator = new Random();

    public int getSiirtojaTehty() {
        return siirtojaTehty;
    }

    public void setSiirtojaTehty(int siirtojaTehty) {
        this.siirtojaTehty = siirtojaTehty;
    }

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

        siirtojaTehty++;
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
    }
}
