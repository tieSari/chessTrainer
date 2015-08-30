package chesstrainer.ui;

import chesstrainer.rakenteet.*;
import chesstrainer.apuluokat.*;
import chesstrainer.logiikka.*;
import chesstrainer.peliosat.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Testikäyttöliittymä koodausvaiheen toiminnallisuuden testaamiseen
 *
 */
public class TekstiKayttis {

    private final Pelilauta pelilauta;
    private final Scanner lukija;
    private final Logiikka logiikka;

    public TekstiKayttis(Pelilauta pelilauta, Logiikka logiikka) {

        this.pelilauta = pelilauta;
        lukija = new Scanner(System.in);
        this.logiikka = logiikka;
    }

    public void pelaa() {

        Pelivalikko.tulostaValikko();
        int loppupeli = lukija.nextInt();
        lukija.nextLine();
        pelilauta.setNappulat(NappulaTehdas.luoValkeat(Loppupeli.values()[loppupeli - 1]));
        Nappula mK = NappulaTehdas.luoKuningas(Vari.Musta);
        pelilauta.addNappula(mK);

        System.out.println("Alkuasema:\n");
        logiikka.arvoAlkuasema(pelilauta);

        Tilanne tilanne = Tilanne.OK;
        String siirto = "";

        while (tilanne == Tilanne.OK) {
            do {
                System.out.println("Anna siirto");
                siirto = lukija.nextLine();
                if (siirto.equals("l")) {
                    return;
                }
            } while (!siirtoOk(siirto));

            Kirjain kirjain = Kirjain.valueOf(siirto.substring(1, 2));
            int numero = Integer.parseInt(siirto.substring(2, 3));
            Ruutu vanhaRuutu = pelilauta.getRuutu(new Sijainti(kirjain, numero));

            kirjain = Kirjain.valueOf(siirto.substring(3, 4));
            numero = Integer.parseInt(siirto.substring(4, 5));
            Ruutu uusiRuutu = pelilauta.getRuutu(new Sijainti(kirjain, numero));

            Nappula nappula = vanhaRuutu.getNappula();
            nappula.liikkuu(uusiRuutu);
            System.out.println(nappula.toString());
            pelilauta.teeSiirronJalkeisetToimet();

            tilanne = logiikka.siirraMustaKunkku(mK, pelilauta.getNappulat());
            System.out.println(mK.toString());
            pelilauta.teeSiirronJalkeisetToimet();
        }

        System.out.println("tulos: " + tilanne);
    }

    private boolean siirtoOk(String siirto) {
        String regex = "[a-z&&[dklrt]][a-h][1-9][a-h][1-9]";
        return Pattern.matches(regex, siirto);
    }
}
