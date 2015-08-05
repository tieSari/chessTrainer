/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer.apuluokat;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sariraut
 */
public enum Kirjain {

    h(0),
    g(1),
    f(2),
    e(3),
    d(4),
    c(5),
    b(6),
    a(7);

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