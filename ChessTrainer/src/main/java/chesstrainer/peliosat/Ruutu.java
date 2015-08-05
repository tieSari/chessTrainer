
package chesstrainer.peliosat;

import chesstrainer.apuluokat.Kirjain;
import java.util.ArrayList;

/**
 *
 * @author sariraut
 */

public class Ruutu {
    
   // public String name;
    
    private int numero;
    private Kirjain kirjain;
    private Nappula nappula;

    public Nappula getNappula() {
        return nappula;
    }

    public void setNappula(Nappula nappula) {
        this.nappula = nappula;
    }

    public Kirjain getKirjain() {
        return kirjain;
    }

    public int getNumero() {
        return numero;
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
    
    public Ruutu(Kirjain kirjain, int numero)
    {
        this.naapuriRuudut = new ArrayList<>();
        this.numero = numero;
        this.kirjain = kirjain;
    }

    public void tulostaNaapuriRuudut()
    {
        System.out.println("minun "+getKirjain()+getNumero()+" naapurit;\n");
        for(Ruutu naapuri: naapuriRuudut)
        {
            System.out.println(naapuri.toString());
        }
    }
    
    @Override
    public String toString() {
        return " " + kirjain + numero;
    }
    
}
