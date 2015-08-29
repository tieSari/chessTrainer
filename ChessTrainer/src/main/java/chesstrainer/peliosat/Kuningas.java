package chesstrainer.peliosat;

import chesstrainer.rakenteet.Nappula;
import chesstrainer.apuluokat.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Nappula-luokasta periytetty Kuningas-nappula
 */
public class Kuningas extends Nappula {

    public Kuningas(Vari vari) {
        super(vari);
    }

    @Override
    public Arvo getArvo() {
        return Arvo.KUNINGAS;
    }

    @Override
    public void asetaShakkiruudut() {

        setShakkiRuudut(new ArrayList<Ruutu>());
        Ruutu ruutu = this.getSijaintiRuutu();
        if (ruutu == null) {
            return;
        }

        Map<Suunta, Ruutu> naapurit = ruutu.getNaapuriRuudut();
        if (naapurit == null) {
            return;
        }

        for (Suunta shakkisuunta : getShakkiSuunnat()) {

            ruutu = naapurit.get(shakkisuunta);
            if (ruutu == null) {
                continue;
            }
            Nappula nappula = ruutu.getNappula();

            if (getVari() == Vari.Valkea) {
                ruutu.setValkeaShakkaa(true);
                if (nappula == null) {
                    lisaaShakkiRuutu(ruutu);
                }
            } else {
                ruutu.setMustaShakkaa(true);
                lisaaShakkiRuutu(ruutu);
            }
        }
    }

    @Override
    public boolean Liikkuu(Ruutu uusiRuutu) {
        if (getShakkiRuudut().contains(uusiRuutu)) {
            if (getVari() == Vari.Valkea) {
                if (!uusiRuutu.isMustaShakkaa()) {
                    setSijaintiRuutu(uusiRuutu);
                    return true;
                }
            } else {
                if (uusiRuutu.getNappula() == null || !uusiRuutu.isValkeaShakkaa()) {
                    setSijaintiRuutu(uusiRuutu);
                    return true;
                }
            }
        }
        return false;
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
