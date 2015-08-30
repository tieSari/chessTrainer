
package chesstrainer.rakenteet;

import chesstrainer.peliosat.Ruutu;

/**
 * Rajapintaluokka, jonka liikkuu-metodin nappulat toteuttavat.
 */
public interface Liikkuva {
   
    /**
     * Metodi toteuttaa nappuloiden liikkumisen parametrina annettuun ruutuun.
     * @param uusiRuutu
     * @return onkoLiikkuminenOk
     */
    public boolean liikkuu(Ruutu uusiRuutu);
    
}
