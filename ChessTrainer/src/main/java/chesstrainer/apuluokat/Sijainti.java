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
public class Sijainti {
        
    private Kirjain kirjain;
    private int numero;

    public Sijainti(Kirjain kirjain, int numero) {
        this.kirjain = kirjain;
        this.numero = numero;
    }
   
    public Kirjain getKirjain() {
        return kirjain;
    }

    public void setKirjain(Kirjain kirjain) {
        this.kirjain = kirjain;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return ""+getKirjain() + getNumero();
    }
    
    
    
}
