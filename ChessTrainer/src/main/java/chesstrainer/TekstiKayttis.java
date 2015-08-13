/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer;

import chesstrainer.apuluokat.*;
import chesstrainer.logiikka.*;
import chesstrainer.peliosat.*;
import java.util.Scanner;

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
        
        Nappula vD = new Kuningatar(Vari.Valkea);
        pelilauta.addNappula(vD);
        
        Nappula vK = new Kuningas(Vari.Valkea);
        pelilauta.addNappula(vK);
        
        Nappula mK = new Kuningas(Vari.Musta);
        pelilauta.addNappula(mK);

        logiikka.ArvoAlkuasema(pelilauta);
        Tilanne tilanne = Tilanne.OK;

        while (tilanne == Tilanne.OK) {

            System.out.println("Anna siirto");
            String siirto = lukija.nextLine();
            Kirjain kirjain = Kirjain.valueOf(siirto.substring(1, 2));
            int numero = Integer.parseInt(siirto.substring(2, 3));
            Ruutu uusiRuutu = pelilauta.getRuutu(new Sijainti(kirjain, numero));

            if (siirto.startsWith("d")) {
                vD.Liikkuu(uusiRuutu);
                System.out.println(vD.toString());
                pelilauta.TeeSiirronJalkeisetToimet();
            } else {
                vK.Liikkuu(uusiRuutu);
                System.out.println(vK.toString());
                pelilauta.TeeSiirronJalkeisetToimet();
            }
            tilanne = logiikka.SiirraMustaKunkku(mK);
            System.out.println(mK.toString());
            pelilauta.TeeSiirronJalkeisetToimet();
        }

        System.out.println("tulos; " + tilanne);
       //arvo asema

        //jos ruudulla jo nappula, ota lähin mahdollinen, joka ei uhattu
        //kysy valkean siirto
        //kun valkea siirtää, käynnistä kello
        //kun valkea siirtänyt pysäytä kello
        //siirrä mustan kunkku keskustaan päin
        //jos ei siirtoja eikä shakkia, patti
        //jos shakki, eikä siirtoja, matti
        //jos 50 siirtoa täynnä, tasapeli
    }
}
