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

//EXAMEN INI
public class Tramposo extends Jugador {
    
    public int trampas;
    public int importe;

    public Tramposo(Jugador jugador) {
        super(jugador);
        trampas = 0;
        importe = 0;
    }

    public int getTrampas() {
        return trampas;
    }

    public int getImporte() {
        return importe;
    }

    public void setTrampas(int trampas) {
        this.trampas = trampas;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }
    
    void modificarSaldo(int cantidad ){
        
        int aux = (int) (Math.random()*2);
        if(aux == 0){
            cantidad=cantidad/2;
        }
        super.modificarSaldo(cantidad);
        
    }
    void perdonar(){
        this.importe = 0 ;
        this.trampas = 0 ;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Tramposo{" + " trampas= " + trampas + " importe= " + importe + '}';
    }
    
}
//EXAMEN FIN