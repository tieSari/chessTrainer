package chesstrainer.rakenteet;

import chesstrainer.apuluokat.Loppupeli;
import chesstrainer.apuluokat.Vari;
import chesstrainer.peliosat.*;
import java.util.ArrayList;

/**
 * Tehdas-luokka eri nappulatyyppien luomiseen.
 */
public class NappulaTehdas {

    public static Nappula luoKuningas(Vari vari) {
        return new Kuningas(vari);
    }

    public static Nappula luoKuningatar(Vari vari) {
        return new Kuningatar(vari);
    }

    public static Nappula luoTorni(Vari vari) {
        return new Torni(vari);
    }

    public static Nappula luoRatsu(Vari vari) {
        return new Ratsu(vari);
    }

    public static Nappula luoLahetti(Vari vari, Vari ruutuVari) {
        return new Lahetti(vari, ruutuVari);

    }

    /**
     * Luo parametrina annetun loppupelityypin mukaiset valkeat nappulat.
     *
     * @param loppupeli loppupelityyppi
     * @return lista Nappula-olioita
     */
    public static ArrayList<Nappula> luoValkeat(Loppupeli loppupeli) {

        ArrayList<Nappula> nappulat = new ArrayList<>();
        nappulat.add(luoKuningas(Vari.Valkea));

        switch (loppupeli) {
            case DaamiJaKuningas: {
                nappulat.add(luoKuningatar(Vari.Valkea));
                break;
            }
            case TorniJaKuningas: {
                nappulat.add(luoTorni(Vari.Valkea));
                break;
            }
            case KaksiTorniaJaKuningas: {
                nappulat.add(luoTorni(Vari.Valkea));
                nappulat.add(luoTorni(Vari.Valkea));
                break;
            }
            case RatsuJaLahettiJaKuningas: {
                nappulat.add(luoRatsu(Vari.Valkea));
                nappulat.add(luoLahetti(Vari.Valkea, Vari.Valkea));
                break;
            }
            case KaksiLahettiaJaKuningas: {
                nappulat.add(luoLahetti(Vari.Valkea, Vari.Valkea));
                nappulat.add(luoLahetti(Vari.Valkea, Vari.Musta));
                break;
            }
        }
        return nappulat;
    }
}
