package chessTrainer.peliosat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import chesstrainer.apuluokat.Kirjain;
import chesstrainer.peliosat.Pelilauta;
import chesstrainer.peliosat.Ruutu;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sariraut
 */
public class RuutuTest {

    Pelilauta lauta;

    public RuutuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lauta = new Pelilauta();
    }

    @After
    public void tearDown() {
    }

    // Nappuloihin liittyvät testit
    //
    // 
    @Test
    public void OnkoVasemmanAlaKulmaRuudunNaapuritOikein() {
        
        Ruutu ruutu = lauta.getRuutu(Kirjain.a, 1);
        
        Ruutu n1 = lauta.getRuutu(Kirjain.a, 2);
        Ruutu n2 = lauta.getRuutu(Kirjain.b, 1);
        Ruutu n3 = lauta.getRuutu(Kirjain.b, 2);

        ArrayList<Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.contains(n1)
                && naapurit.contains(n2)
                && naapurit.contains(n3)
                && naapurit.size() == 3);
    }
    
    @Test
    public void OnkoOikeanAlaKulmaRuudunNaapuritOikein() {
        
        Ruutu ruutu = lauta.getRuutu(Kirjain.h, 1);
        
        Ruutu n1 = lauta.getRuutu(Kirjain.h, 2);
        Ruutu n2 = lauta.getRuutu(Kirjain.g, 1);
        Ruutu n3 = lauta.getRuutu(Kirjain.g, 2);

        ArrayList<Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.contains(n1)
                && naapurit.contains(n2)
                && naapurit.contains(n3)
                && naapurit.size() == 3);
    }

    @Test
    public void OnkoOikeanYlaKulmaRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(Kirjain.h, 8);

        Ruutu n1 = lauta.getRuutu(Kirjain.g, 8);
        Ruutu n2 = lauta.getRuutu(Kirjain.h, 7);
        Ruutu n3 = lauta.getRuutu(Kirjain.g, 7);

        ArrayList<Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.contains(n1)
                && naapurit.contains(n2)
                && naapurit.contains(n3)
                && naapurit.size() == 3);
    }
    
    @Test
    public void OnkoVasemmanYlaKulmaRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(Kirjain.a, 8);

        Ruutu n1 = lauta.getRuutu(Kirjain.b, 8);
        Ruutu n2 = lauta.getRuutu(Kirjain.a, 7);
        Ruutu n3 = lauta.getRuutu(Kirjain.b, 7);

        ArrayList<Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.contains(n1)
                && naapurit.contains(n2)
                && naapurit.contains(n3)
                && naapurit.size() == 3);
    }
    
    @Test
    public void OnkoKeskiRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(Kirjain.d, 5);

        Ruutu n1 = lauta.getRuutu(Kirjain.e, 5);
        Ruutu n2 = lauta.getRuutu(Kirjain.e, 4);
        Ruutu n3 = lauta.getRuutu(Kirjain.d, 4);
        Ruutu n4 = lauta.getRuutu(Kirjain.d, 6);
        Ruutu n5 = lauta.getRuutu(Kirjain.c, 5);
        Ruutu n6 = lauta.getRuutu(Kirjain.c, 4);
        Ruutu n7 = lauta.getRuutu(Kirjain.e, 6);
        Ruutu n8 = lauta.getRuutu(Kirjain.c, 6);

        ArrayList<Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.contains(n1)
                && naapurit.contains(n2)
                && naapurit.contains(n3)
                && naapurit.contains(n4)
                && naapurit.contains(n5)
                && naapurit.contains(n6)
                && naapurit.contains(n7)
                && naapurit.contains(n8)
                && naapurit.size() == 8);
    }
    
     @Test
    public void OnkoAlaReunaRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(Kirjain.f, 1);

        Ruutu n1 = lauta.getRuutu(Kirjain.e, 1);
        Ruutu n2 = lauta.getRuutu(Kirjain.e, 2);
        Ruutu n3 = lauta.getRuutu(Kirjain.f, 2);
        Ruutu n4 = lauta.getRuutu(Kirjain.g, 2);
        Ruutu n5 = lauta.getRuutu(Kirjain.g, 1);

        ArrayList<Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.contains(n1)
                && naapurit.contains(n2)
                && naapurit.contains(n3)
                && naapurit.contains(n4)
                && naapurit.contains(n5)
                && naapurit.size() == 5);
    }
    
    @Test
     public void OnkoYlaReunaRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(Kirjain.b, 8);

        Ruutu n1 = lauta.getRuutu(Kirjain.c, 8);
        Ruutu n2 = lauta.getRuutu(Kirjain.c, 7);
        Ruutu n3 = lauta.getRuutu(Kirjain.a, 8);
        Ruutu n4 = lauta.getRuutu(Kirjain.a, 7);
        Ruutu n5 = lauta.getRuutu(Kirjain.b, 7);

        ArrayList<Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.contains(n1)
                && naapurit.contains(n2)
                && naapurit.contains(n3)
                && naapurit.contains(n4)
                && naapurit.contains(n5)
                && naapurit.size() == 5);
    }
     
     @Test
     public void OnkoVasemmanReunaRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(Kirjain.a, 5);

        Ruutu n1 = lauta.getRuutu(Kirjain.a, 4);
        Ruutu n2 = lauta.getRuutu(Kirjain.a, 6);
        Ruutu n3 = lauta.getRuutu(Kirjain.b, 5);
        Ruutu n4 = lauta.getRuutu(Kirjain.b, 4);
        Ruutu n5 = lauta.getRuutu(Kirjain.b, 6);

        ArrayList<Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.contains(n1)
                && naapurit.contains(n2)
                && naapurit.contains(n3)
                && naapurit.contains(n4)
                && naapurit.contains(n5)
                && naapurit.size() == 5);
    }
     
      @Test
     public void OnkoOikeanReunaRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(Kirjain.h, 5);

        Ruutu n1 = lauta.getRuutu(Kirjain.h, 4);
        Ruutu n2 = lauta.getRuutu(Kirjain.h, 6);
        Ruutu n3 = lauta.getRuutu(Kirjain.g, 5);
        Ruutu n4 = lauta.getRuutu(Kirjain.g, 4);
        Ruutu n5 = lauta.getRuutu(Kirjain.g, 6);

        ArrayList<Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.contains(n1)
                && naapurit.contains(n2)
                && naapurit.contains(n3)
                && naapurit.contains(n4)
                && naapurit.contains(n5)
                && naapurit.size() == 5);
    }
}
