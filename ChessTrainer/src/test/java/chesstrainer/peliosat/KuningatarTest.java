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
public class KuningatarTest {

    Pelilauta lauta;

    public KuningatarTest() {
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
