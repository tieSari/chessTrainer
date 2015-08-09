/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer.peliosat;

import chesstrainer.apuluokat.Suunta;
import chesstrainer.apuluokat.Vari;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sariraut
 */
public class Ratsu extends Nappula implements Liikkuva {

    public Ratsu(Vari vari) {
        super(vari);
    }

    @Override
    public char getNimi() {
        return 'R';
    }

    @Override
    public void Liikkuu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asetaShakkiruudut() {

        for (Suunta shakkisuunta : getShakkiSuunnat()) {
            HashMap<Suunta, Ruutu> naapurit;

            Ruutu ruutu = this.getSijaintiRuutu();
            if (ruutu == null) {
                return;
            }
            for (int i = 0; i <= 1; i++) {

                if (ruutu == null) {
                    continue;
                }

                naapurit = ruutu.getNaapuriRuudut();
                if (naapurit == null) {
                    return;
                }
                ruutu = naapurit.get(shakkisuunta);
            }
            if (ruutu == null) {
                continue;
            }

            naapurit = ruutu.getNaapuriRuudut();
            if (naapurit == null) {
                continue;
            }

            if (shakkisuunta == Suunta.etela || shakkisuunta == Suunta.pohjoinen) {

                asetaRuutuShakki(naapurit, Suunta.ita);
                asetaRuutuShakki(naapurit, Suunta.lansi);

            } else {

                asetaRuutuShakki(naapurit, Suunta.etela);
                asetaRuutuShakki(naapurit, Suunta.pohjoinen);
            }
        }
    }

    private Ruutu asetaRuutuShakki(Map<Suunta, Ruutu> naapurit, Suunta suunta) {
        Ruutu ruutu = naapurit.get(suunta);

        if (ruutu != null && ruutu.getNappula() == null) {
            ruutu.setValkeaShakkaa(true);
            lisaaShakkiRuutu(ruutu);
            
        }
        return ruutu;
    }

    @Override
    public void asetaShakkiSuunnat() {
        getShakkiSuunnat().add(Suunta.ita);
        getShakkiSuunnat().add(Suunta.lansi);
        getShakkiSuunnat().add(Suunta.etela);
        getShakkiSuunnat().add(Suunta.pohjoinen);
    }

}
