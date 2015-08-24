package chesstrainer.rakenteet;

import chesstrainer.apuluokat.*;
import chesstrainer.peliosat.Kuningas;
import chesstrainer.peliosat.Ruutu;
import java.util.ArrayList;
import java.util.Map;

/**
 * Abstrakti yliluokka eri shakkinappulatyypeille. Implementoi
 * Liikkuva-rajapinnan.
 */
public abstract class Nappula implements Liikkuva {

    private final Vari vari;
    private Ruutu sijaintiRuutu;
    private Arvo arvo;
    private final ArrayList<Suunta> shakkiSuunnat;
    private ArrayList<Ruutu> shakkiRuudut;

    public Nappula(Vari vari) {
        this.vari = vari;
        shakkiSuunnat = new ArrayList<>();
        shakkiRuudut = new ArrayList<>();
        asetaShakkiSuunnat();
    }

    public Arvo getArvo() {
        return arvo;
    }

    public Vari getVari() {
        return vari;
    }

    public Ruutu getSijaintiRuutu() {
        return sijaintiRuutu;
    }

    public void setSijaintiRuutu(Ruutu sijaintiRuutu) {

        if (this.getSijaintiRuutu() != null) {
            this.getSijaintiRuutu().setNappula(null);
        }
        this.sijaintiRuutu = sijaintiRuutu;
        this.getSijaintiRuutu().setNappula(this);
    }

    public ArrayList<Ruutu> getShakkiRuudut() {
        return shakkiRuudut;
    }

    public void setShakkiRuudut(ArrayList<Ruutu> ruudut) {

        this.shakkiRuudut = ruudut;
    }

    public void lisaaShakkiRuutu(Ruutu shakkiRuutu) {
        this.shakkiRuudut.add(shakkiRuutu);
    }

    public ArrayList<Suunta> getShakkiSuunnat() {
        return shakkiSuunnat;
    }

    /**
     * asettaa ilmansuunnat, joihin nappula voi liikkua. 
     */
    public abstract void asetaShakkiSuunnat();

    /**
     * asettaa nappulan vaikutusruudut. Valkean nappulan vaikutus katkeaa, jos
     * reitille osuus toinen valkea nappula.
     */
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
            Nappula nappula = ruutu != null ? ruutu.getNappula() : null;

            while (ruutu != null
                    && (nappula == null
                    || (nappula instanceof Kuningas
                    && nappula.getVari() == Vari.Musta))) {

                ruutu.setValkeaShakkaa(true);
//                if (nappula == null) {
                    lisaaShakkiRuutu(ruutu);
//                }
                naapurit = ruutu.getNaapuriRuudut();
                ruutu = naapurit.get(shakkisuunta);
                nappula = ruutu != null ? ruutu.getNappula() : null;
            }
        }
    }

    @Override
    public String toString() {
        return getVari() + " " + getArvo() + " " + sijaintiRuutu.toString();
    }

    @Override
    public boolean Liikkuu(Ruutu uusiRuutu
    ) {
        if (shakkiRuudut.contains(uusiRuutu)) {
            setSijaintiRuutu(uusiRuutu);
            return true;
        }
        return false;
    }

}
