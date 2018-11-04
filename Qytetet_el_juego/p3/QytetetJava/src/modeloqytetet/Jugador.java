/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author mati
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
        this.cartaLibertad = new Sorpresa("sorpresa",0,TipoSorpresa.SALIRCARCEL );
        this.casillaActual = new Casilla(0,0,TipoCasilla.SALIDA);
        this.propiedades = new ArrayList();
    }

    public int getSaldo() {
        return saldo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public ArrayList<TituloPropiedad> getPropiedades() {
        return propiedades;
    }
        
    public Casilla getCasillaActual(){
        return this.casillaActual;
    }
    public boolean getEncarcelado(){
        return this.encarcelado;
    }
    //Devuelve verdadero cuando el jugador es propietario de algún título de propiedad y falso en caso contrario.
    public boolean tengoPropiedades(){
        return (this.propiedades.size() > 0) ;//(this.propiedades != null); //return (this.getPropiedades().size()>0); //
    }
    
    boolean actualizarPosicion(Casilla casilla){
        boolean tengoPropietario = false ;
        if(casilla.getNumeroCasilla() < this.casillaActual.getNumeroCasilla()){
            modificarSaldo(500); 
        }
        this.setCasillaActual(casilla);
        if(casilla.soyEdificable()){
            tengoPropietario = casilla.tengoPropietario();
            if(casilla.tengoPropietario()){
                boolean propencarcelado = casilla.propietarioEncarcelado();
                if(!propencarcelado){
                    int costeAlquiler = casilla.cobrarAlquiler();
                    modificarSaldo(-costeAlquiler);
                }
            }
        }else{
            if(casilla.getTipo() == TipoCasilla.IMPUESTO){
                int coste = 150 ; //casilla.getCoste();
                modificarSaldo(-coste);
            }
        }
        return tengoPropietario ;
    }
    
    boolean comprarTitulo(){
        boolean puedocomprar = false;
        if(this.casillaActual.soyEdificable()){
            boolean tengopropietario = this.casillaActual.tengoPropietario();
            if(!tengopropietario){
                int costeCompra = this.casillaActual.getCoste();
                if(costeCompra <= this.saldo){
                    TituloPropiedad titulo = this.casillaActual.asignarPropietario(this);
                    this.propiedades.add(titulo);
                    this.modificarSaldo(-costeCompra);
                    puedocomprar = true ;
                }
            }
        }
        return puedocomprar;
    }
    //Devuelve la carta Sorpresa cartaLibertad, pues el jugador ya ha hecho uso de ella. Esto implica que el jugador se queda sin esa carta. 
    //Presta atención a las referencias nulas, tendrás que utilizar una variable intermedia.
     Sorpresa devolverCartaLibertad(){
         Sorpresa aux = this.cartaLibertad;
        if(this.cartaLibertad != null){
            this.cartaLibertad = null ;
        }
        return aux;
    }
     
    void irACarcel(Casilla casilla){ //casilla = carcel
            setCasillaActual(casilla);
            setEncarcelado(true);
    }
    
     //Añade al saldo la cantidad del argumento. Si el argumento es negativo, el saldo quedará reducido.
    void modificarSaldo(int cantidad ){
        this.saldo = this.saldo + cantidad ;
    }
    
    int obtenerCapital(){
        int aux = this.saldo ;
        for(TituloPropiedad tp:this.propiedades){
            if(tp.getHipotecada()){
                aux = aux + tp.getCasilla().getCoste() + ((tp.getCasilla().getNumCasas()+ tp.getCasilla().getNumHoteles())* tp.getPrecioEdificar()) - tp.getHipotecaBase();
            }else
                aux = aux + tp.getCasilla().getCoste() + ((tp.getCasilla().getNumCasas()+ tp.getCasilla().getNumHoteles())* tp.getPrecioEdificar());
        }
        return aux;
    }
    
    /*Devuelve los títulos de propiedad del jugadorActual que estén hipotecados (cuando el parámetro hipotecada sea true) o que no estén hipotecados (cuando el parámetro hipotecada sea false).*/
    public ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada) {
        ArrayList<TituloPropiedad> propi = new ArrayList();
        if(hipotecada == true){
            for(TituloPropiedad tp:this.propiedades){
                if(tp.getHipotecada() == true){
                  propi.add(tp);
                }
            }
        }else{  
           for(TituloPropiedad tp:this.propiedades){ 
                if(tp.getHipotecada() == false){
                  propi.add(tp);
                }
           }
        }
      return propi;
    }
    
    void pagarCobrarPorCasaYHotel(int cantidad){
        int numeroTotal = this.cuantasCasasHotelesTengo();
        this.modificarSaldo(numeroTotal*cantidad);
    }
    
    public boolean pagarLibertad(int cantidad){ // cantidad = PrecioLibertad cambio de package a public
        boolean tengoSaldo = this.tengoSaldo(cantidad);
        if(tengoSaldo){
            this.modificarSaldo(-cantidad);
        }
        return tengoSaldo;
    }
    
    boolean puedoEdificarCasa(Casilla casilla){
        boolean tengoSaldo = false ;
        boolean esMia = this.esDeMipropiedad(casilla);
        if(esMia){
            int costeEdificarCasa = casilla.getPrecioEdificar();
            tengoSaldo = this.tengoSaldo(costeEdificarCasa);
        }
        return tengoSaldo ;
    }
   
    boolean puedoEdificarHotel(Casilla casilla){
        boolean tengoSaldo = false ;
        boolean esMia = this.esDeMipropiedad(casilla);
        if(esMia){
            int costeEdificarCasa = casilla.getPrecioEdificar();
            tengoSaldo = this.tengoSaldo(costeEdificarCasa);
        }
        return tengoSaldo ;
    }
    
    boolean puedoHipotecar(Casilla casilla){ //***************************************************
        boolean puedo = false ;
        
        if(!casilla.estaHipotecada() && esDeMipropiedad(casilla) && !this.getEncarcelado()){
            puedo = true ;
        }
        
        return puedo;
    }
    boolean puedoPagarHipoteca(Casilla casilla){
        return this.tengoSaldo(casilla.calcularValorHipoteca());
    }
    
    
    //Cierto sólo si la casilla es de la propiedad de ese jugador (usa para ello el método que acabas de implementar esDeMipropiedad) y no la tiene hipotecada.
    boolean puedoVenderPropiedad(Casilla casilla){
        boolean esMia = esDeMipropiedad(casilla);
        boolean hipotecada = casilla.estaHipotecada();
        return (esMia && !hipotecada);
    }

    void setCartaLibertad(Sorpresa carta){ //carta : Sorpresa = cartaActual
        this.cartaLibertad = carta ;
    }
    
    void setCasillaActual(Casilla casilla){
        this.casillaActual = casilla ;
    }
    
    void setEncarcelado(boolean encarcelado ){
        this.encarcelado = encarcelado;
    }
    //Cierto sólo si cartaLibertad no es nula.
    boolean tengoCartaLibertad(){
        return (this.cartaLibertad != null) ;
    }
   
    void venderPropiedad(Casilla casilla){
        int precioVenta = casilla.venderTitulo();
        this.modificarSaldo(precioVenta);
        this.eliminarDeMisPropiedades(casilla);
    }
    
    //Devuelve el total de casas y hoteles que tiene ese jugador en todas sus propiedades.
    private int cuantasCasasHotelesTengo(){
        return this.propiedades.size();
    }
    //Elimina el titulo de propiedad de esa casilla de su lista de propiedades.
    private void eliminarDeMisPropiedades(Casilla casilla){
        this.propiedades.remove(casilla.getTituloPropiedad()); //*********************************************************
    }
    
    //Cierto si el jugador tiene entre sus propiedades el título de propiedad de esa casilla. llamo en puedoVenderPropiedad
    private boolean esDeMipropiedad(Casilla casilla){
        boolean aux = false ;
        for(TituloPropiedad tp:this.propiedades){
            if(tp.getCasilla() == casilla){
                aux = true ;
            }
        }
        return aux;
    }
    
    //Devuelve verdadero si el saldo del jugador es superior o igual a cantidad.
    private boolean tengoSaldo(int cantidad){
        return (this.saldo >= cantidad);
    }

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
