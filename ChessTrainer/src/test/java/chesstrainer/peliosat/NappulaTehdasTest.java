/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer.peliosat;

import chesstrainer.apuluokat.Loppupeli;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sariraut
 */
public class NappulaTehdasTest {

    public NappulaTehdasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void LuokoLuoValkeatNappulatRLKOikein() {
        ArrayList<Nappula> valkeat = NappulaTehdas.LuoValkeat(Loppupeli.RLK);
        Assert.assertTrue(valkeat.get(0).getNimi()=='K');
        Assert.assertTrue(valkeat.get(1).getNimi()=='R');
        Assert.assertTrue(valkeat.get(2).getNimi()=='L');

    }
    
    @Test
    public void LuokoLuoValkeatNappulatTTKOikein() {
        ArrayList<Nappula> valkeat = NappulaTehdas.LuoValkeat(Loppupeli.TTK);
        Assert.assertTrue(valkeat.get(0).getNimi()=='K');
        Assert.assertTrue(valkeat.get(1).getNimi()=='T');
        Assert.assertTrue(valkeat.get(2).getNimi()=='T');

    }
}
