/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer.apuluokat;

/**
 *
 * @author sariraut
 */
public enum Arvo {

    KUNINGAS(0),
    DAAMI(1),
    TORNI(2),
    RATSU(3),
    LAHETTI(4),
    SOTILAS(5);

    private final int value;

    private Arvo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
