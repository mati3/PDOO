
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfazTextualQytetet;


import java.util.Map;
import java.util.ArrayList;
import modeloqytetet.Casilla;
import modeloqytetet.Jugador;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.Qytetet;
import modeloqytetet.TipoCasilla;

/**
 *
 * @author mati
 */
public class ControladorQytetet {
    
    private Qytetet juego;
    private Jugador jugador;
    private Casilla casilla;
    private VistaTextualQytetet vista = new VistaTextualQytetet();
   
    public void inicializacionJuego(){
        ArrayList<String> jugadores = vista.obtenerNombreJugadores();
        this.juego = Qytetet.getInstance(jugadores);
        juego.inicializarJuego(jugadores);
        this.jugador = this.juego.getJugadorActual(); 
        this.casilla = this.jugador.getCasillaActual();
        vista.mostrar(juego.toString());
        vista.pausar();
    }
    
    public void desarrrolloJuego()throws NumberFormatException{
        boolean termino = false ;
        while(!termino){
            boolean tienePropietario = false;
            vista.mostrar("\n nuevo turno");
            vista.mostrar("jugador: " + jugador.getNombre());
            vista.mostrar("SaldoJugador: " + jugador.getSaldo());
            vista.mostrar("casilla actual: \n" + casilla.toString());
            vista.pausar();
            //movimiento
            if(jugador.getEncarcelado()){
                //pagar la libertad o tirar el dado.
                int elegir = this.vista.menuSalirCarcel();              
                boolean logrosalicarcel = false ;
                if(elegir == 0){ // pago 200 euros
                    logrosalicarcel = juego.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
                    vista.mostrar(" eligo pagar 200 euros: " + logrosalicarcel);
                }else if(elegir == 1){ //tiro dado
                    logrosalicarcel=juego.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);   
                    vista.mostrar(" eligo tirar el dado : " + logrosalicarcel);
                }else
                    vista.mostrar("error, debe elegir una opcion");
                if(logrosalicarcel){
                    vista.mostrar(" jugador liberado de la carcel, sigue jugando "); // tengo que seguir jugando**********************************
                   
                }
            }
            if (!jugador.getEncarcelado()){
                 tienePropietario = juego.jugar();
                 casilla = jugador.getCasillaActual();
                 //porque no actualiza el juego.jugadoractual al jugador    ???????????????????????????????????????????????????????
                    vista.mostrar("he terminado de jugar");
                    vista.mostrar(" CasillaActual: ***************** " + casilla.toString());
                    vista.mostrar(" tienePropietario: " + tienePropietario);
                if(juego.getCartaActual()!=null){
                         vista.mostrar("tengo esta carta: " + juego.getCartaActual().toString());
                }
                if(casilla.getTipo() == TipoCasilla.CALLE){
                    vista.mostrar(" Estoy en una casilla tipo CALLE : \n " );
                    vista.mostrar(" CasillaActual: ***************** " + casilla.toString());
                    //vista.mostrar(jugador.getPropiedades().toString());
                    if(casilla.tengoPropietario() && casilla.getTituloPropiedad().getNombre()!=this.jugador.getNombre()){  
                        vista.mostrar(" Tengo que pagar alquiler " + casilla.getTituloPropiedad().getNombre() + " es el propietario \n " );
                        // eso se hace solo en jugar. 
                        vista.mostrar(" SaldoJugador nuevo: " + jugador.getSaldo());
                    }else{// si no tiene propietario la puedo comprar, darle opciones
                        vista.mostrar(" Puedes comprar un titulo de Propiedad \n " );
                        if(vista.elegirQuieroComprar()){
                           juego.comprarTituloPropiedad();
                           vista.mostrar(" he comprado el titulo: ***************** " + jugador.getPropiedades().toString());
                           vista.mostrar(" he comprado el tituloDeJuego: ***************** " + juego.getJugadorActual().getPropiedades().toString());
                        }
                    }
                    
                }else{
                    vista.mostrar(" la casilla no es de tipo calle");
                    if(casilla.getTipo() == TipoCasilla.SORPRESA){// es de tipo sorpres
                        vista.mostrar(" Estoy en una casilla SORPRESA, esta es mi CartaSorpresa : \n " + juego.getCartaActual().toString());
                        tienePropietario= juego.aplicarSorpresa();
                        vista.mostrar(" He aplicado mi sorpresa: \n " + juego.getCartaActual().toString());
                        vista.mostrar(" He aplicado mi sorpresa: \n " + juego.toString());
                    }
                }
                ////////////// tengo propiedades, no estoy en bancarrota y no estoy en la carcel, GESTION INMOBILIARIA //////////////////
                if(juego.getJugadorActual().getSaldo() > 0 && jugador.tengoPropiedades()){
                    vista.mostrar("EMPEZAMOS CON LAS PROPIEDADES..........que hacemos con ellas.................");
                                        
                    int opc=vista.menuGestionInmobiliaria();
                    boolean conseguido = false ;
                    switch (opc){
                        case 0: 
                            vista.mostrar(" Paso de turno ");
                            break;
                        case 1: // muestro todas las propiedades
                            vista.mostrar(" lista de propiedades ");
                            vista.mostrar(jugador.getPropiedades().toString() + "\n");
                            conseguido = juego.edificarCasa(ElegirCasillaDePropiedad(true,false));
                            vista.mostrar(" Edifico una casa " + conseguido );
                            break;
                        case 2: // muestro todas las propiedades
                            vista.mostrar(" lista de propiedades ");
                            vista.mostrar(jugador.getPropiedades().toString() + "\n");
                            conseguido = juego.edificarHotel(ElegirCasillaDePropiedad(true,false));
                            vista.mostrar(" Edifico un Hotel " + conseguido );
                            break;
                        case 3: //muestro solo las NO hipotecadas
                            vista.mostrar(" lista de propiedades ");
                            vista.mostrar(juego.propiedadesHipotecadasJugador(false).toString() + "\n");
                            conseguido = juego.venderPropiedad(ElegirCasillaDePropiedad(false,false));
                            vista.mostrar(" Vendo Propiedad elegida " + conseguido );
                            break;
                        case 4: //muestro solo las NO hipotecadas
                            vista.mostrar(" lista de propiedades ");
                            vista.mostrar(juego.propiedadesHipotecadasJugador(false).toString() + "\n");
                            
                            conseguido = juego.hipotecarPropiedad(ElegirCasillaDePropiedad(false,false));
                            vista.mostrar(" Hipoteco propiedad elegida " + conseguido );
                            break;
                        case 5: //muestro solo las SI hipotecadas
                            vista.mostrar(" lista de propiedades ");
                            vista.mostrar(juego.propiedadesHipotecadasJugador(true).toString() + "\n");
                            if(juego.propiedadesHipotecadasJugador(true) == null){
                                vista.mostrar(" ************** NO hay propiedades Hipotecadas. ************ " );
                            }else{
                                conseguido = juego.cancelarHipoteca(ElegirCasillaDePropiedad(false, true));
                                vista.mostrar(" Cancelo la hipoteca " + conseguido );
                            }
                            break;
                        default: System.out.println("Error");
                            break;
                    }
                }
            }     
            
            if(juego.getJugadorActual().getSaldo() <= 0){//if(jugador.getSaldo() <= 0){
                vista.mostrar("jugador en bancarrota, se termina el juego \n");
                vista.mostrar(" ranking de mejor a peor \n");
                Map map =  juego.obtenerRanking();
                map.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
                termino = true;
            }
            juego.siguienteJugador();
            this.jugador = this.juego.getJugadorActual();
            this.casilla = jugador.getCasillaActual();
        }
    }
    
    
    public Casilla ElegirCasillaDePropiedad (boolean hipotecada, boolean todo){// hipotecada si entra true mostrare todas, si entra false mostraré solo las NO hipotecadas
        ArrayList<Casilla> casillas = new ArrayList();
        Casilla aux;
        Casilla casillalocal;
        if(hipotecada == true){
            for(int i = 0; i < jugador.getPropiedades().size();i++){
                aux = jugador.getPropiedades().get(i).getCasilla();     
                casillas.add(aux);
            }
        }else{
            if(todo){ // muestra solo las SI hipotecadas cuando todo esta a true
                for(int i = 0; i < jugador.getPropiedades().size();i++){
                    aux = jugador.getPropiedades().get(i).getCasilla();   
                    if(aux.getTituloPropiedad().getHipotecada()){
                        casillas.add(aux);
                    }
                }
            }else{
                for(int i = 0; i < jugador.getPropiedades().size();i++){
                    aux = jugador.getPropiedades().get(i).getCasilla();   
                    if(!aux.getTituloPropiedad().getHipotecada()){
                        casillas.add(aux);
                    }
                }
            }
        }
        casillalocal = this.elegirPropiedad(casillas);
        return casillalocal ;
    }
    public Casilla elegirPropiedad(ArrayList<Casilla> propiedades){ 
     //este metodo toma una lista de propiedades y genera una lista de strings, con el numero y nombre de las propiedades
     //luego llama a la vista para que el usuario pueda elegir.
            vista.mostrar("\tCasilla\tTitulo");
            int seleccion;
            ArrayList<String> listaPropiedades= new ArrayList();
            for ( Casilla casilla: propiedades) {
                    listaPropiedades.add( "\t"+casilla.getNumeroCasilla()+"\t"+casilla.getTituloPropiedad().getNombre()); 
            }
        seleccion=vista.menuElegirPropiedad(listaPropiedades);  
        return propiedades.get(seleccion);
    }
    
    public static void main(String[] args) {
       
        ControladorQytetet c = new ControladorQytetet();
        c.inicializacionJuego();
        c.desarrrolloJuego();
        
       
    }
}
