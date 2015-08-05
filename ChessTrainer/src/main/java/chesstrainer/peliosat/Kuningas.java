/**
 * 
 */
package chesstrainer.peliosat;

import chesstrainer.apuluokat.Vari;

/**
 *
 * @author sariraut
 */
public class Kuningas extends Nappula implements Liikkuva{

    public Kuningas(Vari vari) {
        super(vari);
    }

    @Override
    public char getNimi() {
        return 'K'; 
    }

    @Override
    public void Liikkuu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
