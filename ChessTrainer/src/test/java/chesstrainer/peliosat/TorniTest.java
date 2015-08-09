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
public class TorniTest {

    Pelilauta lauta;

    public TorniTest() {
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
    public void OnkoKulmaTorninShakkiRuudutOikein() {

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
}
