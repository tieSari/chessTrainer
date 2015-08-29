
package chesstrainer.peliosat;

import chesstrainer.rakenteet.Nappula;
import chesstrainer.apuluokat.Arvo;
import chesstrainer.apuluokat.Suunta;
import chesstrainer.apuluokat.Vari;

/**
 * Nappula-luokasta periytetty Lähetti-nappula
 */
public class Lahetti extends Nappula {

    private Vari ruutuVari;
    public Lahetti(Vari vari) {
        super(vari);
    }
    
    public Lahetti(Vari vari, Vari ruutuVari) {
        this(vari);
        this.ruutuVari = ruutuVari;
    }

    public Vari getRuutuVari() {
        return ruutuVari;
    }

    @Override
    public Arvo getArvo() {
        return Arvo.LAHETTI;
    }

@Override
    public void asetaShakkiSuunnat() {
        
        getShakkiSuunnat().add(Suunta.lounas);
        getShakkiSuunnat().add(Suunta.luode);
        getShakkiSuunnat().add(Suunta.kaakko);
        getShakkiSuunnat().add(Suunta.koillinen);
    }
}
