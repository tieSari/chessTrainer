package chesstrainer.peliosat;

import chesstrainer.rakenteet.Nappula;
import chesstrainer.apuluokat.Sijainti;
import chesstrainer.apuluokat.Suunta;
import chesstrainer.apuluokat.Vari;
import java.util.HashMap;
import java.util.Objects;

/**
 * Shakkilaudan ruutu-luokka. Ruutu tietää sijaintinsa ja naapuriruutunsa. Ruutu
 * tietää myös kulkeeko sen kautta jonkin nappulan vaikutusreitti.
 */
public class Ruutu {

    private final Sijainti sijainti;
    private Nappula nappula;
    private boolean valkeaShakkaa;
    private boolean mustaShakkaa;
    private final HashMap<Suunta, Ruutu> naapuriRuudut;
    private Vari vari;

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

    public HashMap<Suunta, Ruutu> getNaapuriRuudut() {
        return naapuriRuudut;
    }

    public Ruutu getNaapuriRuutu(Suunta suunta) {
        return naapuriRuudut.get(suunta);
    }

    public void setNaapuriRuutu(Ruutu naapuriRuutu, Suunta suunta) {
        this.naapuriRuudut.put(suunta, naapuriRuutu);
    }

    public Vari getVari() {
        return vari;
    }

    public Ruutu(Sijainti sijainti) {
        this.naapuriRuudut = new HashMap<>();
        this.sijainti = sijainti;
        this.nappula = null;
        this.vari = Vari.Valkea;
    }

    public Ruutu(Sijainti sijainti, Vari vari) {
        this(sijainti);
        this.vari = vari;
    }

    /**
     * testausta varten tehty metodi tulostaa ruudun naapuriruudut
     */
    public void tulostaNaapuriRuudut() {
        System.out.println("minun " + toString() + " naapurit;\n");
        for (Ruutu naapuri : naapuriRuudut.values()) {
            System.out.println(naapuri.toString());
        }
    }

    @Override
    public String toString() {
        return sijainti.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ruutu)) {
            return false;
        }
        Ruutu ruutu = (Ruutu) o;
        return (this.getSijainti().equals(ruutu.getSijainti()));

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.sijainti);
        return hash;
    }

}
