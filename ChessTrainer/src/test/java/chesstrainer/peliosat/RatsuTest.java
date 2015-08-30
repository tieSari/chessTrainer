/*
 * Ratsu-nappulaan liittyvät testit
 * 
 */
package chesstrainer.peliosat;

import chesstrainer.rakenteet.Nappula;
import chesstrainer.apuluokat.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sariraut
 */
public class RatsuTest {

    Pelilauta lauta;
    Nappula ratsu;

    public RatsuTest() {
    }

    @Before
    public void setUp() {
        lauta = new Pelilauta();
        ratsu = new Ratsu(Vari.Valkea);
        lauta.addNappula(ratsu);
    }

    @Test
    public void OnkoReunaRatsunShakkiRuudutOikein() {

        ratsu.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.b, 8)));
        lauta.teeSiirronJalkeisetToimet();

        Assert.assertTrue(ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 6)))
                && ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 6)))
                && ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 7)))
                && ratsu.getShakkiRuudut().size() == 3);
    }

    @Test
    public void OnkoKeskustaRatsunShakkiRuudutOikein() {

        ratsu.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.d, 4)));
        lauta.teeSiirronJalkeisetToimet();

        Assert.assertTrue(ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 6)))
                && ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 2)))
                && ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 6)))
                && ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 2)))
                && ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 5)))
                && ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 3)))
                && ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 5)))
                && ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 3)))
                && ratsu.getShakkiRuudut().size() == 8);
    }
}
