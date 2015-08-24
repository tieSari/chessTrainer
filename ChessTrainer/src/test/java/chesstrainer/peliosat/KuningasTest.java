/*
 * Kuningas-nappulan testit
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
public class KuningasTest {

    Pelilauta lauta;
    Nappula kunkku;

    public KuningasTest() {
    }

    @Before
    public void setUp() {
        lauta = new Pelilauta();
        kunkku = new Kuningas(Vari.Valkea);
        lauta.addNappula(kunkku);
    }

    @Test
    public void OnkoKeskustaKunkunShakkiRuudutOikein() {

        kunkku.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.d, 4)));       
        lauta.TeeSiirronJalkeisetToimet();

        Assert.assertTrue(kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 5)))
                && kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 3)))
                && kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 5)))
                && kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 3)))
                && kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 3)))
                && kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 5)))
                && kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 4)))
                && kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 4)))
                && kunkku.getShakkiRuudut().size() == 8);
    }

    @Test
    public void OnkoKulmaKunkunShakkiRuudutOikein() {

        kunkku.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.h, 1)));
        lauta.TeeSiirronJalkeisetToimet();

        Assert.assertTrue(kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 2)))
                && kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 2)))
                && kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 1)))
                && kunkku.getShakkiRuudut().size() == 3);
    }
}
