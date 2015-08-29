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

    @Test
    public void LaudanTyhjentaminenPoistaaShakitJaNappulat() {

        Nappula vD = new Kuningatar(Vari.Valkea);
        lauta.addNappula(vD);

        Nappula vK = new Kuningas(Vari.Valkea);
        lauta.addNappula(vK);

        Nappula mK = new Kuningas(Vari.Musta);
        lauta.addNappula(mK);

        lauta.tyhjennaLauta();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Assert.assertNull(lauta.getRuudut()[i][j].getNappula());
                Assert.assertEquals(false, lauta.getRuudut()[i][j].isMustaShakkaa());
                Assert.assertEquals(false, lauta.getRuudut()[i][j].isValkeaShakkaa());
            }
        }
    }
}
