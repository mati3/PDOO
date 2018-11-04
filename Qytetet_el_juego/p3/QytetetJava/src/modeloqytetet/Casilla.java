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
        this.titulo.setCasilla(this);
        
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
    
    
    TituloPropiedad asignarPropietario( Jugador jugador){
        this.titulo.setPropietario(jugador);
        return titulo ;
    }
    
    int calcularValorHipoteca(){
        int cantidad = (this.titulo.getHipotecaBase()+ (this.numCasas * 5/10 * this.titulo.getHipotecaBase()+ (this.numHoteles * this.titulo.getAlquilerBase())));
        return cantidad ;
    }
    
    int cancelarHipoteca(){ //***********************
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
    
    
    int getCoste() {
        return coste;
    }
    
   
    int getCosteHipoteca(){
        return this.calcularValorHipoteca();
    }
    
    
    public int getNumeroCasilla() { //package que pongo a publio *********************+
        return numeroCasilla;
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
        return this.titulo.getAlquilerBase();//////////////////////////////////
    }
   
    boolean propietarioEncarcelado(){
        return this.titulo.propietaroEncarcelado();
    }
    
    boolean sePuedeEdificarCasa(){
        boolean sepuede = false ;
        if(this.numCasas < 4 && this.soyEdificable()){
            sepuede = true ;
        }
        return sepuede ;
    }
    
    boolean sePuedeEdificarHotel(){
        boolean sepuede = false ;
        if(this.numHoteles < 4 && soyEdificable() ){
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
    
    
    //Devuelve cierto sólo si es una casilla de tipo CALLE.
    boolean soyEdificable(){
        return this.tipo == TipoCasilla.CALLE;
    }
    
    public boolean tengoPropietario(){ // cambio de package a publico
        return this.titulo.tengoPropietario();
    }
   
    int venderTitulo(){
        int precio = this.precioTotalComprar();
        precio += this.numHoteles * this.getPrecioEdificar();
        precio += this.numCasas * this.getPrecioEdificar();
        precio *= this.titulo.getFactorDevolucion(); // tengo un float aqui.......................................
        this.titulo.setPropietario(null);
        //this.titulo = null ;
        this.setNumCasas(0);//this.numCasas = 0 ;
        this.setNumHoteles(0);//this.numHoteles = 0;
        return precio ;
    }
    
    

    private void setTituloPropiedad(TituloPropiedad titulo) {
        this.titulo = titulo;
    }
    
   
    private void asignarTituloPropiedad(){
        this.titulo = this.getTituloPropiedad() ;
    }
    

    @Override
    public String toString() {
        return "Casilla{" + "numeroCasilla=" + numeroCasilla + ",\n coste=" + coste +
                ",\n numHoteles=" + numHoteles + ",\n numCasas=" + numCasas +
                ",\n tipo Casilla=" + tipo + ",\n titulo en propiedad=" + titulo + '}';
    }
    
    
    
}
