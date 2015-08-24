
package chesstrainer.apuluokat;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 *enum-luokka shakkilaudan kirjaimille
 */
public enum Kirjain {

    h(7),
    g(6),
    f(5),
    e(4),
    d(3),
    c(2),
    b(1),
    a(0);

    private final int value;

    private Kirjain(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    private static final Map<Integer, Kirjain> lookup = new HashMap<>();
 
    static {
        for (Kirjain k : EnumSet.allOf(Kirjain.class))
            lookup.put(k.getValue(), k);
    }
 
    public static Kirjain get(int value) {
        return lookup.get(value);
    }
}
