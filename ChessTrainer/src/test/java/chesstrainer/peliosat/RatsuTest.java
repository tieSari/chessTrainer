/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer.peliosat;

import chesstrainer.apuluokat.Kirjain;
import chesstrainer.apuluokat.Sijainti;
import chesstrainer.apuluokat.Vari;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
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

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lauta = new Pelilauta();
        ratsu = new Ratsu(Vari.Valkea);
        lauta.addNappula(ratsu);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void OnkoReunaRatsunShakkiRuudutOikein() {

        ratsu.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.b, 8)));
        lauta.TeeSiirronJalkeisetToimet();
        //ratsu.asetaShakkiruudut();

        Assert.assertTrue(ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.a, 6)))
                && ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.c, 6)))
                && ratsu.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.d, 7)))
                && ratsu.getShakkiRuudut().size() == 3);
    }

    @Test
    public void OnkoKeskustaRatsunShakkiRuudutOikein() {

        ratsu.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.d, 4)));
        lauta.TeeSiirronJalkeisetToimet();

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
