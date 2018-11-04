/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

import java.util.ArrayList;

/**
 *
 * @author chipi
 */
public class Tablero {
    private ArrayList<Casilla> casillas; //MAX_CASILLAS, ordenado por numeroCasilla
    private Casilla carcel;

    public Tablero() {
        inicializar();
    }
    /*
    boolean esCasillaCarcel(int numeroCasilla){
        return true
    }
    */

    public Casilla getCarcel() {
        return carcel;
    }
    
    /*
    Casilla obtenerCasillaNumero(int numeroCasilla){
        return null;
    }
    
    Casilla obtenerNuevaCasilla(Casilla casilla, int desplazamiento){
        return null;
    }
    */

    @Override
    public String toString() {
        return "Tablero{" + "casillas=" + casillas + ", carcel=" + carcel + '}';
    }
    
    private void inicializar(){
        this.casillas = new ArrayList();
        
        Casilla calle = new Casilla(0,0,TipoCasilla.SALIDA);
        casillas.add(calle);
        
        TituloPropiedad tp = new TituloPropiedad("Tomate",false,50,10,150,250);
        calle= new Casilla(1,250,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Estrella",false,50,12,250,250);
        calle = new Casilla(2,250,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        calle = new Casilla(3,0,TipoCasilla.SORPRESA);
        casillas.add(calle);
        
        carcel = new Casilla(4,0,TipoCasilla.CARCEL); ///////////////////////CARCEL////////
        casillas.add(carcel);
        
        tp = new TituloPropiedad("Pimiento",false,50,16,350,350);
        calle = new Casilla(5,350,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Melon",false,50,20,450,350);
        calle = new Casilla(6,350,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Sandia",false,50,18,550,450);
        calle = new Casilla(7,450,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        calle = new Casilla(8,0,TipoCasilla.IMPUESTO);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Melocoton",false,50,14,650,450);
        calle = new Casilla(9,450,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        calle = new Casilla(10,0,TipoCasilla.SORPRESA);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Patata",false,100,18,750,500);
        calle = new Casilla(11,500,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        calle = new Casilla(12,0,TipoCasilla.JUEZ);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Ciruela",false,100,10,800,500);
        calle = new Casilla(13,500,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Almibar",false,100,12,850,600);
        calle = new Casilla(14,600,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        calle = new Casilla(15,0,TipoCasilla.SORPRESA);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Botón",false,100,18,900,650);
        calle = new Casilla(16,450,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Silla",false,100,14,950,700);
        calle = new Casilla(17,450,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        calle = new Casilla(18,0,TipoCasilla.PARKING);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Aprobado",false,100,20,1000,750);
        calle = new Casilla(19,450,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        
        /*  public TituloPropiedad(String nombre, boolean hipotecada, int alquilerBase, float factorRevalorizcion, int hipotecaBase, int precioEdificar)
            public Casilla(int numeroCasilla, int coste, int numHoteles, int numCasas, TipoCasilla tipo, TituloPropiedad titulo) 
            public Casilla(int numeroCasilla, int coste, TipoCasilla tipo) {

        */
    }
    
}

