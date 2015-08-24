
package chesstrainer.peliosat;

import chesstrainer.rakenteet.Nappula;
import chesstrainer.apuluokat.Arvo;
import chesstrainer.apuluokat.Suunta;
import chesstrainer.apuluokat.Vari;

/**
 * Nappula-luokasta periytetty Torni-nappula
 */
public class Torni extends Nappula {

    public Torni(Vari vari) {
        super(vari);
    }

    @Override
    public void asetaShakkiSuunnat() {

        getShakkiSuunnat().add(Suunta.ita);
        getShakkiSuunnat().add(Suunta.lansi);
        getShakkiSuunnat().add(Suunta.etela);
        getShakkiSuunnat().add(Suunta.pohjoinen);
    }

    @Override
    public  Arvo getArvo() {
        return Arvo.TORNI;
    }
}
