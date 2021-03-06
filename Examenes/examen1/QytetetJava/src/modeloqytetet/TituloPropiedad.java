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
public class TituloPropiedad {
    
    private String nombre;
    private boolean hipotecada;
    private int alquilerBase;
    private float factorRevalorizacion;
    private int hipotecaBase;
    private int precioEdificar;
    private Jugador propietario; // sin uso, si lo pongo hay que cambiar en tablero que usos titulo propiedad.
    private Casilla casilla; // si tipocasilla== calle tendrá asociado un titulo de propiedad y si no es asi no lo tendrá

    //no se que atributos no hay que pasar como argumento
    public TituloPropiedad(String nombre, boolean hipotecada, int alquilerBase, float factorRevalorizcion, int hipotecaBase, int precioEdificar) {
        this.nombre = nombre;
        this.hipotecada = hipotecada;
        this.alquilerBase = alquilerBase;
        this.factorRevalorizacion = factorRevalorizcion;
        this.hipotecaBase = hipotecaBase;
        this.precioEdificar = precioEdificar;
    }
    
    /*
    void cobrarAlquiler(int coste){
    
    }
    */
    
    int getAlquilerBase() {
        return alquilerBase;
    }
    
    float getFactorDevolucion(){
        return factorRevalorizacion;
    }
    
    int getHipotecaBase() {
        return hipotecaBase;
    }
    
    boolean getHipotecada(){
        return this.hipotecada ; 
    }

    String getNombre() {
        return nombre;
    }
    
    int getPrecioEdificar() {
        return precioEdificar;
    }
    
    /*
    boolean propietaroEncarcelado(){
    
    }
    */
    
    void setCasilla(Casilla casilla){
        this.casilla = casilla ;
    }
    
    void setHipotecada(boolean hipotecada) {
        this.hipotecada = hipotecada;
    }
    
    void setPropietario(Jugador propietario){
        this.propietario = propietario ;
    }
    
    /*
    boolean tengoPropietario(){
    
    }
    */
    
    @Override
    public String toString() {
        return "TituloPropiedad{" + "\n nombre=" + nombre + ",\n hipotecada=" + hipotecada + ",\n alquilerBase=" +
                alquilerBase + ",\n factorRevalorizcion=" + factorRevalorizacion + ",\n hipotecaBase=" + hipotecaBase + ",\n precioEdificar=" + precioEdificar + '}';
    }
    
    
    
    
}
