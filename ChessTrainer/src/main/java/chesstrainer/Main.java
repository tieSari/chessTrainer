package chesstrainer;

import chesstrainer.ui.GraafinenKayttis;
//import chesstrainer.UI.TekstiKayttis;
import chesstrainer.logiikka.Logiikka;
import chesstrainer.peliosat.Pelilauta;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * Ohjelman suorituksen käynnistävä luokka.
 */
public class Main {

    /**
     *
     * Luodaan sovelluksen logiikka ja pelilauta sekä käyttöliittymä.
     */
    public static void main(String args[]) throws IOException {

        final Logiikka logiikka = new Logiikka();
        final Pelilauta pelilauta = new Pelilauta();

//        TekstiKayttis testiUI = new TekstiKayttis(pelilauta, logiikka);
//        testiUI.Pelaa();
        Runnable r = new Runnable() {

            @Override
            public void run() {
                GraafinenKayttis cg = new GraafinenKayttis(pelilauta, logiikka);

                JFrame f = new JFrame("Chess Trainer");
                f.add(cg.getGui());
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }

}
