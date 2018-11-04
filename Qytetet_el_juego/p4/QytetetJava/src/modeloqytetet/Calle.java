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
public class Calle extends Casilla {
    
    private int numHoteles;
    private int numCasas;
    private TituloPropiedad titulo;
    
    public Calle(int numeroCasilla, int coste, int numHoteles, int numCasas, TipoCasilla tipo, TituloPropiedad titulo) {
        super(numeroCasilla,coste,tipo);
        this.numHoteles = numHoteles;
        this.numCasas = numCasas;
        this.titulo = titulo;
        this.titulo.setCasilla(this);       
    }
    
    public TituloPropiedad getTituloPropiedad() {
        return titulo;
    }
    
    TituloPropiedad asignarPropietario( Jugador jugador){
        this.titulo.setPropietario(jugador);
        return titulo ;
    }
    
    int calcularValorHipoteca(){
        int cantidad = (this.titulo.getHipotecaBase()+ (this.numCasas * 5/10 * this.titulo.getHipotecaBase()+ (this.numHoteles * this.titulo.getAlquilerBase())));
        return cantidad ;
    }
    
    int cancelarHipoteca(){ 
        return (this.calcularValorHipoteca()*10/100) + this.calcularValorHipoteca();
    }
    
    int cobrarAlquiler(){ 
        int costeAlquilerBase = this.titulo.getAlquilerBase();
        int coste = (costeAlquilerBase + (2 *((this.numCasas * 10/5) + (this.numHoteles * 2)))) ;
        this.titulo.cobrarAlquiler(coste);
        return coste;
    }
    
    int edificarCasa(){
        this.setNumCasas(this.numCasas + 1);
        int costeEdificarCasa = this.getPrecioEdificar();
        return costeEdificarCasa ;
    }
    
    int edificarHotel(){
        this.setNumHoteles(numHoteles + 1 );
        int costeEdificarHotel = this.getPrecioEdificar();
        return costeEdificarHotel ;
    }
    
    boolean estaHipotecada(){
        return this.titulo.getHipotecada();
    } 
    
    int getCosteHipoteca(){
        return this.calcularValorHipoteca();
    }
    
    int getNumHoteles() {
        return numHoteles;
    }
    
    int getNumCasas() {
        return numCasas;
    }
    
    int getPrecioEdificar(){
        return this.titulo.getPrecioEdificar() ;
    }
   
    int hipotecar(){
        this.titulo.setHipotecada(true);
        return this.getCosteHipoteca();
    }
    
    int precioTotalComprar(){
        return this.titulo.getAlquilerBase();
    }
    
    boolean propietarioEncarcelado(){
        return this.titulo.propietaroEncarcelado();
    }
    
    public boolean sePuedeEdificarCasa(int factorEspeculador){
        boolean sepuede = false ;
        if(this.numCasas < (4 * factorEspeculador) && this.soyEdificable()){
            sepuede = true ;
        }
        return sepuede ;
    }
    
    public boolean sePuedeEdificarHotel(int factorEspeculador){
        boolean sepuede = false ;
        if(this.numHoteles < (4 * factorEspeculador) && soyEdificable() ){
            sepuede = true ;
        }
        return sepuede ;
    }
    
    void setNumHoteles(int numHoteles) {
        this.numHoteles = numHoteles;
    }
    
    void setNumCasas(int numCasas) {
        this.numCasas = numCasas;
    }
    
    public boolean tengoPropietario(){ // cambio de package a publico
        return this.titulo.tengoPropietario();
    }
    
    int venderTitulo(){
        int precio = this.precioTotalComprar();
        precio += this.numHoteles * this.getPrecioEdificar();
        precio += this.numCasas * this.getPrecioEdificar();
        precio *= this.titulo.getFactorDevolucion();
        this.titulo.setPropietario(null);
        this.setNumCasas(0);
        this.setNumHoteles(0);
        return precio ;
    }
    
    
   // @Override
    void setTituloPropiedad(TituloPropiedad titulo) {
        this.titulo = titulo;
    }
    
   // @Override
    void asignarTituloPropiedad(){
        this.titulo = this.getTituloPropiedad() ;
    }
    
}
