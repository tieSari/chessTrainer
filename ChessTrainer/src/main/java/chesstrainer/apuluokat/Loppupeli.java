
package chesstrainer.apuluokat;

/**
 * enum-luokka pelaajan valittavissa oleville loppupelityypeille.
 */
public enum Loppupeli {

    DaamiJaKuningas(1),
    TorniJaKuningas(2),
    KaksiTorniaJaKuningas(3),
    RatsuJaLahettiJaKuningas(4),
    KaksiLahettiaJaKuningas(5);
    
    private final int value;

    private Loppupeli(int value) {
        this.value = value;

    }
}
