package chesstrainer.logiikka;

import chesstrainer.rakenteet.Nappula;
import chesstrainer.apuluokat.*;
import chesstrainer.peliosat.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Ohjelman pelilogiikkaan liittyvät toiminnot
 *
 */
public class Logiikka {

    private int siirtojaTehty = 0;
    private final Random randomGenerator = new Random();

    public int getSiirtojaTehty() {
        return siirtojaTehty;
    }

    public void addSiirtojaTehty() {
        this.siirtojaTehty++;
    }

    /**
     * Pelin alussa arvotaan loppupeliin kuuluvien nappuloiden alkuasemat. Jos
     * arvottu sijainti on vastustajan nappulan vaikutusruudulla, arvotaan uusi
     * sijainti.
     *
     * @param lauta
     */
    public void ArvoAlkuasema(Pelilauta lauta) {

        ArrayList<Nappula> nappulat = lauta.getNappulat();
        if (nappulat == null) {
            return;
        }

        for (Nappula nappula : nappulat) {
            nappula.setSijaintiRuutu(ArvoRuutu(lauta, nappula));
            lauta.TeeSiirronJalkeisetToimet();
            System.out.println(nappula.toString());
        }
        siirtojaTehty = 0;
    }

    private Ruutu ArvoRuutu(Pelilauta lauta, Nappula nappula) {

        while (true) {
            Ruutu ruutu = lauta.getRuutu(ArvoSijainti());
            if (ruutu == null) {
                continue;
            }
            if (ruutu.getNappula() == null) {
                if ((nappula.getVari() == Vari.Valkea && !ruutu.isMustaShakkaa())
                        || (nappula.getVari() == Vari.Musta && !ruutu.isValkeaShakkaa())) {

                    if (nappula instanceof Lahetti
                            && (((Lahetti) nappula).getRuutuVari() == Vari.Musta
                            && ruutu.getVari() == Vari.Valkea
                            || ((Lahetti) nappula).getRuutuVari() == Vari.Valkea
                            && ruutu.getVari() == Vari.Musta)) {
                        continue;
                    }

                    return ruutu;
                }
            }
        }
    }

    private Sijainti ArvoSijainti() {

        Kirjain k = Kirjain.get(randomGenerator.nextInt(8));
        int luku = randomGenerator.nextInt(8) + 1;

        return new Sijainti(k, luku);
    }

    /**
     * Siirretään mustan kuningas ruutuun, jota valkean nappula ei shakkaa ja
     * joka on tyhjä tai jossa on suojaamaton valkea upseeri. Siinä tapauksessa
     * syödään nappula.
     *
     * Arvotaan sijainti, josta kunkun vierusruutujen tutkiminen aloitetaan.
     *
     * @param kunkku, siirrettävä mustan kuningas
     * @param nappulat, laudan nappulat
     * @return a) Tilanne.OK -> peli jatkuu b) Tilanne.PATTI, jos kunkulla ei
     * siirtoja eikä ole shakissa c) Tilanne.MATTI, jos kunkulla ei siirtoja ja
     * shakissa d) Tilanne.SIIRROT_TAYNNA, jos 50 siirtoa tehty. e)
     * Tilanne.EI_MATTIIN_RIITTAVAA_MATERIAALIA, jos kunkku syö valkean nappulan
     * eikä jäljellä oleva materiaali riitä mattiin.
     */
    public Tilanne SiirraMustaKunkku(Nappula kunkku, ArrayList<Nappula> nappulat) {
        try {

            addSiirtojaTehty();
            if (siirtojaTehty >= 50) {
                return Tilanne.SIIRROT_TAYNNA;
            }

            ArrayList<Ruutu> vierusRuudut = kunkku.getShakkiRuudut();

            if (Syodaan(vierusRuudut, kunkku, nappulat)) {
                if (materiaaliRiittaa(nappulat)) {
                    return Tilanne.OK;
                }
                return Tilanne.EI_MATTIIN_RIITTAVAA_MATERIAALIA;
            }
            if (siirtyy(vierusRuudut, kunkku)) {
                return Tilanne.OK;
            }

            if (kunkku.getSijaintiRuutu().isValkeaShakkaa()) {
                return Tilanne.MATTI;
            } else {
                return Tilanne.PATTI;
            }
        } catch (Exception e) {
            System.out.println("Virhe mustan kunkun siirrossa." + e.toString());
        }
        return Tilanne.VIRHE;
    }

    boolean Syodaan(ArrayList<Ruutu> vierusRuudut, Nappula kunkku, ArrayList<Nappula> nappulat) {
        for (Ruutu ruutu : vierusRuudut) {
            Nappula nappula = ruutu.getNappula();
            if (nappula != null && !(nappula instanceof Kuningas)) {
                if (!nappula.isOnSuojattu()) {
                    nappulat.remove(nappula);
                    ruutu.setNappula(null);
                    kunkku.Liikkuu(ruutu);

                    return true;
                }
            }
        }
        return false;
    }

    private boolean materiaaliRiittaa(ArrayList<Nappula> nappulat) {
        int arvo = 0;
        for (Nappula nappula : nappulat) {
            if (nappula.getVari() == Vari.Valkea) {
                arvo += nappula.getArvo().getValue();
            }
        }
        if (arvo > 3) {
            return true;
        }
        return false;
    }

    boolean siirtyy(ArrayList<Ruutu> vierusRuudut, Nappula kunkku) {
        //arvotaan ruutu, josta mahdollisten siirtojen tutkiminen aloitetaan
        int lkm = vierusRuudut.size();
        int eka = randomGenerator.nextInt(lkm);

        for (int i = 0; i < lkm; i++) {
            Ruutu ruutu = vierusRuudut.get(eka);
            if (!ruutu.isValkeaShakkaa() && ruutu.getNappula() == null) {

                kunkku.Liikkuu(ruutu);
                return true;
            }
            eka = eka < (lkm - 1) ? eka + 1 : 0;
        }
        return false;
    }
}
