
package chesstrainer.peliosat;

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
