#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "casilla"
require_relative "jugador"

module ModeloQytetet
  class TituloPropiedad
    attr_accessor :nombre, :alquilerBase, :factorRevalorizacion, :hipotecaBase , :precioEdificar, :hipotecada
    
    def initialize(n,h,ab, fb,hb,pe)    
      @nombre = n # string
      @hipotecada = h # booleano dice si esta hipotecada o no
      @alquilerBase = ab # int
      @factorRevalorizacion = fb # float
      @hipotecaBase = hb # int
      @precioEdificar = pe # int
      @casilla=nil # Casilla
      @propietario=nil # jugador
    end
    
    def setCasilla(casi)
      @casilla = casi
    end
    
    def getCasilla
     return @casilla
    end
    
     def setPropietario(jugador)
       @propietario = jugador
     end
     
     def getPropietario
      return @propietario
     end
    
    def cobrarAlquiler(coste)#(coste : int) : void
      @propietario.modificarSaldo(coste)
    end
    
    def propietaroEncarcelado #() : boolean
      @propietario.encarcelado
    end
    
    #Devuelve true si propietario no es nulo.
    def tengoPropietario#() : boolean 
      return (@propietario != nil)
    end
    
    def to_s
      "Nombre: #{@nombre} \t 
      Hipotecada: #{@hipotecada} \t 
      AlquilerBase: #{@alquilerBase}
      FactorRevalorizacion: #{@factorRevalorizacion} \t
      HipotecaBase: #{@hipotecaBase} \t 
      PrecioEdificar: #{@precioEdificar}"
    end
    
  end
end
