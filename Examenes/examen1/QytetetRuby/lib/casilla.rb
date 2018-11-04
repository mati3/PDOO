 #encoding: utf-8
 # To change this license header, choose License Headers in Project Properties.
 # To change this template file, choose Tools | Templates
 # and open the template in the editor.
 
 require_relative "tipo_casilla"
 require_relative "titulo_propiedad"

module ModeloQytetet
  class Casilla
    
    attr_accessor :numeroCasilla, :coste, :numHoteles, :numCasas, :tipo, :titulo
       
    def initialize(numCasilla,cos,numH,numCasa, tip, titul)  # dos constructores
      @numeroCasilla = numCasilla  # int
      @coste = cos  # int, coste de compra del titulo de propiedad de la casilla
      @numHoteles = numH  # int
      @numCasas = numCasa  # int
      @tipo = tip  # TipoCasilla
      @titulo = titul  # TituloPropiedad
      if @titulo != nil 
        @titulo.casilla = self 
      end
      
    end
    
    def self.crear_casillas_calle(numCasilla,cos, titul)
      new(numCasilla,cos, 0, 0, TipoCasilla::CALLE, titul)
    end
    
    def self.crear_casillas_especiales(numCasilla, tip)
      new(numCasilla,0, 0, 0, tip, nil)
    end
    
    def asignarPropietario(jugador) #TituloPropiedad asignarPropietario( Jugador jugador)
      raise ArgumentError,'metodo sin implementar'
    end
    
    def calcularValorHipoteca #int calcularValorHipoteca()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def cancelarHipoteca #int cancelarHipoteca()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def cobrarAlquiler #int cobrarAlquiler()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def edificarCasa #int edificarCasa()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def edificarHotel #int edificarHotel()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def estaHipotecada #boolean estaHipotecada()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def getPrecioEdificar #int getPrecioEdificar()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def hipotecar #int hipotecar()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def precioTotalComprar #int precioTotalComprar()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def propietarioEncarcelado #boolean propietarioEncarcelado()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def sePuedeEdificarCasa #boolean sePuedeEdificarCasa()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def sePuedeEdificarHotel #boolean sePuedeEdificarHotel()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def soyEdificable #boolean soyEdificable()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def tengoPropietario #boolean tengoPropietario()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def venderTitulo #int venderTitulo()
      raise ArgumentError,'metodo sin implementar'
    end
    
    private
    
    def asignarTituloPropiedad #private void asignarTituloPropiedad()
      raise ArgumentError,'metodo sin implementar'
    end
    
    public
    
    def to_s
      "numeroCasilla: #{@numeroCasilla} \n 
      coste: #{@coste} \n 
      numHoteles: #{@numHoteles} \n
      numCasas: #{@numCasas} \n 
      tipo: #{@tipo} \n "
      if(@titulo != nil)
        "titulo: #{@titulo} "
      else
        "titulo: no tiene titulo"
      end
    end
    
    private:titulo= ###########################################################################3
    
    
  end
end
