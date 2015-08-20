/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer.peliosat;

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
public class PelilautaTest {

    Pelilauta lauta;

    public PelilautaTest() {
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
