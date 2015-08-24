/*
 * Pelilogiikan testit
 * 
 */
package chesstrainer.logiikka;

import chesstrainer.rakenteet.Nappula;
import chesstrainer.apuluokat.*;
import chesstrainer.peliosat.*;
import junit.framework.Assert;
import org.junit.Before;
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
    Pelilauta pelilauta;

    public LogiikkaTest() {
    }

    @Before
    public void setUp() {
        mKunkku = new Kuningas(Vari.Musta);
        vK = new Kuningas(Vari.Valkea);
        vD = new Kuningatar(Vari.Valkea);
        logiikka = new Logiikka();
        pelilauta = new Pelilauta();
    }

    @Test
    public void OnkoTulosSiirrotTaynnaJos50SiirtoaTehty() {

        for (int i = 0; i <= 50; i++) {
            logiikka.setSiirtojaTehty();
        }
        
        Assert.assertEquals(Tilanne.SIIRROT_TAYNNA, logiikka.SiirraMustaKunkku(mKunkku));
    }

    @Test
    public void OnkoTilanneMattiKunKuningasShakissaEikaSiirtoruutuja() {

        vK.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 6)));
        pelilauta.addNappula(vK);
        pelilauta.TeeSiirronJalkeisetToimet();

        pelilauta.addNappula(mKunkku);
        mKunkku.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 8)));
        pelilauta.TeeSiirronJalkeisetToimet();

        vD.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.a, 8)));
        pelilauta.addNappula(vD);
        pelilauta.TeeSiirronJalkeisetToimet();

        Assert.assertEquals(Tilanne.MATTI, logiikka.SiirraMustaKunkku(mKunkku));
    }

    @Test
    public void OnkoTilannePattiKunKuningasEiShakissaEikaSiirtoruutuja() {

        vD.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.b, 6)));
        pelilauta.addNappula(vD);
        pelilauta.TeeSiirronJalkeisetToimet();

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

        vD.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.b, 7)));
        pelilauta.addNappula(vD);
        pelilauta.TeeSiirronJalkeisetToimet();

        vK.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 6)));
        pelilauta.addNappula(vK);
        pelilauta.TeeSiirronJalkeisetToimet();

        pelilauta.addNappula(mKunkku);
        mKunkku.setSijaintiRuutu(pelilauta.getRuutu(new Sijainti(Kirjain.c, 8)));
        pelilauta.TeeSiirronJalkeisetToimet();

        Assert.assertEquals(Tilanne.OK, logiikka.SiirraMustaKunkku(mKunkku));
    }

    @Test
    public void OnkoAlkuasemanArvonnanJalkeenKaikillaNappuloillaSijainti() {
        pelilauta.addNappula(mKunkku);
        pelilauta.addNappula(vD);
        pelilauta.addNappula(vK);

        logiikka.ArvoAlkuasema(pelilauta);
        for (Nappula nappula : pelilauta.getNappulat()) {
            Assert.assertNotNull(nappula.getSijaintiRuutu());
        }

    }
}
