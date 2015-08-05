
package chesstrainer.peliosat;

import chesstrainer.apuluokat.Sijainti;
import java.util.ArrayList;

/**
 *
 * @author sariraut
 */

public class Ruutu {
    
   // public String name;
    
    private Sijainti sijainti;
    private Nappula nappula;
    private boolean valkeaShakkaa;
    private boolean mustaShakkaa;

    public void setValkeaShakkaa(boolean valkeaShakkaa) {
        this.valkeaShakkaa = valkeaShakkaa;
    }

    public void setMustaShakkaa(boolean mustaShakkaa) {
        this.mustaShakkaa = mustaShakkaa;
    }

    public boolean isValkeaShakkaa() {
        return valkeaShakkaa;
    }

    public boolean isMustaShakkaa() {
        return mustaShakkaa;
    }

    public Nappula getNappula() {
        return nappula;
    }

    public void setNappula(Nappula nappula) {
        this.nappula = nappula;
    }

    public Sijainti getSijainti() {
        return sijainti;
    }

    
    private ArrayList<Ruutu> naapuriRuudut;

    public ArrayList<Ruutu> getNaapuriRuudut() {
        return naapuriRuudut;
    }

    public void setNaapuriRuutu(Ruutu naapuriRuutu) {
        this.naapuriRuudut.add(naapuriRuutu);
    }
    
    public Ruutu(ArrayList<Ruutu> naapuriRuudut)
    {
        this.naapuriRuudut = new ArrayList<>();
        this.naapuriRuudut = naapuriRuudut;
    }
    
    public Ruutu(Sijainti sijainti)
    {
        this.naapuriRuudut = new ArrayList<>();
        this.sijainti = sijainti;
        this.nappula = null;
    }

    public void tulostaNaapuriRuudut()
    {
        System.out.println("minun "+toString()+" naapurit;\n");
        for(Ruutu naapuri: naapuriRuudut)
        {
            System.out.println(naapuri.toString());
        }
    }
    
    @Override
    public String toString() {
        return sijainti.toString();
    }
    
}
