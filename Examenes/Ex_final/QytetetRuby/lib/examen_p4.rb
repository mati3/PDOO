# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "titulo_propiedad"
require_relative "sorpresa"
require_relative "qytetet"
require_relative "jugador"
require_relative "tramposo"

module ModeloQytetet
  class ExamenP4
    
    def run
      @jugador1 = Jugador.new("jugador1")
      @tramposo = Tramposo.new(@jugador1)

      puts "MUESTRO JUGADOR UNO"
      puts @jugador1.to_s
      puts "MUESTRO TRMPOSO UNO"
      puts @tramposo.to_s
      
      
      @jugador1.modificarSaldo(-500)
      @tramposo.modificarSaldo(-500)
      @jugador1.modificarSaldo(-500)
      @tramposo.modificarSaldo(-500)
      @jugador1.modificarSaldo(-500)
      @tramposo.modificarSaldo(-500)
      @jugador1.modificarSaldo(-500)
      @tramposo.modificarSaldo(-500)
      @jugador1.modificarSaldo(-500)
      @tramposo.modificarSaldo(-500)
      @jugador1.modificarSaldo(-500)
      @tramposo.modificarSaldo(-500)
      @jugador1.modificarSaldo(-500)
      @tramposo.modificarSaldo(-500)
      @jugador1.modificarSaldo(-500)
      @tramposo.modificarSaldo(-500)
      
      puts "MUESTRO JUGADOR DOS"
      puts @jugador1.to_s
      puts "MUESTRO TRMPOSO DOS"
      puts @tramposo.to_s

      @tramposo.perdonar

      puts "MUESTRO TRMPOSO TRES"
      puts @tramposo.to_s
    end
    
    examen = ExamenP4.new
    examen.run
  end
end
