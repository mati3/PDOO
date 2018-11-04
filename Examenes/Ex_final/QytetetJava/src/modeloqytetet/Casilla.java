/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author mati
 */
public abstract class Casilla {
    
    private int numeroCasilla;
    private int coste;
   // private int numHoteles; // va a calle
   // private int numCasas; // va a calle
    private TipoCasilla tipo; //los de tipo calle tienen hoteles y casas, el resto no?
   // private TituloPropiedad titulo; // va a calle

    // este va fuera
  /*  public Casilla(int numeroCasilla, int coste, int numHoteles, int numCasas, TipoCasilla tipo, TituloPropiedad titulo) {
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
        this.numHoteles = numHoteles; 
        this.numCasas = numCasas;
        this.tipo = tipo;
        this.titulo = titulo;
        this.titulo.setCasilla(this);
        
    }*/

    public Casilla(int numeroCasilla, int coste, TipoCasilla tipo) {
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
        this.tipo = tipo;
       // this.titulo = null; // va a calle
       // this.numHoteles = 0; // va a calle
       // this.numCasas = 0; // va a calle
    }
    
    public TipoCasilla getTipo() { 
        return this.tipo;
    }

    int getCoste() {
        return coste;
    } 
    public int getNumeroCasilla() { 
        return numeroCasilla;
    }
    
    //Devuelve cierto sólo si es una casilla de tipo CALLE.
    boolean soyEdificable(){
        return (this.tipo == TipoCasilla.CALLE);
    }

    @Override
    public String toString() {
        return "Casilla{" + "numeroCasilla=" + numeroCasilla + ",\n coste=" + coste + ",\n tipo=" + tipo + '}';
    }
    
    
    
}
