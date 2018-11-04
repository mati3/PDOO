# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module ModeloQytetet
  
  class Tramposo < Jugador
    
    def initialize(jugador)
      super(jugador)
      @trampas = 0
      @importe = 0
    end
    
    def getImporte
      @importe
    end
    
    def setImporte(cantidad)
      @importe = @importe + cantidad
    end
    
    def getTrampa
      @trampas
    end
    
    def setTrampa
      @trampas = @trampas + 1
    end
    
    def modificarSaldo(cantidad) #void modificarSaldo(int cantidad )
      aux = rand(2)
      if(aux == 0)
        cantidad = cantidad/2
      end
      self.modificarSaldo(cantidad)
    end
    
    def perdonar
      @trampas = 0
      @importe = 0
    end
    
    def to_s
      cadena = " COMIENZO DEL TO_S DEL JUGADOR TRAMPOSO"
      cadena += super.to_s
      cadena +=" @trampas: #{@trampas} "
      cadena +=" @importe: #{@importe} "
      cadena += " \nFin de jugador TRAMPOSO \n"
      return cadena
    end
    
  end
  
end
