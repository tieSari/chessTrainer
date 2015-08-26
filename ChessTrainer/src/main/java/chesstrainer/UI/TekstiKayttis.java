/*
 * Testikäyttöliittymä koodausvaiheen toiminnallisuuden testaamiseen
 * 
 */
package chesstrainer.UI;

import chesstrainer.rakenteet.*;
import chesstrainer.apuluokat.*;
import chesstrainer.logiikka.*;
import chesstrainer.peliosat.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author sariraut
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

    public void Pelaa() {

        Pelivalikko.TulostaValikko();
        int loppupeli = lukija.nextInt();
        lukija.nextLine();
        pelilauta.setNappulat(NappulaTehdas.LuoValkeat(Loppupeli.values()[loppupeli - 1]));
        Nappula mK = NappulaTehdas.LuoKuningas(Vari.Musta);
        pelilauta.addNappula(mK);

        System.out.println("Alkuasema:\n");
        logiikka.ArvoAlkuasema(pelilauta);

        Tilanne tilanne = Tilanne.OK;
        String siirto = "";

        while (tilanne == Tilanne.OK) {
            do {
                System.out.println("Anna siirto");
                siirto = lukija.nextLine();
                if (siirto.equals("l")) {
                    return;
                }
            } while (!SiirtoOk(siirto));

            Kirjain kirjain = Kirjain.valueOf(siirto.substring(1, 2));
            int numero = Integer.parseInt(siirto.substring(2, 3));
            Ruutu vanhaRuutu = pelilauta.getRuutu(new Sijainti(kirjain, numero));

            kirjain = Kirjain.valueOf(siirto.substring(3, 4));
            numero = Integer.parseInt(siirto.substring(4, 5));
            Ruutu uusiRuutu = pelilauta.getRuutu(new Sijainti(kirjain, numero));

            Nappula nappula = vanhaRuutu.getNappula();
            nappula.Liikkuu(uusiRuutu);
            System.out.println(nappula.toString());
            pelilauta.TeeSiirronJalkeisetToimet();

            tilanne = logiikka.SiirraMustaKunkku(mK);
            System.out.println(mK.toString());
            pelilauta.TeeSiirronJalkeisetToimet();
        }

        System.out.println("tulos: " + tilanne);
    }

    private boolean SiirtoOk(String siirto) {
        String regex = "[a-z&&[dklrt]][a-h][1-9][a-h][1-9]";
        return Pattern.matches(regex, siirto);
    }
}
