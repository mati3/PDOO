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
public class Especulador extends Jugador{
    
    static int FactorEspeculador = 2;
    int fianza ;
    
    protected Especulador(Jugador jugador, int f){
        super(jugador);
        this.fianza = f ;
    }
    public static int getFactorEspeculador() {
        return Especulador.FactorEspeculador;
    }
    
    
    @Override // redefinimos metodo
    protected void pagarImpuestos(int cantidad){
        this.modificarSaldo(-(cantidad/2));
    }
    
    @Override
    protected void irACarcel(Casilla casilla){
        boolean pagar= this.pagarFianza(fianza);
        if(!pagar){
            super.irACarcel(casilla);
        }
    }
    
    @Override
    protected Especulador convertirme(int fianza){
        this.fianza = fianza ;
        return this;
    }
    
    private boolean pagarFianza(int cantidad){
        boolean aux = this.tengoSaldo(cantidad);
        if( aux ){
            this.modificarSaldo(cantidad);
        }
        return aux;
    }

    @Override
    public String toString() {
        return super.toString() + "Especulador{" + "fianza=" + fianza + '}';
    }
    
    
}
