#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module ModeloQytetet
  class TituloPropiedad
    attr_accessor :nombre, :alquilerBase, :factorRevalorizacion, :hipotecaBase , :precioEdificar, :hipotecada, :casilla, :propietario
    
    def initialize(n,h,ab, fb,hb,pe)
     
      @nombre = n # string
      @hipotecada = h # booleano dice si esta hipotecada o no
      @alquilerBase = ab # int
      @factorRevalorizacion = fb # float
      @hipotecaBase = hb # int
      @precioEdificar = pe # int
    end
    
    def cobrarAlquiler(coste)#(coste : int) : void
      raise ArgumentError,'metodo sin implementar'
    end
    
    def propietaroEncarcelado #() : boolean
      raise ArgumentError,'metodo sin implementar'
    end
    
    def tengoPropietario#() : boolean
      raise ArgumentError,'metodo sin implementar'
    end
    
    def to_s
      "Nombre: #{@nombre} \n 
      Hipotecada: #{@hipotecada} \n 
      AlquilerBase: #{@alquilerBase}
      FactorRevalorizacion: #{@factorRevalorizacion} \n 
      HipotecaBase: #{@hipotecaBase} \n 
      PrecioEdificar: #{@precioEdificar}"
    end
    
  end
end
