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
public class Tablero {
    private ArrayList<Casilla> casillas; //MAX_CASILLAS, ordenado por numeroCasilla
    private Casilla carcel;

    public Tablero() {
        inicializar();
    }
    
    //Devuelve true si numeroCasilla se corresponde con el número de casilla de la cárcel y false en caso contrario.
    boolean esCasillaCarcel(int numeroCasilla){
        boolean aux = false ;
        if(this.carcel.getNumeroCasilla() == numeroCasilla){
            aux = true ;
        }
        return aux;
    }
    

    public Casilla getCarcel() {
        return carcel;
    }
    
    
    Casilla obtenerCasillaNumero(int numeroCasilla)throws NumberFormatException{
        if(this.casillas.size() > numeroCasilla){ // < *******************************************
            return this.casillas.get(numeroCasilla);
        }else{
            throw new NumberFormatException("no hay casillas en la posicion numeroCasilla, obtenerCasillaNumero ");
        }
    }
    
    Casilla obtenerNuevaCasilla(Casilla casilla, int desplazamiento){
       System.out.println(casillas.size()+ " muestro tamaño de casillas");
       int numeroCasilla = (casilla.getNumeroCasilla() + desplazamiento );
        if(casillas.size() <= numeroCasilla){ //<=
            System.out.println("\n hola************ "+casillas.get(numeroCasilla % 20)+ " muestro cuando me he pasado " + numeroCasilla+" "+numeroCasilla % 20 + " casilla por ciento");
        return casillas.get(numeroCasilla %20);
      }else{
            System.out.println(casillas.get(numeroCasilla)+ " muestro nueva casilla*********************   "+ numeroCasilla);
        return casillas.get(numeroCasilla);
      }
    }
    

    @Override
    public String toString() {
        return "Tablero{\n" + "casillas=" + casillas + "\n, carcel=" + carcel +"\n"+ '}';
    }
    
    private void inicializar(){
        this.casillas = new ArrayList();
        
        Casilla calle = new OtraCasilla(0,0,TipoCasilla.SALIDA);
        casillas.add(calle);
        
        TituloPropiedad tp = new TituloPropiedad("Tomate",false,50,10,150,250);
        calle= new Calle(1,250,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Estrella",false,50,12,250,250);
        calle = new Calle(2,250,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        calle = new OtraCasilla(3,0,TipoCasilla.SORPRESA);
        casillas.add(calle);
        
        carcel = new OtraCasilla(4,0,TipoCasilla.CARCEL); ///////////////////////CARCEL////////
        casillas.add(carcel);
        
        tp = new TituloPropiedad("Pimiento",false,50,16,350,350);
        calle = new Calle(5,350,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Melon",false,50,20,450,350);
        calle = new Calle(6,350,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Sandia",false,50,18,550,450);
        calle = new Calle(7,450,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        calle = new OtraCasilla(8,0,TipoCasilla.IMPUESTO);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Melocoton",false,50,14,650,450);
        calle = new Calle(9,450,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        calle = new OtraCasilla(10,0,TipoCasilla.SORPRESA);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Patata",false,100,18,750,500);
        calle = new Calle(11,500,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        calle = new OtraCasilla(12,0,TipoCasilla.JUEZ);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Ciruela",false,100,10,800,500);
        calle = new Calle(13,500,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Almibar",false,100,12,850,600);
        calle = new Calle(14,600,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        calle = new OtraCasilla(15,0,TipoCasilla.SORPRESA);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Botón",false,100,18,900,650);
        calle = new Calle(16,450,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Silla",false,100,14,950,700);
        calle = new Calle(17,450,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        calle = new OtraCasilla(18,0,TipoCasilla.PARKING);
        casillas.add(calle);
        
        tp = new TituloPropiedad("Aprobado",false,100,20,1000,750);
        calle = new Calle(19,450,0,0,TipoCasilla.CALLE,tp);
        casillas.add(calle);
        
        
        /*  public TituloPropiedad(String nombre, boolean hipotecada, int alquilerBase, float factorRevalorizcion, int hipotecaBase, int precioEdificar)
            public Casilla(int numeroCasilla, int coste, int numHoteles, int numCasas, TipoCasilla tipo, TituloPropiedad titulo) 
            public Casilla(int numeroCasilla, int coste, TipoCasilla tipo) {

        */
    }
    
}

