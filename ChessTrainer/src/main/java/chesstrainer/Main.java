
package chesstrainer;

import chesstrainer.apuluokat.Vari;
import chesstrainer.peliosat.Pelilauta;
import chesstrainer.peliosat.Nappula;
import chesstrainer.peliosat.Kuningatar;
import chesstrainer.peliosat.Kuningas;
import java.util.ArrayList;

/**
 *
 * @author sariraut
 */
public class Main {
    
    public static void main (String args[])
    {
       Pelilauta pelilauta = new Pelilauta();
//        System.out.println(pelilauta.toString());
//        Ruutu ruutu = pelilauta.getRuutu(Kirjain.d, 4);
//        ruutu.tulostaNaapuriRuudut();
       
       //kysy loppupeli
       
       ArrayList<Nappula> nappulat = new ArrayList<>();
       nappulat.add(new Kuningas(Vari.Musta));
       nappulat.add(new Kuningatar(Vari.Valkoinen));
       nappulat.add(new Kuningas(Vari.Valkoinen));
       
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
