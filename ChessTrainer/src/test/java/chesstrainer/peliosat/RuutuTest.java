package chesstrainer.peliosat;

/*
 * Pelilaudan Ruutu-luokan testit
 * 
 */

import chesstrainer.apuluokat.*;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sariraut
 */
public class RuutuTest {

    Pelilauta lauta;

    public RuutuTest() {
    }

    @Before
    public void setUp() {
        lauta = new Pelilauta();
    }

    @Test
    public void OnkoVasemmanAlaKulmaRuudunNaapuritOikein() {
        
        Ruutu ruutu = lauta.getRuutu(new Sijainti(Kirjain.a, 1));
        
        Ruutu n1 = lauta.getRuutu(new Sijainti(Kirjain.a, 2));
        Ruutu n2 = lauta.getRuutu(new Sijainti(Kirjain.b, 1));
        Ruutu n3 = lauta.getRuutu(new Sijainti(Kirjain.b, 2));

        Map<Suunta,Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.containsValue(n1)
                && naapurit.containsValue(n2)
                && naapurit.containsValue(n3)
                && naapurit.size() == 3);
    }
    
    @Test
    public void OnkoOikeanAlaKulmaRuudunNaapuritOikein() {
        
        Ruutu ruutu = lauta.getRuutu(new Sijainti(Kirjain.h, 1));
        
        Ruutu n1 = lauta.getRuutu(new Sijainti(Kirjain.h, 2));
        Ruutu n2 = lauta.getRuutu(new Sijainti(Kirjain.g, 1));
        Ruutu n3 = lauta.getRuutu(new Sijainti(Kirjain.g, 2));

        Map<Suunta,Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.containsValue(n1)
                && naapurit.containsValue(n2)
                && naapurit.containsValue(n3)
                && naapurit.size() == 3);
    }

    @Test
    public void OnkoOikeanYlaKulmaRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(new Sijainti(Kirjain.h, 8));

        Ruutu n1 = lauta.getRuutu(new Sijainti(Kirjain.g, 8));
        Ruutu n2 = lauta.getRuutu(new Sijainti(Kirjain.h, 7));
        Ruutu n3 = lauta.getRuutu(new Sijainti(Kirjain.g, 7));

        Map<Suunta,Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.containsValue(n1)
                && naapurit.containsValue(n2)
                && naapurit.containsValue(n3)
                && naapurit.size() == 3);
    }
    
    @Test
    public void OnkoVasemmanYlaKulmaRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(new Sijainti(Kirjain.a, 8));

        Ruutu n1 = lauta.getRuutu(new Sijainti(Kirjain.b, 8));
        Ruutu n2 = lauta.getRuutu(new Sijainti(Kirjain.a, 7));
        Ruutu n3 = lauta.getRuutu(new Sijainti(Kirjain.b, 7));

        Map<Suunta,Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.containsValue(n1)
                && naapurit.containsValue(n2)
                && naapurit.containsValue(n3)
                && naapurit.size() == 3);
    }
    
    @Test
    public void OnkoKeskiRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(new Sijainti(Kirjain.d, 5));

        Ruutu n1 = lauta.getRuutu(new Sijainti(Kirjain.e, 5));
        Ruutu n2 = lauta.getRuutu(new Sijainti(Kirjain.e, 4));
        Ruutu n3 = lauta.getRuutu(new Sijainti(Kirjain.d, 4));
        Ruutu n4 = lauta.getRuutu(new Sijainti(Kirjain.d, 6));
        Ruutu n5 = lauta.getRuutu(new Sijainti(Kirjain.c, 5));
        Ruutu n6 = lauta.getRuutu(new Sijainti(Kirjain.c, 4));
        Ruutu n7 = lauta.getRuutu(new Sijainti(Kirjain.e, 6));
        Ruutu n8 = lauta.getRuutu(new Sijainti(Kirjain.c, 6));

        Map<Suunta,Ruutu>  naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.containsValue(n1)
                && naapurit.containsValue(n2)
                && naapurit.containsValue(n3)
                && naapurit.containsValue(n4)
                && naapurit.containsValue(n5)
                && naapurit.containsValue(n6)
                && naapurit.containsValue(n7)
                && naapurit.containsValue(n8)
                && naapurit.size() == 8);
    }
    
     @Test
    public void OnkoAlaReunaRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(new Sijainti(Kirjain.f, 1));

        Ruutu n1 = lauta.getRuutu(new Sijainti(Kirjain.e, 1));
        Ruutu n2 = lauta.getRuutu(new Sijainti(Kirjain.e, 2));
        Ruutu n3 = lauta.getRuutu(new Sijainti(Kirjain.f, 2));
        Ruutu n4 = lauta.getRuutu(new Sijainti(Kirjain.g, 2));
        Ruutu n5 = lauta.getRuutu(new Sijainti(Kirjain.g, 1));

        Map<Suunta,Ruutu>  naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.containsValue(n1)
                && naapurit.containsValue(n2)
                && naapurit.containsValue(n3)
                && naapurit.containsValue(n4)
                && naapurit.containsValue(n5)
                && naapurit.size() == 5);
    }
    
    @Test
     public void OnkoYlaReunaRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(new Sijainti(Kirjain.b, 8));

        Ruutu n1 = lauta.getRuutu(new Sijainti(Kirjain.c, 8));
        Ruutu n2 = lauta.getRuutu(new Sijainti(Kirjain.c, 7));
        Ruutu n3 = lauta.getRuutu(new Sijainti(Kirjain.a, 8));
        Ruutu n4 = lauta.getRuutu(new Sijainti(Kirjain.a, 7));
        Ruutu n5 = lauta.getRuutu(new Sijainti(Kirjain.b, 7));

        Map<Suunta,Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.containsValue(n1)
                && naapurit.containsValue(n2)
                && naapurit.containsValue(n3)
                && naapurit.containsValue(n4)
                && naapurit.containsValue(n5)
                && naapurit.size() == 5);
    }
     
     @Test
     public void OnkoVasemmanReunaRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(new Sijainti(Kirjain.a, 5));

        Ruutu n1 = lauta.getRuutu(new Sijainti(Kirjain.a, 4));
        Ruutu n2 = lauta.getRuutu(new Sijainti(Kirjain.a, 6));
        Ruutu n3 = lauta.getRuutu(new Sijainti(Kirjain.b, 5));
        Ruutu n4 = lauta.getRuutu(new Sijainti(Kirjain.b, 4));
        Ruutu n5 = lauta.getRuutu(new Sijainti(Kirjain.b, 6));

        Map<Suunta,Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.containsValue(n1)
                && naapurit.containsValue(n2)
                && naapurit.containsValue(n3)
                && naapurit.containsValue(n4)
                && naapurit.containsValue(n5)
                && naapurit.size() == 5);
    }
     
      @Test
     public void OnkoOikeanReunaRuudunNaapuritOikein() {

        Ruutu ruutu = lauta.getRuutu(new Sijainti(Kirjain.h, 5));

        Ruutu n1 = lauta.getRuutu(new Sijainti(Kirjain.h, 4));
        Ruutu n2 = lauta.getRuutu(new Sijainti(Kirjain.h, 6));
        Ruutu n3 = lauta.getRuutu(new Sijainti(Kirjain.g, 5));
        Ruutu n4 = lauta.getRuutu(new Sijainti(Kirjain.g, 4));
        Ruutu n5 = lauta.getRuutu(new Sijainti(Kirjain.g, 6));

        Map<Suunta,Ruutu> naapurit = ruutu.getNaapuriRuudut();

        Assert.assertTrue(naapurit.containsValue(n1)
                && naapurit.containsValue(n2)
                && naapurit.containsValue(n3)
                && naapurit.containsValue(n4)
                && naapurit.containsValue(n5)
                && naapurit.size() == 5);
    }
}
