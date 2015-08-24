/*
 * Kuningatar-nappulan testit
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
public class KuningatarTest {

    Pelilauta lauta;

    public KuningatarTest() {
    }

    @Before
    public void setUp() {
        lauta = new Pelilauta();
    }

    @Test
    public void OnkoKeskustaDaaminShakkiRuudutOikein() {

        Nappula daami = new Kuningatar(Vari.Valkea);
        daami.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.d, 4)));
        daami.asetaShakkiruudut();

        Assert.assertTrue(daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 5)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 6)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 7)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 8)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 3)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 2)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 1)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 5)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 6)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 7)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 3)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 2)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 1)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 3)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 2)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 1)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 5)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 6)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 7)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 8)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 4)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 4)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 4)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 4)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 4)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 4)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 4)))
                && daami.getShakkiRuudut().size() == 27);
    }

    @Test
    public void OnkoKulmaDaaminShakkiRuudutOikein() {

        Nappula daami = new Kuningatar(Vari.Valkea);
        daami.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.h, 1)));
        daami.asetaShakkiruudut();

        Assert.assertTrue(daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 2)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 3)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 4)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 5)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 6)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 7)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 8)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 1)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 1)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 1)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 1)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 1)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 1)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 1)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 2)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 3)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 4)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 5)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 6)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 7)))
                && daami.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 8)))
                && daami.getShakkiRuudut().size() == 21);
    }
}
