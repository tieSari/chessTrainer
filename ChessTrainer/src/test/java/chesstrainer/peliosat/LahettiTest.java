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
import static org.junit.Assert.*;

/**
 *
 * @author sariraut
 */
public class LahettiTest {

    Pelilauta lauta;

    public LahettiTest() {
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
