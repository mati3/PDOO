/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author chipi
 */
public class Jugador {
    
    private boolean encarcelado;
    private String nombre;
    private int saldo;
    private Sorpresa cartaLibertad; //0..1 cartaLibertad.gettipo()==TipoSorpresa.SalirCarcel
    private Casilla casillaActual;
    private ArrayList<TituloPropiedad> propiedades;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.encarcelado = false ;
        this.saldo = 7500 ;
        this.cartaLibertad= new Sorpresa("sorpresa",0,TipoSorpresa.SALIRCARCEL );
        this.casillaActual = new Casilla(0,0,TipoCasilla.SALIDA);
        this.propiedades = new ArrayList();
    }
    
    
    
    public Casilla getCasillaActual(){
        return this.casillaActual;
    }
    public boolean getEncarcelado(){
        return this.encarcelado;
    }
    /*
    public boolean tengoPropiedades(){
        return true;
    }
    boolean actualizarPosicion(Casilla casilla){
        return true;
    }
    boolean comprarTitulo(){
        return true;
    }
     Sorpresa devolverCartaLibertad(){
        return null;
    }
    void irACarcel(Casilla casilla){
            //casilla = carcel
    }
    void modificarSaldo(int cantidad ){

    }
    int obtenerCapital(){
        return 0;
    }
    ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada) {
        return null;
    }
    void pagarCobrarPorCasaYHotel(int cantidad){

    }
    
    boolean pagarLibertad(int cantidad){ // cantidad = PrecioLibertad
        return true;
    }
    
    boolean puedoEdificarCasa(Casilla casilla){
        return true;
    }
    boolean puedoEdificarHotel(Casilla casilla){
        return true;
    }
    boolean puedoHipotecar(Casilla casilla){
        return true;
    }
    boolean puedoPagarHipoteca(Casilla casilla){
        return true;
    }
    boolean puedoVenderPropiedad(Casilla casillaa){
        return true;
    }
    */

    void setCartaLibertad(Sorpresa carta){ //carta : Sorpresa = cartaActual
        this.cartaLibertad = carta ;
    }
    
    void setCasillaActual(Casilla casilla){
        this.casillaActual = casilla ;
    }
    
    void setEncarcelado(boolean encarcelado ){
        this.encarcelado = encarcelado;
    }
    /*
    boolean tengoCartaLibertad(){
        return true;
    }
    void venderPropiedad(Casilla casilla){
    
    }
    
    private int cuantasCasasHotelesTengo(){
        return 0;
    }
    private void eliminarDeMisPropiedades(Casilla casilla){
    
    }
    
    private boolean esDeMipropiedad(Casilla casilla){
        return true;
    }
    
    private boolean tengoSaldo(int cantidad){
        return true;
    }

    */

    @Override
    public String toString() {
        return "Jugador{" + "\n encarcelado=" + encarcelado + 
                ",\n nombre=" + nombre + 
                ",\n saldo=" + saldo + 
                ",\n cartaLibertad=" + cartaLibertad + 
                ",\n casillaActual=" + casillaActual + 
                ",\n propiedades=" + propiedades + '}';
    }
    
    
}
