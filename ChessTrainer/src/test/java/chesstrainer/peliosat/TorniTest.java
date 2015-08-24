/*
 * Torni-nappulan testit
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
public class TorniTest {

    Pelilauta lauta;

    public TorniTest() {
    }

    @Before
    public void setUp() {
        lauta = new Pelilauta();
    }

    @Test
    public void OnkoKeskustaTorninShakkiRuudutOikein() {

        Nappula torni = new Torni(Vari.Valkea);
        torni.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.d, 4)));
        torni.asetaShakkiruudut();

        Assert.assertTrue(torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 3)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 2)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 1)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 5)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 6)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 7)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 8)))
                
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 4)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 4)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 4)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 4)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 4)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 4)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 4)))
                && torni.getShakkiRuudut().size() == 14);
    }
    
    @Test
    public void OnkoAlaKulmaTorninShakkiRuudutOikein() {

        Nappula torni = new Torni(Vari.Valkea);
        torni.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.h, 1)));
        torni.asetaShakkiruudut();

        Assert.assertTrue(torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 2)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 3)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 4)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 5)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 6)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 7)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 8)))
                
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 1)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 1)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 1)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 1)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 1)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 1)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 1)))
                && torni.getShakkiRuudut().size() == 14);
    }
    @Test
    public void OnkoYlaKulmaTorninShakkiRuudutOikein() {

        Nappula torni = new Torni(Vari.Valkea);
        torni.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.a, 8)));
        torni.asetaShakkiruudut();

        Assert.assertTrue(torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 2)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 3)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 4)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 5)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 6)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 7)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 1)))
                
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 8)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 8)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 8)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 8)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 8)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 8)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 8)))
                && torni.getShakkiRuudut().size() == 14);
    }
     @Test
    public void OnkoYlaReunanTorninShakkiRuudutOikein() {

        Nappula torni = new Torni(Vari.Valkea);
        torni.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.f, 8)));
        torni.asetaShakkiruudut();

        Assert.assertTrue(torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 2)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 3)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 4)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 5)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 6)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 7)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.f, 1)))
                
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 8)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 8)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.e, 8)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 8)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 8)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.b, 8)))
                && torni.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 8)))
                && torni.getShakkiRuudut().size() == 14);
    }
}
