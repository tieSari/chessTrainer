package chesstrainer;

import chesstrainer.apuluokat.Kirjain;
import chesstrainer.apuluokat.Sijainti;
import chesstrainer.apuluokat.Vari;
import chesstrainer.logiikka.Logiikka;
import chesstrainer.peliosat.Pelilauta;
import chesstrainer.peliosat.Nappula;
import chesstrainer.peliosat.Kuningatar;
import chesstrainer.peliosat.Kuningas;
import chesstrainer.peliosat.Ratsu;
import chesstrainer.peliosat.Torni;
import java.util.ArrayList;

/**
 *
 * @author sariraut
 */
public class Main {

    public static void main(String args[]) {
        Logiikka logiikka = new Logiikka();
        Pelilauta pelilauta = new Pelilauta();
//        System.out.println(pelilauta.toString());
//        Ruutu ruutu = pelilauta.getRuutu(Kirjain.d, 4);
//        ruutu.tulostaNaapuriRuudut();

//        Nappula ratsu = new Ratsu(Vari.Valkea);
//        ratsu.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.b, 8)));
//        ratsu.asetaShakkiruudut();
        Nappula torni = new Torni(Vari.Valkea);
        torni.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.b, 8)));
        torni.asetaShakkiruudut();

       //kysy loppupeli
        ArrayList<Nappula> valkeat = new ArrayList<>();

        valkeat.add(new Kuningatar(Vari.Valkea));
        valkeat.add(new Kuningas(Vari.Valkea));
        valkeat.add(new Kuningas(Vari.Musta));

        logiikka.ArvoAlkuasema(valkeat, pelilauta);
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
