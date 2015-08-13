package chesstrainer;

import chesstrainer.logiikka.Logiikka;
import chesstrainer.peliosat.Pelilauta;
import java.io.IOException;

/**
 *
 * @author sariraut
 */
public class Main {

    public static void main(String args[]) throws IOException {
        
        Logiikka logiikka = new Logiikka();
        Pelilauta pelilauta = new Pelilauta();
        
        TekstiKayttis testiUI = new TekstiKayttis(pelilauta, logiikka);
        testiUI.Pelaa();
    }

}
