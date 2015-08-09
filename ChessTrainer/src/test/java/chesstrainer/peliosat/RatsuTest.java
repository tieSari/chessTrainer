/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer.peliosat;

import chesstrainer.apuluokat.Kirjain;
import chesstrainer.apuluokat.Sijainti;
import chesstrainer.apuluokat.Vari;
import chesstrainer.peliosat.Nappula;
import chesstrainer.peliosat.Pelilauta;
import chesstrainer.peliosat.Ratsu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sariraut
 */
public class RatsuTest {

    Pelilauta lauta;

    public RatsuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lauta = new Pelilauta();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void OnkoReunaRatsunShakkiRuudutOikein() {

        Nappula ratsu = new Ratsu(Vari.Valkea);
        ratsu.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.b, 8)));
        ratsu.asetaShakkiruudut();

        Assert.assertTrue(ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 6)))
                && ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 6)))
                && ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 7)))
                && ratsu.getShakkiRuudut().size() == 3);
    }

    @Test
    public void OnkoKeskustaRatsunShakkiRuudutOikein() {

        Nappula ratsu = new Ratsu(Vari.Valkea);
        ratsu.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.d, 4)));
        ratsu.asetaShakkiruudut();

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
