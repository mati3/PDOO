# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module ModeloQytetet
  class Calle < Casilla
        attr_accessor :numHoteles, :numCasas, :titulo, :coste
       
    def initialize(numCasilla,cos, titul)  
      super(numCasilla, TipoCasilla::CALLE)
      @coste = cos
      @numHoteles = 0 # int
      @numCasas = 0  # int
      @titulo = titul  # TituloPropiedad
      if @titulo != nil 
        @titulo.setCasilla(self) 
      end
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
    
    def sePuedeEdificarCasa(factor) #boolean sePuedeEdificarCasa()
      return (@numCasas < 4 * factor)
    end
    
    def sePuedeEdificarHotel(factor) #boolean sePuedeEdificarHotel()
      return (@numHoteles < 4 * factor)
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
      cadena = super.to_s
      cadena +=" CALLE:  
      numHoteles: #{@numHoteles} 
      numCasas: #{@numCasas}  \n "
      if(@titulo != nil)
        cadena +=" tituloDeCasilla: #{@titulo.to_s} "
      else
        cadena +=" tituloDeCasilla: no tiene titulo"
      end
      cadena += " \nFin de casilla\n"
      return cadena
    end  
  end
end
