
package chesstrainer.peliosat;

import chesstrainer.apuluokat.Loppupeli;
import chesstrainer.apuluokat.Vari;
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

    public static Nappula LuoLahetti(Vari vari) {
        return new Lahetti(vari);

    }

    public static ArrayList<Nappula> LuoValkeat(Loppupeli loppupeli) {

        ArrayList<Nappula> nappulat = new ArrayList<>();
        //nappulat.add(LuoKuningas(Vari.Musta));
        nappulat.add(LuoKuningas(Vari.Valkea));

        switch (loppupeli) {
            case DK: {
                nappulat.add(LuoKuningatar(Vari.Valkea));
                break;
            }
            case TK: {
                nappulat.add(LuoTorni(Vari.Valkea));
                break;
            }
            case TTK: {
                nappulat.add(LuoTorni(Vari.Valkea));
                nappulat.add(LuoTorni(Vari.Valkea));
                break;
            }
             case RLK: {
                nappulat.add(LuoRatsu(Vari.Valkea));
                nappulat.add(LuoLahetti(Vari.Valkea));
                break;
            }
        }
        return nappulat;
    }
}
