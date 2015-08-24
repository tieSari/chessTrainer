/*
 * Pelilaudan testit
 * 
 */
package chesstrainer.peliosat;

import chesstrainer.rakenteet.Nappula;
import chesstrainer.apuluokat.Vari;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sariraut
 */
public class PelilautaTest {

    Pelilauta lauta;

    public PelilautaTest() {
    }

    @Before
    public void setUp() {
        lauta = new Pelilauta();
    }

    @Test
    public void NappulanLisaaminenLaudalleToimiiOikein() {

        Nappula vD = new Kuningatar(Vari.Valkea);
        lauta.addNappula(vD);

        Nappula vK = new Kuningas(Vari.Valkea);
        lauta.addNappula(vK);

        Nappula mK = new Kuningas(Vari.Musta);
        lauta.addNappula(mK);

        Assert.assertEquals(3, lauta.getNappulat().size());
    }
}
