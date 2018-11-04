/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author mati331
 */
public class ExamenP4 {
    
    public Jugador jugador;
    public Tramposo tramposo;
    
    public ExamenP4(){
        jugador=new Jugador("jugador1");
        tramposo = new Tramposo(this.jugador);
    }
    
    public void run(){
        System.out.print("MUESTRO JUGADOR UNO \n");
        System.out.print(jugador.toString()+ "\n");
        System.out.print("\n MUESTRO TRAMPOSO UNO \n");
        System.out.print(tramposo.toString()+ "\n");
        
        for(int i=0 ; i< 8 ; i++){
          jugador.modificarSaldo(-500);
            tramposo.modificarSaldo(-500);
        }
        System.out.print("MUESTRO JUGADOR DOS \n");
        System.out.print(jugador.toString()+ "\n");
        System.out.print("\n MUESTRO TRAMPOSO DOS \n");
        System.out.print(tramposo.toString()+ "\n");
        
        tramposo.perdonar();
        System.out.print("\n MUESTRO TRAMPOSO TRES \n");
        System.out.print(tramposo.toString()+ "\n");
    }
    public static void main(String[] args) {
        ExamenP4 prueba = new ExamenP4();
        prueba.run();
    }
}
