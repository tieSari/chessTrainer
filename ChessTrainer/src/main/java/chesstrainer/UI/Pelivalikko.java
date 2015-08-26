/*
 * Testikäyttöliittymän apuluokka
 * 
 */
package chesstrainer.UI;

/**
 *
 * @author sariraut
 */
public class Pelivalikko {

    public static void TulostaValikko() {

        System.out.println("Siirto annetaan muodossa "
                + "nappulan tunnus+lähtöruutu+kohderuutu, esim. de3e7");
        System.out.println("l lopettaa pelin\n");
        
        System.out.println("Valitse loppupeli:\n");
        System.out.println("1. DK");
        System.out.println("2. TK");
        System.out.println("3. TTK");
        System.out.println("4. LKK");

    }

}
