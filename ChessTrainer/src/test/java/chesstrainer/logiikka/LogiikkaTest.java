/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer.logiikka;

import chesstrainer.apuluokat.Kirjain;
import chesstrainer.apuluokat.Sijainti;
import chesstrainer.apuluokat.Tilanne;
import chesstrainer.apuluokat.Vari;
import chesstrainer.peliosat.Kuningas;
import chesstrainer.peliosat.Kuningatar;
import chesstrainer.peliosat.Nappula;
import chesstrainer.peliosat.Pelilauta;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sariraut
 */
public class LogiikkaTest {

    Logiikka logiikka;
    Nappula mKunkku;
    Pelilauta pelilauta;

    public LogiikkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        mKunkku = new Kuningas(Vari.Musta);
        logiikka = new Logiikka();
        pelilauta = new Pelilauta();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void OnkoTulosSiirrotTaynnaJos50SiirtoaTehty() {

        logiikka.setSiirtojaTehty(50);
        Assert.assertEquals(Tilanne.SIIRROT_TAYNNA, logiikka.SiirraMustaKunkku(mKunkku));
    }

 //koodi ei vielä mahdollista mattiaseman asettamista, testataan myöhemmin
//    @Test
//    public void OnkoTilanneMattiKunKuningasShakissaEikaSiirtoruutuja() {
//
//        Nappula vD = new Kuningatar(Vari.Valkea);
//        vD.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.b, 8)));
//        pelilauta.addNappula(vD);
//        pelilauta.TeeSiirronJalkeisetToimet();
//
//        Nappula vK = new Kuningas(Vari.Valkea);
//        vK.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 6)));
//        pelilauta.addNappula(vK);
//        pelilauta.TeeSiirronJalkeisetToimet();
//
//        pelilauta.addNappula(mKunkku);
//        mKunkku.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 8)));
//        pelilauta.TeeSiirronJalkeisetToimet();
//        
//        Assert.assertEquals(Tilanne.MATTI, logiikka.SiirraMustaKunkku(mKunkku));
//    }

    @Test
    public void OnkoTilannePattiKunKuningasEiShakissaEikaSiirtoruutuja() {

        Nappula vD = new Kuningatar(Vari.Valkea);
        vD.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.b, 6)));
        pelilauta.addNappula(vD);
        pelilauta.TeeSiirronJalkeisetToimet();

        Nappula vK = new Kuningas(Vari.Valkea);
        vK.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.a, 6)));
        pelilauta.addNappula(vK);
        pelilauta.TeeSiirronJalkeisetToimet();

        pelilauta.addNappula(mKunkku);
        mKunkku.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.a, 8)));
        pelilauta.TeeSiirronJalkeisetToimet();

        Assert.assertEquals(Tilanne.PATTI, logiikka.SiirraMustaKunkku(mKunkku));
    }

    @Test
    public void OnkoTilanneOKKunKuningasEiShakissaJaOnSiirtoruutuja() {

        Nappula vD = new Kuningatar(Vari.Valkea);
        vD.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.b, 7)));
        pelilauta.addNappula(vD);
        pelilauta.TeeSiirronJalkeisetToimet();

        Nappula vK = new Kuningas(Vari.Valkea);
        vK.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 6)));
        pelilauta.addNappula(vK);
        pelilauta.TeeSiirronJalkeisetToimet();

        pelilauta.addNappula(mKunkku);
        mKunkku.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 8)));
        pelilauta.TeeSiirronJalkeisetToimet();

        Assert.assertEquals(Tilanne.OK, logiikka.SiirraMustaKunkku(mKunkku));
    }
}
