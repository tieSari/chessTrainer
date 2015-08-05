package chesstrainer.peliosat;

import chesstrainer.apuluokat.Vari;

/**
 *
 * @author sariraut
 */
public abstract class Nappula {

    private final Vari vari;
    private Ruutu sijainti;
    private char nimi;
    
    public Nappula(Vari vari) {
        this.vari = vari;
    }

    public char getNimi() {
        return nimi;
    }

    public Vari getVari() {
        return vari;
    }

    public Ruutu getSijainti() {
        return sijainti;
    }

    public void setSijainti(Ruutu sijainti) {
        this.sijainti = sijainti;
    }

    @Override
    public String toString() {
        return getVari() + " " + getNimi() + " " +sijainti.toString();
    }
    
    
}
