
package chesstrainer.apuluokat;

import java.util.Objects;

/**
 * Nappulan tai ruudun sijainti shakkilaudalla määritetään
 * Sijainti-luokan kirjain- ja numero-muuttujien yhdistelmän perusteella.
 *
 */
public class Sijainti {

    private Kirjain kirjain;
    private int numero;

    public Sijainti(Kirjain kirjain, int numero) {
        this.kirjain = kirjain;
        this.numero = numero;
    }

    public Kirjain getKirjain() {
        return kirjain;
    }

    public void setKirjain(Kirjain kirjain) {
        this.kirjain = kirjain;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "" + getKirjain() + getNumero();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Sijainti)) {
            return false;
        }
        Sijainti sij = (Sijainti) o;

        return (this.getKirjain().equals(sij.getKirjain())
                && this.getNumero() == sij.getNumero());
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.kirjain);
        hash = 59 * hash + this.numero;
        return hash;
    }
}
