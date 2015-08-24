
package chesstrainer.rakenteet;

import chesstrainer.peliosat.Ruutu;

/**
 * Rajapintaluokka, jonka Liikkuu-metodin nappulat toteuttavat
 */
public interface Liikkuva {
   
    /**
     *
     * @param uusiRuutu
     * @return onkoLiikkuminenOk
     */
    public boolean Liikkuu(Ruutu uusiRuutu);
    
}
