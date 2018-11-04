/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package modeloqytetet;

//import java.util.ArrayList;

/**
 *
 * @author mati
 */
/*public class PruebaQytetet {
    
    private static ArrayList<Sorpresa> mazo = new ArrayList(); // atributo de clase
    private Tablero tablero = new Tablero();
    
    private static void inicializarSorpresas(){ // estatico, no return
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
    }; 
    
    // metodo estatico para poder llamarlo en main que es static
    private static ArrayList<Sorpresa> metodo1(){//Sorpresas que tienen un valor mayor que 0.
        ArrayList<Sorpresa> sorp = new ArrayList();
        for(Sorpresa s:mazo){
            if(s.getValor() > 0 ){
                sorp.add(s);
            }
        }
        return sorp;
    }
    
    private static ArrayList<Sorpresa> metodo2(){//Sorpresas de TipoSorpresa IRACASILLA.
        ArrayList<Sorpresa> sor = new ArrayList();
        for(Sorpresa s:mazo){
            if(s.getTipo() == TipoSorpresa.IRACASILLA){
                sor.add(s);
            }
        }
        return sor;
    }
    
    private static ArrayList<Sorpresa> metodo3(TipoSorpresa sorpresa){//Sorpresas del TipoSorpresa especificado en el argumento del método.
        ArrayList<Sorpresa> sorp = new ArrayList();
        for(Sorpresa s:mazo){
            if(s.getTipo()== sorpresa){
                sorp.add(s);
            }
        }
        return sorp;
    }
*/
    /**
     * @param args the command line arguments
     */
 /*   public static void main(String[] args) {
        // TODO code application logic here
        
        inicializarSorpresas();
        
        System.out.print("Todo el mazo \n");
        for(Sorpresa s:mazo){
            System.out.print(s.toString()+ "\n");
        }
        
        ArrayList<Sorpresa> med = metodo1();
        
        System.out.print("\n Metodo 1, Sorpresas que tienen un valor mayor que 0. \n");
        for(Sorpresa s:med){
            System.out.print(s + "\n");
        }
        
        System.out.print("\n Metodo 2, Sorpresas de TipoSorpresa IRACASILLA.  \n");
       
        System.out.print(metodo2().toString() + "\n");    
        
        
        System.out.print("\n Metodo 3, Sorpresas del TipoSorpresa especificado en el argumento del método. \n");
        med = metodo3(TipoSorpresa.PAGARCOBRAR);
        for(Sorpresa s:med){
            System.out.print(s + "\n");
        }
        
        System.out.print("\n Pruebo las cosas de la practica 2 \n");
      
        System.out.print("\n única instancia de la clase Qytetet \n");
        
        ArrayList<String> j = new ArrayList();
        j.add("juan");
        j.add("Mar´");
      
        Qytetet unico;
        try{
            
        
            unico = Qytetet.getInstance(j) ;
        }
        catch(Exception e) {
                System.out.println("Introduce número correcto");
                 j.add("juan");
       
                unico =Qytetet.getInstance(j) ;
        }
        System.out.print("\n crear y mostrar jugadores \n");
        System.out.println(unico.getJugadorActual());
        
        System.out.print("\n cartas sorpresa \n");
        System.out.println(unico.getMazo());
        
        System.out.print("\n tablero \n");
        System.out.println(unico.getTablero());
        System.out.println(unico);
    }
    
}
*/