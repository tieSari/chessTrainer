
package chesstrainer.apuluokat;

/**
 * enum-luokka pelaajan valittavissa oleville loppupelityypeille.
 */
public enum Loppupeli {

    DK(1),
    TK(2),
    TTK(3),
    RLK(4);
    
    private final int value;

    private Loppupeli(int value) {
        this.value = value;

    }
}
