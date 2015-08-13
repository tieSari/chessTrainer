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
public class Kuningatar extends Nappula implements Liikkuva{

    public Kuningatar(Vari vari) {
        super(vari);
    }

    @Override
    public char getNimi() {
        return 'D'; 
    }
    
      
    @Override
    public void asetaShakkiSuunnat() {
        
        getShakkiSuunnat().add(Suunta.ita);
        getShakkiSuunnat().add(Suunta.lansi);
        getShakkiSuunnat().add(Suunta.etela);
        getShakkiSuunnat().add(Suunta.pohjoinen);
        getShakkiSuunnat().add(Suunta.lounas);
        getShakkiSuunnat().add(Suunta.luode);
        getShakkiSuunnat().add(Suunta.kaakko);
        getShakkiSuunnat().add(Suunta.koillinen);
    }
    
}
