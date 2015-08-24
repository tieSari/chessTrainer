package chesstrainer.apuluokat;

/**
 * enum-luokka nappuloiden väreille.
 */
public enum Vari {

    Valkea(1),
    Musta(0);

    private final int value;

    private Vari(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
