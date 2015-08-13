/**
 *
 */
package chesstrainer.peliosat;

import chesstrainer.apuluokat.Suunta;
import chesstrainer.apuluokat.Vari;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author sariraut
 */
public class Kuningas extends Nappula {

    public Kuningas(Vari vari) {
        super(vari);
    }

    @Override
    public char getNimi() {
        return 'K';
    }

    @Override
    public void asetaShakkiruudut() {

        setShakkiRuudut(new ArrayList<Ruutu>());

        for (Suunta shakkisuunta : getShakkiSuunnat()) {

            Ruutu ruutu = this.getSijaintiRuutu();
            if (ruutu == null) {
                return;
            }

            Map<Suunta, Ruutu> naapurit = ruutu.getNaapuriRuudut();
            if (naapurit == null) {
                return;
            }

            ruutu = naapurit.get(shakkisuunta);
            if (ruutu != null && ruutu.getNappula() == null) {
                if (getVari() == Vari.Valkea) {
                    ruutu.setValkeaShakkaa(true);
                } else {
                    ruutu.setMustaShakkaa(true);
                }
                lisaaShakkiRuutu(ruutu);
            }
        }
    }

    @Override
    public void asetaShakkiSuunnat() {

        getShakkiSuunnat().add(Suunta.ita);
        getShakkiSuunnat().add(Suunta.lansi);
        getShakkiSuunnat().add(Suunta.etela);
        getShakkiSuunnat().add(Suunta.pohjoinen);
        getShakkiSuunnat().add(Suunta.lounas);
        getShakkiSuunnat().add(Suunta.luode);
        getShakkiSuunnat().add(Suunta.kaakko);
        getShakkiSuunnat().add(Suunta.koillinen);

    }

}
