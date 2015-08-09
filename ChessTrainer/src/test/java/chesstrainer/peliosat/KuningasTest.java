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
public class KuningasTest {

    Pelilauta lauta;

    public KuningasTest() {
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
    public void OnkoKeskustaKunkunShakkiRuudutOikein() {

        Nappula kunkku = new Kuningas(Vari.Valkea);
        kunkku.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.d, 4)));
        kunkku.asetaShakkiruudut();

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

        Nappula kunkku = new Kuningas(Vari.Valkea);
        kunkku.setSijaintiRuutu(lauta.getRuutu(new Sijainti(Kirjain.h, 1)));
        kunkku.asetaShakkiruudut();

        Assert.assertTrue(kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.h, 2)))
                && kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 2)))
                && kunkku.getShakkiRuudut().contains(lauta.getRuutu(new Sijainti(Kirjain.g, 1)))
                && kunkku.getShakkiRuudut().size() == 3);
    }
}
