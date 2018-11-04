# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "titulo_propiedad"
require_relative "sorpresa"
require_relative "qytetet"
require_relative "especulador"
require_relative "jugador"

module ModeloQytetet
  class ExamenP3Cabrera
    @@contadorRun = 0
    
    def self.contador
      @@contadorRun
    end

    def self.runCabrera
      @@contadorRun = @@contadorRun + 1
      
      @jugador1 = Jugador.new("jugador1")
      @jugador2 = Jugador.new("jugador2")
      puts @jugador1.to_s
      puts @jugador2.nombre
      
      @especulador = Especulador.new(@jugador1.nombre,10)
      
      puts @especulador
      
      otraCasillaNueva = OtraCasilla.new(20, TipoCasilla::PARKING)
      
      puts otraCasillaNueva.soyEdificable
      
      puts " CASILLA "
      
      puts otraCasillaNueva.to_s
      
    end
    def metodo1
      
    end
    def metodo2
      
    end
  end
  ExamenP3Cabrera.runCabrera
  puts "contador ", ExamenP3Cabrera.contador
end
