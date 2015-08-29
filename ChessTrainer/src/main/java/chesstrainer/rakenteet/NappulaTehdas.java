package chesstrainer.rakenteet;

import chesstrainer.apuluokat.Loppupeli;
import chesstrainer.apuluokat.Vari;
import chesstrainer.peliosat.*;
import java.util.ArrayList;

/**
 * Tehdas-luokka eri nappulatyyppien luomiseen.
 */
public class NappulaTehdas {

    public static Nappula LuoKuningas(Vari vari) {
        return new Kuningas(vari);
    }

    public static Nappula LuoKuningatar(Vari vari) {
        return new Kuningatar(vari);
    }

    public static Nappula LuoTorni(Vari vari) {
        return new Torni(vari);
    }

    public static Nappula LuoRatsu(Vari vari) {
        return new Ratsu(vari);
    }

    public static Nappula LuoLahetti(Vari vari, Vari ruutuVari) {
        return new Lahetti(vari, ruutuVari);

    }

    /**
     * Luo parametrina annetun loppupelityypin mukaiset valkeat nappulat.
     *
     * @param loppupeli
     * @return lista Nappula-olioita
     */
    public static ArrayList<Nappula> LuoValkeat(Loppupeli loppupeli) {

        ArrayList<Nappula> nappulat = new ArrayList<>();
        nappulat.add(LuoKuningas(Vari.Valkea));

        switch (loppupeli) {
            case DaamiJaKuningas: {
                nappulat.add(LuoKuningatar(Vari.Valkea));
                break;
            }
            case TorniJaKuningas: {
                nappulat.add(LuoTorni(Vari.Valkea));
                break;
            }
            case KaksiTorniaJaKuningas: {
                nappulat.add(LuoTorni(Vari.Valkea));
                nappulat.add(LuoTorni(Vari.Valkea));
                break;
            }
            case RatsuJaLahettiJaKuningas: {
                nappulat.add(LuoRatsu(Vari.Valkea));
                nappulat.add(LuoLahetti(Vari.Valkea, Vari.Valkea));
                break;
            }
            case KaksiLahettiaJaKuningas: {
                nappulat.add(LuoLahetti(Vari.Valkea,Vari.Valkea));
                nappulat.add(LuoLahetti(Vari.Valkea, Vari.Musta));
                break;
            }
        }
        return nappulat;
    }
}
