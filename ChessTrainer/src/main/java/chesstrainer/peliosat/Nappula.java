
package chesstrainer.peliosat;

import chesstrainer.apuluokat.Suunta;
import chesstrainer.apuluokat.Vari;
import java.util.ArrayList;
import java.util.Map;

/**
 * Abstrakti yliluokka eri shakkinappulatyypeille.
 * Implementoi Liikkuva-rajapinnan.
 */
public abstract class Nappula implements Liikkuva {

    private final Vari vari;
    private Ruutu sijaintiRuutu;
    private char nimi;
    private final ArrayList<Suunta> shakkiSuunnat;
    private ArrayList<Ruutu> shakkiRuudut;

    public Nappula(Vari vari) {
        this.vari = vari;
        shakkiSuunnat = new ArrayList<>();
        shakkiRuudut = new ArrayList<>();
        asetaShakkiSuunnat();
    }

    public char getNimi() {
        return nimi;
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
        //asetaShakkiruudut();
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

    public abstract void asetaShakkiSuunnat();

/**
 * asettaa nappulan vaikutusruudut. Valkean nappulan vaikutus katkeaa,
 * jos reitille osuus toinen valkea nappula.
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
            
            while (ruutu != null &&
                    (nappula == null || 
                    (nappula instanceof Kuningas && 
                    nappula.getVari() == Vari.Musta))) {

                ruutu.setValkeaShakkaa(true);
                lisaaShakkiRuutu(ruutu);
                naapurit = ruutu.getNaapuriRuudut();
                ruutu = naapurit.get(shakkisuunta);
            }
        }
    }

    @Override
    public String toString() {
        return getVari() + " " + getNimi() + " " + sijaintiRuutu.toString();
    }

    @Override
    public void Liikkuu(Ruutu uusiRuutu
    ) {
        if (shakkiRuudut.contains(uusiRuutu)) {
            setSijaintiRuutu(uusiRuutu);
            // asetaShakkiruudut();
        }
    }

}
