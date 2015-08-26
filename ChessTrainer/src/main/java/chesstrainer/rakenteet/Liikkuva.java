
package chesstrainer.rakenteet;

import chesstrainer.peliosat.Ruutu;

/**
 * Rajapintaluokka, jonka Liikkuu-metodin nappulat toteuttavat.
 */
public interface Liikkuva {
   
    /**
     * Metodi toteuttaa nappuloiden liikkumisen parametrina annettuun ruutuun.
     * @param uusiRuutu
     * @return onkoLiikkuminenOk
     */
    public boolean Liikkuu(Ruutu uusiRuutu);
    
}
