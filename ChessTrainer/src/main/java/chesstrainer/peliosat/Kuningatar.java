/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chesstrainer.peliosat;

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
    public void Liikkuu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
