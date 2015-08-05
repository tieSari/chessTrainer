/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer.logiikka;

import chesstrainer.apuluokat.Kirjain;
import chesstrainer.apuluokat.Sijainti;
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

    private final Random randomGenerator = new Random();

    public void ArvoAlkuasema(ArrayList<Nappula> nappulat, Pelilauta lauta) {

        for (int i = 0; i < nappulat.size(); ++i) {
            nappulat.get(i).setSijainti(ArvoRuutu(lauta, nappulat.get(i).getVari()));
            System.out.println(nappulat.get(i).toString());
        }
    }

    private Ruutu ArvoRuutu(Pelilauta lauta, Vari vari) {

        while (true) {
            Ruutu ruutu = lauta.getRuutu(ArvoSijainti());
            if (ruutu.getNappula() == null) {
                if (vari == Vari.Valkea && !ruutu.isMustaShakkaa()
                        || vari == Vari.Musta && !ruutu.isValkeaShakkaa()) {
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

}
