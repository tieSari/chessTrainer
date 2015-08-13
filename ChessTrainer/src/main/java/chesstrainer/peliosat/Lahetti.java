/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer.peliosat;

import chesstrainer.apuluokat.Suunta;
import chesstrainer.apuluokat.Vari;

/**
 *
 * @author sariraut
 */
public class Lahetti extends Nappula {

    public Lahetti(Vari vari) {
        super(vari);
    }

    @Override
    public char getNimi() {
        return 'L';
    }

@Override
    public void asetaShakkiSuunnat() {
        
        getShakkiSuunnat().add(Suunta.lounas);
        getShakkiSuunnat().add(Suunta.luode);
        getShakkiSuunnat().add(Suunta.kaakko);
        getShakkiSuunnat().add(Suunta.koillinen);
    }
}
