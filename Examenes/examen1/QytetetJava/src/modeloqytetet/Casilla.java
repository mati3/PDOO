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
public class Casilla {
    
    private int numeroCasilla;
    private int coste;
    private int numHoteles;
    private int numCasas;
    private TipoCasilla tipo; //los de tipo calle tienen hoteles y casas, el resto no?
    private TituloPropiedad titulo;

    public Casilla(int numeroCasilla, int coste, int numHoteles, int numCasas, TipoCasilla tipo, TituloPropiedad titulo) {
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
        this.numHoteles = numHoteles;
        this.numCasas = numCasas;
        this.tipo = tipo;
        this.titulo = titulo;
    }

    public Casilla(int numeroCasilla, int coste, TipoCasilla tipo) {
        this.numeroCasilla = numeroCasilla;
        this.coste = coste;
        this.tipo = tipo;
        this.titulo = null;
        this.numHoteles = 0;
        this.numCasas = 0;
    }

    public TipoCasilla getTipo() {
        return this.tipo;
    }
    
    public TituloPropiedad getTituloPropiedad() {
        return titulo;
    }
    
    /*
    TituloPropiedad asignarPropietario( Jugador jugador){
    
    }
    
    int calcularValorHipoteca(){
    
    }
    
    int cancelarHipoteca(){
    
    }
    
    int cobrarAlquiler(){
    
    }
    
    int edificarCasa(){
    
    }
    
    int edificarHotel(){
    
    }
    
    boolean estaHipotecada(){
    
    } 
    */
    
    int getCoste() {
        return coste;
    }
    
    /*
    int getCosteHipoteca(){
    
    }
    */
    
    int getNumeroCasilla() {
        return numeroCasilla;
    }

    int getNumHoteles() {
        return numHoteles;
    }

    int getNumCasas() {
        return numCasas;
    }
    
    /*
    int getPrecioEdificar({
    
    }
    
    int hipotecar(){
    
    }
    
    int precioTotalComprar(){
    
    }
    
    boolean propietarioEncarcelado(){
    
    }
    
    boolean sePuedeEdificarCasa(){
    
    }
    
    boolean sePuedeEdificarHotel(){
    
    }
    */

    void setNumHoteles(int numHoteles) {
        this.numHoteles = numHoteles;
    }

    void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }
    
    /*
    boolean soyEdificable(){
    
    }
    
    boolean tengoPropietario(){
    
    }
    
    int venderTitulo(){
    
    }
    
    */

    private void setTituloPropiedad(TituloPropiedad titulo) {
        this.titulo = titulo;
    }
    
    /*
    private void asignarTituloPropiedad(){
    
    }
    */

    @Override
    public String toString() {
        return "Casilla{" + "numeroCasilla=" + numeroCasilla + ",\n coste=" + coste +
                ",\n numHoteles=" + numHoteles + ",\n numCasas=" + numCasas +
                ",\n tipo Casilla=" + tipo + ",\n titulo en propiedad=" + titulo + '}';
    }
    
    
    
}
