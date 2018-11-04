#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
=begin
require_relative "sorpresa"
require_relative "tipo_sorpresa"
require_relative "casilla"
require_relative "tablero"
require_relative "qytetet"
require_relative "constructora"

module ModeloQytetet
  class PruebaQytetet
    
    include Obras

    @@mazo = Array.new

    def self.inicializar_sorpresas
      @@mazo << Sorpresa.new("Tu intuiciÃ³n te dice que mires debajo de esa piedra... Â¡Que suerte, 50â‚¬!", 50, TipoSorpresa::PAGARCOBRAR)
      @@mazo << Sorpresa.new("Tu intuiciÃ³n te dice que mires debajo de esa piedra... Te encuentras a un escarabajo con un cuchillo y te roba 50â‚¬",50,TipoSorpresa::PAGARCOBRAR)
      
      @@mazo << Sorpresa.new("Te han declarado cÃ³mplice de BÃ¡rcenas, Â¡debes ir a la carcel!", 9, TipoSorpresa::IRACASILLA) ######################## CARCEL #######################
      @@mazo << Sorpresa.new("El espacio-tiempo esta hecho un caos, has retrocedido hasta la posiciÃ³n inicial de la partida !y sin cobrar nadaÂ¡", 0, TipoSorpresa::IRACASILLA)
      @@mazo << Sorpresa.new("!Has encontrado un camino subterrÃ¡neo secretoÂ¡ Avanza hasta la casilla 8.", 8, TipoSorpresa::IRACASILLA)
      
      @@mazo << Sorpresa.new("!Todo lo bueno tiene su lado maloÂ¡ tienes que pagar 50â‚¬ por cada casa y hotel que tengas para pagar reparaciones.", 50, TipoSorpresa::PORCASAHOTEL)
      @@mazo << Sorpresa.new("!Ratas, Ratas por todas partessssÂ¡ Paga 100â‚¬ por cada casa y hotel que poseas.", 100, TipoSorpresa::PORCASAHOTEL)
      
      @@mazo << Sorpresa.new("Â¡eres el elegido y por ello cada jugador te da 25â‚¬!", 3, TipoSorpresa::PORJUGADOR)
      @@mazo << Sorpresa.new("Todo el mundo te mira mal, Â¡y con razÃ³n! debes pagar 15â‚¬ a cada jugador sino quieres que te maten en el siguiente turno ",3,TipoSorpresa::PORJUGADOR)
      
      @@mazo << Sorpresa.new("!Es tu dia de suerte, por un error te han declarado inocente y sales de la carcel!",0, TipoSorpresa::SALIRCARCEL)
    end

    def self.metodo1 #Sorpresas que tienen un valor mayor que 0.
      metodo = []
      @@mazo.each do |local|
        if (local.valor > 0)
          metodo << local
        end
      end
      metodo
    end

    def self.metodo2 #Sorpresas de TipoSorpresa IRACASILLA.
      metodo = []
      sorpresa= Sorpresa.new("", 0, TipoSorpresa::IRACASILLA)
      @@mazo.each do |local|
        if (local.tipo == sorpresa.tipo)
          metodo << local
        end
      end
      metodo
    end

    def self.metodo3(argumento) #Sorpresas del TipoSorpresa especificado en el argumento del mÃ©todo.
      metodo = []
      @@mazo.each do |local|
        tipo = local.tipo
        if (argumento == tipo)# sin .to_s no entra en el if*****************
          metodo << local
        end
      end
      metodo
    end
    
    def self.main
      inicializar_sorpresas
      puts "        mazo completo"
      puts @@mazo,to_s
      
      puts "           metodo1"
      prueba = metodo1
      prueba.each do |man|
       puts man.to_s
      end
      
      puts "     metodo 2 "
      puts metodo2,to_s
      
      puts "     metodo 3 "
      puts metodo3(TipoSorpresa::IRACASILLA)
      
      puts "\n Pruebo las cosas de la practica 2 \n" 
        
      puts "\n Ãºnica instancia de la clase Qytetet \n"
       q = Qytetet.instance
       
              
      puts "\n crear y mostrar jugadores \n"
      puts q.jugadorActual
      
      puts "\n tablero \n"
      puts q.tablero
      
      puts "primera casilla"
      puts q.tablero.casillas[0]
      
      puts "\n cartas sorpresa \n"
      puts q.mazo
      
      puts "AQUI MOSTRAMOS TODO \n"
      
      puts q
      
    end
    
    #EXAMEN-inicio
    def self.examen
      q = Qytetet.instance
      tabla = Tablero.new
      construir = Constructora.new(q.tablero,"direccion","nombre")
      construir.edificar
      puts construir
    end

  end
  
  PruebaQytetet.examen #######################
  
end 

#EXAMEN-fin
=end