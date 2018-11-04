# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "jugador.rb"

module ModeloQytetet
  
  
  class Especulador < Jugador
    
    @@FactorEspeculador = 2    
    def initialize(jugador, f)
      super(jugador)
      @fianza = f
    end
    
    #def Especulador(jugador, fianza)
    #  self.new(jugador,fianza)
    #end
    
    def getFactorEspeculador
      return @@FactorEspeculador
    end
    
    def pagarImpuestos(cantidad)
      modificarSaldo(-(cantidad/2))
    end
    
    def convertirme(fianza)
      @fianza = fianza
      return self
    end
    
    def irACarcel(casilla)
      if(pagarFianza(@fianza))
        super.irACarcel(casilla)
      end
    end
    
    def pagarFianza(cantidad)
      aux = tengoSaldo(cantidad)
      if aux
        modificarSaldo(cantidad)
      end
      return aux
    end
    
    #protected :Especulador, :pagarImpuestos, :irACarcel
    private :pagarFianza
    
    def to_s
      cadena = " COMIENZO DEL TO_S DEL JUGADOR ESPECULADOR"
      cadena += super.to_s
      cadena +=" Fianza: #{@fianza} "
      cadena += " \nFin de jugador especulador \n"
      return cadena
    end
  end
end
