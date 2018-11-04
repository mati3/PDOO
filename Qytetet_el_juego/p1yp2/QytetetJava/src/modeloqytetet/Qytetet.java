/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;
import static java.util.Collections.shuffle;

/**
 *
 * @author mati
 */

public class Qytetet {
    public static int MAXJUGADORES=4;
    static int MAXCARTAS = 10;
    static int MAXCASILLAS = 20;
    static int LIBERTAD = 200;
    static int SALDOSALIDA = 1000;
    private Dado dado = Dado.getInstance();
    private Sorpresa cartaActual; // 0 .. 1
    private ArrayList<Sorpresa> mazo; //MAX_CARTAS
    private Tablero tablero;
    private Jugador jugadorActual;
    private ArrayList<Jugador> jugadores = new ArrayList();

    
    private static Qytetet instance;
    
    private Qytetet(ArrayList<String> jugadores)throws NumberFormatException{
        inicializarCartasSorpresa();
        inicializarTablero();
        inicializarJugadores(jugadores);
        cartaActual = mazo.get(0);
        jugadorActual = this.jugadores.get(0);
    }

    public ArrayList<Sorpresa> getMazo() {
        return mazo;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    
    
    public static Qytetet getInstance(ArrayList<String> jugadores){
        
        if (instance == null)
            instance = new Qytetet(jugadores);
        return instance;
    }
    /*
    public boolean aplicarSorpresa(){
        return true;
    }
    public boolean cancelarHipoteca(Casilla casilla){
        return true;
    }
    public boolean comprarTituloPropiedad(){
        return true;
    }
    public boolean edificarCasa(Casilla casilla){
        return true;
    }
    public boolean edificarHotel(Casilla casilla){
        return true;
    }
    */
    public Sorpresa getCartaActual(){
        return this.cartaActual;
    }
    public Jugador getJugadorActual(){
        return this.jugadorActual;
    }
    
    /*
    public boolean hipotecarPropiedad(Casilla casilla){
        return true;
    }
    public void inicializarJuego( ArrayList<String> nombres){
    
    } 
    public boolean intentarSalirCarcel( MetodoSalirCarcel metodo) {
        return true;
    } 
    public boolean jugar() {
        return true;
    } 
    public ArrayList<Jugador> obtenerRanking() {
        return null;
    } 
    public ArrayList<Casilla> propiedadesHipotecadasJugador(boolean hipotecadas) {
        return null;
    } 
    public Jugador siguienteJugador() {
        return null;
    }
    
    public boolean venderPropiedad(Casilla casilla) {
        return true;
    } 
    private void encarcelarJugador() {
    
    } 
    */
    private void inicializarCartasSorpresa() {
        mazo = new ArrayList();
      
        mazo.add(new Sorpresa("Tu intuición te dice que mires debajo de esa piedra... ¡Que suerte, 50€!",50,TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Tu intuición te dice que mires debajo de esa piedra... Te encuentras a un escarabajo con un cuchillo y te roba 50€",50,TipoSorpresa.PAGARCOBRAR));
        
        mazo.add(new Sorpresa("Te han declarado cómplice de Bárcenas, ¡debes ir a la carcel!",9,TipoSorpresa.IRACASILLA)); ///////////////////////
        mazo.add(new Sorpresa("El espacio-tiempo esta hecho un caos, has retrocedido hasta la posición inicial de la partida !y sin cobrar nada¡",0,TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("!Has encontrado un camino subterráneo secreto¡ Avanza hasta la casilla 8.",8,TipoSorpresa.IRACASILLA));
        
        mazo.add(new Sorpresa("!Todo lo bueno tiene su lado malo¡ tienes que pagar 50€ por cada casa y hotel que tengas para pagar reparaciones.",50,TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("!Ratas, Ratas por todas partessss¡ Paga 100€ por cada casa y hotel que poseas.",100,TipoSorpresa.PORCASAHOTEL));
        
        mazo.add(new Sorpresa("¡eres el elegido y por ello cada jugador te da 25€!",3,TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Todo el mundo te mira mal, ¡y con razón! debes pagar 15€ a cada jugador sino quieres que te maten en el siguiente turno ",3,TipoSorpresa.PORJUGADOR));
        
        mazo.add(new Sorpresa("!Es tu dia de suerte, por un error te han declarado inocente y sales de la carcel!",0, TipoSorpresa.SALIRCARCEL));
        
        shuffle(mazo);
    } 
    
    private void inicializarJugadores(ArrayList<String> nombres )throws NumberFormatException{
           this.jugadores = new ArrayList();
           if(nombres.size() < MAXJUGADORES && nombres.size() >= 2 ){
               for(String s:nombres){
                   this.jugadores.add(new Jugador(s));
               }
           }else
              throw new NumberFormatException(" numero de jugadores incorrecto ");
    } 
    
    private void inicializarTablero() {
        this.tablero = new Tablero();// esto llama al constructor y este inicializa.
    } 
    /*
    private void salidaJugadores() {
    
    } 
    */

    @Override
    public String toString() {
        return "Qytetet{" + 
                "dado=" + dado + ",\n "
                + "cartaActual=" + cartaActual + ",\n "
                + "mazo=" + mazo + ", tablero=" + tablero + ",\n "
                + "jugadorActual=" + jugadorActual + ",\n "
                + "jugadores=" + jugadores + '}';
    }
    
    
    
}
