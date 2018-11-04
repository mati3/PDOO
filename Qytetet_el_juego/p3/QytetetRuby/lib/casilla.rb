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
        @titulo.setCasilla(self) 
      end
      
    end
    
    def self.crear_casillas_calle(numCasilla,cos, titul)
      new(numCasilla,cos, 0, 0, TipoCasilla::CALLE, titul)
    end
    
    def self.crear_casillas_especiales(numCasilla, tip)
      new(numCasilla,0, 0, 0, tip, nil)
    end
    
    def asignarPropietario(jugador) #TituloPropiedad asignarPropietario( Jugador jugador)
      @titulo.setPropietario(jugador)
    end
    
    def calcularValorHipoteca #int calcularValorHipoteca()
      return (@titulo.hipotecaBase + 2 * (@numCasas * 5/10 * @titulo.hipotecaBase + @numHoteles + @titulo.hipotecaBase ))
    end
    
    def cancelarHipoteca #int cancelarHipoteca() #***************************************************************  @titulo.hipotecada = false
      return (calcularValorHipoteca()*10/100) + calcularValorHipoteca();
    end
    
    def cobrarAlquiler #int cobrarAlquiler()
      costeAlquilerBase = @titulo.alquilerBase
      coste = (costeAlquilerBase + (2 *((@numCasas * 5/10) + (@numHoteles * 2))))
      @titulo.cobrarAlquiler(coste)
      return coste
    end
    
    def edificarCasa #int edificarCasa()
      @numCasas += 1
      return @titulo.precioEdificar
    end
    
    def edificarHotel #int edificarHotel()
      @numHoteles += 1
      return @titulo.precioEdificar
    end
    
    def estaHipotecada #boolean estaHipotecada()
      return @titulo.hipotecada
    end
    
    def getPrecioEdificar #int getPrecioEdificar()
      @titulo.precioEdificar
    end
    
    def hipotecar #int hipotecar()
      @titulo.hipotecada=true ##############################
      cantidadRecibida = calcularValorHipoteca
      return cantidadRecibida
    end
    
    def precioTotalComprar #int precioTotalComprar()
      @titulo.alquilerBase
    end
    
    def propietarioEncarcelado #boolean propietarioEncarcelado()
      @titulo.propietaroEncarcelado
    end
    
    def sePuedeEdificarCasa #boolean sePuedeEdificarCasa()
      return (@numCasas < 4)
    end
    
    def sePuedeEdificarHotel #boolean sePuedeEdificarHotel()
      return (@numHoteles < 4)
    end
    
    def soyEdificable #boolean soyEdificable()
      return (@tipo == TipoCasilla::CALLE)
    end
    
    def tengoPropietario #boolean tengoPropietario() 
      @titulo.tengoPropietario
    end
    
    def venderTitulo #int venderTitulo()
      precio = precioTotalComprar
      precio += @numHoteles * getPrecioEdificar
      precio += @numCasas * getPrecioEdificar
      precio *= @titulo.factorRevalorizacion
      asignarPropietario(nil)
      @numHoteles = 0
      @numCasas = 0
      return precio
    end
    
    private
    
    def asignarTituloPropiedad #private void asignarTituloPropiedad()
      raise ArgumentError,'metodo sin implementar'
    end
    
    public
    
    def to_s
      cadena ="numeroCasilla: #{@numeroCasilla} \n 
      coste: #{@coste} \n 
      numHoteles: #{@numHoteles} \n
      numCasas: #{@numCasas} \n 
      tipo: #{@tipo} \n "
      if(@titulo != nil)
        cadena +="titulo: #{@titulo.to_s} "
      else
        cadena +="titulo: no tiene titulo"
      end
      return cadena
    end 
    
  end
end
