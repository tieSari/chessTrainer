/*
 * Pelilogiikan testit
 * 
 */
package chesstrainer.logiikka;

import chesstrainer.rakenteet.Nappula;
import chesstrainer.apuluokat.*;
import chesstrainer.peliosat.*;
import java.util.ArrayList;
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
    Nappula vD;
    Nappula vK;
    Nappula vT1;
    Nappula vT2;
    Pelilauta pelilauta;

    public LogiikkaTest() {
    }

    @Before
    public void setUp() {
        mKunkku = new Kuningas(Vari.Musta);
        vK = new Kuningas(Vari.Valkea);
        vD = new Kuningatar(Vari.Valkea);
        vT1 = new Torni(Vari.Valkea);
        vT2 = new Torni(Vari.Valkea);
        logiikka = new Logiikka();
        pelilauta = new Pelilauta();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void OnkoTulosSiirrotTaynnaJos50SiirtoaTehty() {

        for (int i = 0; i <= 50; i++) {
            logiikka.addSiirtojaTehty();
        }

        Assert.assertEquals(Tilanne.SIIRROT_TAYNNA, logiikka.siirraMustaKunkku(mKunkku, pelilauta.getNappulat()));
    }

    @Test
    public void OnkoTulosEiSiirrotTaynnaJosEi50SiirtoaTehty() {

        for (int i = 1; i < 49; i++) {
            logiikka.addSiirtojaTehty();
        }

        Assert.assertNotSame(Tilanne.SIIRROT_TAYNNA, logiikka.siirraMustaKunkku(mKunkku, pelilauta.getNappulat()));
    }

    @Test
    public void OnkoTilanneMattiKunKuningasShakissaEikaSiirtoruutuja() {

        vK.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 6)));
        pelilauta.addNappula(vK);
        pelilauta.teeSiirronJalkeisetToimet();

        pelilauta.addNappula(mKunkku);
        mKunkku.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 8)));
        pelilauta.teeSiirronJalkeisetToimet();

        vD.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.a, 8)));
        pelilauta.addNappula(vD);
        pelilauta.teeSiirronJalkeisetToimet();

        Assert.assertEquals(Tilanne.MATTI, logiikka.siirraMustaKunkku(mKunkku, pelilauta.getNappulat()));
    }

    @Test
    public void OnkoTilannePattiKunKuningasEiShakissaEikaSiirtoruutuja() {

        vD.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.b, 6)));
        pelilauta.addNappula(vD);
        pelilauta.teeSiirronJalkeisetToimet();

        vK.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.a, 6)));
        pelilauta.addNappula(vK);
        pelilauta.teeSiirronJalkeisetToimet();

        pelilauta.addNappula(mKunkku);
        mKunkku.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.a, 8)));
        pelilauta.teeSiirronJalkeisetToimet();

        Assert.assertEquals(Tilanne.PATTI, logiikka.siirraMustaKunkku(mKunkku, pelilauta.getNappulat()));
    }

    @Test
    public void OnkoTilanneOKKunKuningasEiShakissaJaOnSiirtoruutuja() {

        vD.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.b, 7)));
        pelilauta.addNappula(vD);
        pelilauta.teeSiirronJalkeisetToimet();

        vK.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 6)));
        pelilauta.addNappula(vK);
        pelilauta.teeSiirronJalkeisetToimet();

        pelilauta.addNappula(mKunkku);
        mKunkku.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 8)));
        pelilauta.teeSiirronJalkeisetToimet();

        Assert.assertEquals(Tilanne.OK, logiikka.siirraMustaKunkku(mKunkku, pelilauta.getNappulat()));
    }

    @Test
    public void OnkoTilanneEiRiittavaaMateriaaliaKunKuningasSyoDaamin() {

        vD.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.b, 7)));
        pelilauta.addNappula(vD);
        pelilauta.teeSiirronJalkeisetToimet();

        vK.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 1)));
        pelilauta.addNappula(vK);
        pelilauta.teeSiirronJalkeisetToimet();

        pelilauta.addNappula(mKunkku);
        mKunkku.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 8)));
        pelilauta.teeSiirronJalkeisetToimet();

        Assert.assertEquals(Tilanne.EI_MATTIIN_RIITTAVAA_MATERIAALIA, logiikka.siirraMustaKunkku(mKunkku, pelilauta.getNappulat()));
    }

    @Test
    public void OnkoTilanneOkKunKuningasSyoToisenTorneista() {

        vT1.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.b, 7)));
        pelilauta.addNappula(vT1);
        pelilauta.teeSiirronJalkeisetToimet();

        vT2.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.h, 3)));
        pelilauta.addNappula(vT1);
        pelilauta.teeSiirronJalkeisetToimet();

        vK.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 1)));
        pelilauta.addNappula(vK);
        pelilauta.teeSiirronJalkeisetToimet();

        pelilauta.addNappula(mKunkku);
        mKunkku.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 8)));
        pelilauta.teeSiirronJalkeisetToimet();

        Assert.assertEquals(Tilanne.OK, logiikka.siirraMustaKunkku(mKunkku, pelilauta.getNappulat()));
    }

    @Test
    public void OnkoAlkuasemanArvonnanJalkeenKaikillaNappuloillaSijainti() {
        pelilauta.addNappula(mKunkku);
        pelilauta.addNappula(vD);
        pelilauta.addNappula(vK);

        logiikka.arvoAlkuasema(pelilauta);
        for (Nappula nappula : pelilauta.getNappulat()) {
            Assert.assertNotNull(nappula.getSijaintiRuutu());
        }

    }
}
