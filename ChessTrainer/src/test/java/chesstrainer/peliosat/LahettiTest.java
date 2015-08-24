/*
 * Lähetti-nappulan testit
 * 
 */
package chesstrainer.peliosat;

import chesstrainer.apuluokat.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sariraut
 */
public class LahettiTest {

    Pelilauta lauta;

    public LahettiTest() {
    }

    @Before
    public void setUp() {
        lauta = new Pelilauta();
    }

    @Test
    public void OnkoKulmaLahetinShakkiRuudutOikein() {

        Nappula lahetti = new Lahetti(Vari.Valkea);
        lahetti.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.h, 1)));
        lahetti.asetaShakkiruudut();

        Assert.assertTrue(lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 2)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 3)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 4)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 5)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 6)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 7)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 8)))
                && lahetti.getShakkiRuudut().size() == 7);
    }

    @Test
    public void OnkoKeskustaLahetinShakkiRuudutOikein() {

        Nappula lahetti = new Lahetti(Vari.Valkea);
        lahetti.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.d, 4)));
        lahetti.asetaShakkiruudut();

        Assert.assertTrue(lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 5)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 6)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 7)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 8)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 3)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 2)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 1)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 5)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 6)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 7)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 3)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 2)))
                && lahetti.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 1)))
                && lahetti.getShakkiRuudut().size() == 13);
    }
}
