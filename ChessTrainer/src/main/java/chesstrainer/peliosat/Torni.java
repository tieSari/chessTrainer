/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer.peliosat;

import chesstrainer.apuluokat.Suunta;
import chesstrainer.apuluokat.Vari;
import java.util.Map;

/**
 *
 * @author sariraut
 */
public class Torni extends Nappula implements Liikkuva {

    public Torni(Vari vari) {
        super(vari);
    }

    @Override
    public void asetaShakkiSuunnat() {

        getShakkiSuunnat().add(Suunta.ita);
        getShakkiSuunnat().add(Suunta.lansi);
        getShakkiSuunnat().add(Suunta.etela);
        getShakkiSuunnat().add(Suunta.pohjoinen);
    }

    @Override
    public char getNimi() {
        return 'T';
    }

    @Override
    public void Liikkuu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
