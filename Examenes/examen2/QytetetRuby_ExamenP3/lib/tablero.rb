# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "tipo_casilla"
require_relative "casilla"
require_relative "titulo_propiedad"

module ModeloQytetet
  class Tablero
    attr_accessor :carcel, :casillas
    
    #@carcel # casilla
    
    def initialize
      inicializar
    end
    
    def to_s
      cadena = "\nTablero: \n"
      @casillas.each do |c|  
        cadena +=" Casilla de Tablero: #{c.to_s}\n"
      end
      cadena +=" carcel: #{@carcel.to_s} \n "
    end
    
    #Devuelve true si numeroCasilla se corresponde con el número de casilla de la cárcel y false en caso contrario.
    def esCasillaCarcel(numeroCasilla)#boolean esCasillaCarcel(int numeroCasilla)
      aux = false
      if(@carcel.numeroCasilla == numeroCasilla)
        aux true
      end
      return aux
    end
    
    def obtenerCasillaNumero(numeroCasilla)#Casilla obtenerCasillaNumero(int numeroCasilla)
      if(@casillas.size() > numeroCasilla)
        return @casillas[numeroCasilla]
      else
        raise ArgumentError,'no hay casillas en la posicion numeroCasilla'
      end  
    end
    
    def obtenerNuevaCasilla(casilla, desplazamiento)#Casilla obtenerNuevaCasilla(Casilla casilla, int desplazamiento)
      numeroCasilla = (casilla.numeroCasilla + desplazamiento)
      if(@casillas.size() <= numeroCasilla)
        @casillas[numeroCasilla%20]
        return @casillas[numeroCasilla%20]
      else
        return @casillas[numeroCasilla]
      end  
    end
    
    private
    
    def inicializar 
      @casillas = Array.new
      
      calle = Casilla.crear_casillas_especiales(0,TipoCasilla::SALIDA)
      @casillas << calle
      
      tomate = TituloPropiedad.new("Tomate",false,50,10,150,250)
      calle = Casilla.crear_casillas_calle(1,250,tomate)
      @casillas << calle
      
      estrella = TituloPropiedad.new("Estrella",false,50,12,250,250)
      calle = Casilla.crear_casillas_calle(2,250,estrella)
      @casillas << calle
      
      calle = Casilla.crear_casillas_especiales(3,TipoCasilla::SORPRESA)
      @casillas << calle
      
      @carcel = Casilla.crear_casillas_especiales(4,TipoCasilla::CARCEL) ############### CARCEL #################
      @casillas << @carcel
      
      pimiento = TituloPropiedad.new("Pimiento",false,50,16,350,350)
      calle = Casilla.crear_casillas_calle(5,350,pimiento)
      @casillas << calle
      
      melon = TituloPropiedad.new("Melon",false,50,20,450,350)
      calle = Casilla.crear_casillas_calle(6,350,melon)
      @casillas << calle
      
      sandia = TituloPropiedad.new("Sandia",false,50,18,550,450)
      calle = Casilla.crear_casillas_calle(7,450,sandia)
      @casillas << calle
      
      calle = Casilla.crear_casillas_especiales(8,TipoCasilla::IMPUESTO)
      @casillas << calle
      
      melocoton = TituloPropiedad.new("Melocoton",false,50,14,650,450)
      calle = Casilla.crear_casillas_calle(9,450,melocoton)
      @casillas << calle
      
      calle = Casilla.crear_casillas_especiales(10,TipoCasilla::SORPRESA)
      @casillas << calle
      
      patata = TituloPropiedad.new("Patata",false,100,18,750,500)
      calle = Casilla.crear_casillas_calle(11,500,patata)
      @casillas << calle
      
      calle = Casilla.crear_casillas_especiales(12,TipoCasilla::JUEZ)
      @casillas << calle
      
      ciruela = TituloPropiedad.new("Ciruela",false,100,10,800,500)
      calle = Casilla.crear_casillas_calle(13,500,ciruela)
      @casillas << calle
      
      almibar = TituloPropiedad.new("Almibar",false,100,12,850,600)
      calle = Casilla.crear_casillas_calle(14,600,almibar)
      @casillas << calle
      
      calle = Casilla.crear_casillas_especiales(15,TipoCasilla::SORPRESA)
      @casillas << calle
      
      boton = TituloPropiedad.new("Boton",false,100,18,900,650)
      calle = Casilla.crear_casillas_calle(16,450,boton)
      @casillas << calle
      
      silla = TituloPropiedad.new("Silla",false,100,14,950,700)
      calle = Casilla.crear_casillas_calle(17,450,silla)
      @casillas << calle
      
      calle = Casilla.crear_casillas_especiales(18,TipoCasilla::PARKING)
      @casillas << calle
      
      aprobado = TituloPropiedad.new("Aprobado",false,100,20,1000,750)
      calle = Casilla.crear_casillas_calle(19,450,aprobado)
      @casillas << calle
    end  
  end
end 