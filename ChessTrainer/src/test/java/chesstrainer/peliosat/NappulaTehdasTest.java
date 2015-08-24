/*
 * Nappuloiden luontiluokan testit
 * 
 */
package chesstrainer.peliosat;

import chesstrainer.apuluokat.Arvo;
import chesstrainer.apuluokat.Loppupeli;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sariraut
 */
public class NappulaTehdasTest {

    public NappulaTehdasTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void LuokoLuoValkeatNappulatRLKOikein() {
        ArrayList<Nappula> valkeat = NappulaTehdas.LuoValkeat(Loppupeli.RatsuJaLahettiJaKuningas);
        Assert.assertTrue(valkeat.get(0).getArvo()==Arvo.KUNINGAS);
        Assert.assertTrue(valkeat.get(1).getArvo()==Arvo.RATSU);
        Assert.assertTrue(valkeat.get(2).getArvo()==Arvo.LAHETTI);

    }
    
    @Test
    public void LuokoLuoValkeatNappulatTTKOikein() {
        ArrayList<Nappula> valkeat = NappulaTehdas.LuoValkeat(Loppupeli.KaksiTorniaJaKuningas);
        Assert.assertTrue(valkeat.get(0).getArvo()==Arvo.KUNINGAS);
        Assert.assertTrue(valkeat.get(1).getArvo()==Arvo.TORNI);
        Assert.assertTrue(valkeat.get(2).getArvo()==Arvo.TORNI);

    }
}
