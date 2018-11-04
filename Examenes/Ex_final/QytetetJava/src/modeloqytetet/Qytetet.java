/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import GUIQytetet.Dado;
import java.util.Hashtable;
import java.util.ArrayList;
import static java.util.Collections.shuffle;
import java.util.HashMap;
import java.util.Map;

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
    public Dado dado = GUIQytetet.Dado.getInstance();
    private Sorpresa cartaActual; // 0 .. 1
    private ArrayList<Sorpresa> mazo; //MAX_CARTAS
    private Tablero tablero;
    private Jugador jugadorActual;
    private ArrayList<Jugador> jugadores = new ArrayList();

    
    private static Qytetet instance;
    
    private Qytetet(ArrayList<String> jugadores)throws NumberFormatException{
        inicializarJuego(jugadores);
        //cartaActual = mazo.get(0);
        //jugadorActual = this.jugadores.get(0);
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
    
    public boolean aplicarSorpresa()throws NumberFormatException{
        boolean tienePropietario = false ;
        if(this.cartaActual.getTipo() == TipoSorpresa.PAGARCOBRAR){
            this.jugadorActual.modificarSaldo(this.cartaActual.getValor());
        }else if(this.cartaActual.getTipo() == TipoSorpresa.IRACASILLA){
            boolean esCarcel = this.tablero.esCasillaCarcel(this.cartaActual.getValor());
            if(esCarcel){
                this.encarcelarJugador();
            }else{
                Casilla nuevaCasilla = this.tablero.obtenerCasillaNumero(this.cartaActual.getValor());
                tienePropietario = this.jugadorActual.actualizarPosicion(nuevaCasilla);
            }
        }else if(this.cartaActual.getTipo() == TipoSorpresa.PORCASAHOTEL){
            this.jugadorActual.pagarCobrarPorCasaYHotel(this.cartaActual.getValor());
        }else if(this.cartaActual.getTipo() == TipoSorpresa.PORJUGADOR){
            for(Jugador j:this.jugadores){
                if(j != this.jugadorActual){
                    j.modificarSaldo(this.cartaActual.getValor());
                    this.jugadorActual.modificarSaldo(this.cartaActual.getValor());
                }
            }
        }else if(this.cartaActual.getTipo() == TipoSorpresa.CONVERTIRME){
            int index = this.jugadores.indexOf(this.jugadorActual);
            jugadorActual = this.jugadorActual.convertirme(this.cartaActual.getValor());
            this.jugadores.add(index, this.jugadorActual);
        }
        
        if(this.cartaActual.getTipo() == TipoSorpresa.SALIRCARCEL){
            this.jugadorActual.setCartaLibertad(cartaActual);
        }else{
            this.mazo.add(cartaActual);// no se si la añade al final
        }
        return tienePropietario;
    }
    
    public boolean cancelarHipoteca(Calle casilla){
        boolean puedoCancelarHipotecaPropiedad = false ;
        if(casilla.estaHipotecada()&& this.jugadorActual.puedoPagarHipoteca(casilla)){
            ArrayList<TituloPropiedad> mispropiedadeshipotecadas = this.jugadorActual.obtenerPropiedadesHipotecadas(true);
            for(TituloPropiedad tp:mispropiedadeshipotecadas){
                if(tp == casilla.getTituloPropiedad()){
                    casilla.cancelarHipoteca();
                    tp.setHipotecada(false);
                    puedoCancelarHipotecaPropiedad = true ;
                }
            }
        }
        return puedoCancelarHipotecaPropiedad;
    }
    
    public boolean comprarTituloPropiedad(){
        return this.jugadorActual.comprarTitulo();
    }
    
    
    public boolean edificarCasa(Calle casilla){
        boolean puedoEdificar = false ;
        if(casilla.soyEdificable()){
            boolean sePuedeEdificar = casilla.sePuedeEdificarCasa(this.jugadorActual.getFactorEspeculador());
            if(sePuedeEdificar){
                puedoEdificar = this.jugadorActual.puedoEdificarCasa(casilla);
                if(puedoEdificar){
                    int costeEdificarCasa = casilla.edificarCasa();
                    this.jugadorActual.modificarSaldo(-costeEdificarCasa);//*******************************************************
                }
            }
        }
        return puedoEdificar ;
    }
    
    public boolean edificarHotel(Calle casilla){
        boolean puedoEdificar = false ;
        if(casilla.soyEdificable()){
            boolean sePuedeEdificar = casilla.sePuedeEdificarHotel(this.jugadorActual.getFactorEspeculador());
            if(sePuedeEdificar){
                puedoEdificar = this.jugadorActual.puedoEdificarHotel(casilla);
                if(puedoEdificar){
                    int costeEdificarHotel = casilla.edificarHotel();
                    this.jugadorActual.modificarSaldo(-costeEdificarHotel);//******************************************************
                }
            }
        }
        return puedoEdificar ;
    }
    
    public Sorpresa getCartaActual(){
        return this.cartaActual;
    }
    public Jugador getJugadorActual(){
        return this.jugadorActual;
    }
    
    
    public boolean hipotecarPropiedad(Calle casilla){ 
        boolean puedoHipotecarPropiedad = false;
        if(casilla.soyEdificable()){
            boolean sePuedeHipotecar = !casilla.estaHipotecada();
            if(sePuedeHipotecar){
                puedoHipotecarPropiedad = this.jugadorActual.puedoHipotecar(casilla);
                if(puedoHipotecarPropiedad){
                    int cantidadRecibida = casilla.hipotecar();
                    this.jugadorActual.modificarSaldo(cantidadRecibida);
                }
            }
        }
        
        return puedoHipotecarPropiedad;
    }
    
    public void inicializarJuego(ArrayList<String> jugadores)throws NumberFormatException{
        inicializarCartasSorpresa();
        inicializarTablero();
        inicializarJugadores(jugadores);
        this.salidaJugadores();
    } 
    
    public boolean intentarSalirCarcel( MetodoSalirCarcel metodo) {
        boolean libre = false ;
        if(metodo == MetodoSalirCarcel.TIRANDODADO){
            int valorDado = this.dado.nextNumber();
            if(valorDado == 5 || valorDado == 6){
                return libre = true;
            }
        }else if (metodo == MetodoSalirCarcel.PAGANDOLIBERTAD){
            boolean tengoSaldo = this.jugadorActual.pagarLibertad(200);
            if(tengoSaldo){
                libre = true ;
            }
        }
        if(libre){
            this.jugadorActual.setEncarcelado(false);
        }
        return libre;
    } 
    public boolean jugar()throws NumberFormatException {
        int valorDado = this.dado.nextNumber();//cambio jugar por privatenextnumber
        Casilla casillaPosicion = this.jugadorActual.getCasillaActual();
        Casilla nuevaCasilla = this.tablero.obtenerNuevaCasilla(casillaPosicion, valorDado);
        boolean tienePropietario = this.jugadorActual.actualizarPosicion(nuevaCasilla);
        if(!nuevaCasilla.soyEdificable()){
            if(nuevaCasilla.getTipo() == TipoCasilla.JUEZ){
                this.encarcelarJugador();
            }else if(nuevaCasilla.getTipo() == TipoCasilla.SORPRESA){
                this.cartaActual = this.mazo.get(0); // primera carta
                mazo.remove(cartaActual);
            }
        }
        return tienePropietario;
    } 
    public Map<String,String> obtenerRanking() { //Map<String,String> hm = new HashMap
        Map<String,String> ranking = new HashMap();
        for(Jugador j:this.jugadores){
            int capital = j.obtenerCapital();
            ranking.put(j.getNombre(),String.valueOf(capital)); 
        }
        return ranking;
    } 
    
    public ArrayList<Casilla> propiedadesHipotecadasJugador(boolean hipotecadas) {
        ArrayList<Casilla> casillas = new ArrayList();
        if(hipotecadas == true){
            for(TituloPropiedad tp:this.jugadorActual.getPropiedades()){
                if(tp.getHipotecada() == true){
                  casillas.add(tp.getCasilla());
                }
            }
        }else{  
           for(TituloPropiedad tp:this.jugadorActual.getPropiedades()){ 
                if(tp.getHipotecada() == false){
                  casillas.add(tp.getCasilla());
                }
           }
        }
      return casillas;
    } 
    
    public void siguienteJugador() {
        int index = this.jugadores.size();
        if(this.jugadorActual == this.jugadores.get(index-1)){
           this.jugadorActual = this.jugadores.get(0);
        }else{
         index = jugadores.indexOf(jugadorActual);
         jugadorActual = jugadores.get(index + 1);// index + 1
        }
    }
    
    public boolean venderPropiedad(Calle casilla) {
        boolean puedoVender = false;
        if(casilla.soyEdificable()){
            puedoVender = this.jugadorActual.puedoVenderPropiedad(casilla);
            if(puedoVender){
                this.jugadorActual.venderPropiedad(casilla);
            }
        }
        return puedoVender;
    } 
    
    private void encarcelarJugador() {
        if(!this.jugadorActual.tengoCartaLibertad()){///////////////7
            Casilla casillaCarcel = this.tablero.getCarcel();
            this.jugadorActual.irACarcel(casillaCarcel);
        }else{
            Sorpresa carta = this.jugadorActual.devolverCartaLibertad();
            this.mazo.add(carta); 
        }
    } 
    
    private void inicializarCartasSorpresa() {
        mazo = new ArrayList();
      
        mazo.add(new Sorpresa("Tu intuición te dice que mires debajo de esa piedra... ¡Que suerte, 50€!",50,TipoSorpresa.PAGARCOBRAR));
        mazo.add(new Sorpresa("Tu intuición te dice que mires debajo de esa piedra... Te encuentras a un escarabajo con un cuchillo y te roba 50€",-50,TipoSorpresa.PAGARCOBRAR));
        
        mazo.add(new Sorpresa("Te han declarado cómplice de Bárcenas, ¡debes ir a la carcel!",9,TipoSorpresa.IRACASILLA)); ///////////////////////
        mazo.add(new Sorpresa("El espacio-tiempo esta hecho un caos, has retrocedido hasta la posición inicial de la partida !y sin cobrar nada¡",0,TipoSorpresa.IRACASILLA));
        mazo.add(new Sorpresa("!Has encontrado un camino subterráneo secreto¡ Avanza hasta la casilla 8.",8,TipoSorpresa.IRACASILLA));
        
        mazo.add(new Sorpresa("!Todo lo bueno tiene su lado malo¡ tienes que pagar 50€ por cada casa y hotel que tengas para pagar reparaciones.",-50,TipoSorpresa.PORCASAHOTEL));
        mazo.add(new Sorpresa("!Ratas, Ratas por todas partessss¡ Paga 100€ por cada casa y hotel que poseas.",-100,TipoSorpresa.PORCASAHOTEL));
        
        mazo.add(new Sorpresa("¡eres el elegido y por ello cada jugador te da 25€!",25,TipoSorpresa.PORJUGADOR));
        mazo.add(new Sorpresa("Todo el mundo te mira mal, ¡y con razón! debes pagar 15€ a cada jugador sino quieres que te maten en el siguiente turno ",-15,TipoSorpresa.PORJUGADOR));
        
        mazo.add(new Sorpresa("!Es tu dia de suerte, por un error te han declarado inocente y sales de la carcel!",0, TipoSorpresa.SALIRCARCEL));
        
        mazo.add(new Sorpresa("Convertirme ... ¡Que suerte,te conviertes 3000€!",3000,TipoSorpresa.CONVERTIRME));
        mazo.add(new Sorpresa("Convertirme... Te conviertes 5000€",5000,TipoSorpresa.CONVERTIRME));
        
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
    
    //Posiciona a todos los jugadores en la casilla de salida, con un saldo de 7500 € y asigna de forma aleatoria el jugador actual.
    private void salidaJugadores() {
        for(Jugador j:this.jugadores){
            if(j.getSaldo() != 7500){
                j.modificarSaldo(7500);
            }
            if(j.getCasillaActual().getTipo() != TipoCasilla.SALIDA){
                j.setCasillaActual(this.tablero.obtenerCasillaNumero(0));//en el tablero la casilla 0 es la salida
            }
        }
        jugadorActual = jugadores.get((int)(Math.random()*jugadores.size()));
    } 
    

    @Override
    public String toString() {
        return "Qytetet{" + 
                "dado=" + dado + ",\n "
                + "cartaActual=" + cartaActual + ",\n "
                + "mazo=" + mazo + ",\n"
                + " tablero=" + tablero + ",\n "
                + "jugadorActual=" + jugadorActual + ",\n "
                + "jugadores=" + jugadores + '}';
    }
    
    
    
}
