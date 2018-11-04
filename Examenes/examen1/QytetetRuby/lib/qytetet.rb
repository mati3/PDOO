#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "casilla"
require_relative "sorpresa"
require_relative "dado"
require_relative "jugador"
require_relative "tablero"

require 'singleton'

module ModeloQytetet

  class Qytetet
    
    include Singleton
    
    attr_accessor :jugadorActual, :cartaActual, :jugadores, :tablero, :mazo
    
    @@MAXJUGADORES = 4 # int
    @@MAXCARTAS = 10
    @@MAXCASILLAS = 20
    @@LIBERTAD = 200
    @@SALDOSALIDA = 1000
    
    def initialize
      @jugadores = Array.new #private ArrayList<Jugador>
      nombres = Array.new
      nombres << "juan"
      nombres << "pepe"
      nombres << "luis"
      inicializarJugadores(nombres) #private ArrayList<Jugador>
      @jugadorActual = @jugadores[0] #private Jugador jugadorActual;
      inicializarTablero
      inicializarCartasSorpresa # ArrayList<Sorpresa>
      @cartaActual = @mazo[0] # private Sorpresa cartaActual; // 0 .. 1
      @dado = Dado.instance #private Dado dado = Dado.getInstance();
    end  
    
    def aplicarSorpresa#public boolean aplicarSorpresa()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def cancelarHipoteca(casilla)#public boolean cancelarHipoteca(Casilla casilla)
      raise ArgumentError,'metodo sin implementar'
    end
      
    def comprarTituloPropiedad#public boolean comprarTituloPropiedad()
      raise ArgumentError,'metodo sin implementar'
    end
      
    def edificarCasa(casilla)#public boolean edificarCasa(Casilla casilla)
      raise ArgumentError,'metodo sin implementar'
    end
    
    def edificarHotel(casilla)#public boolean edificarHotel(Casilla casilla)
      raise ArgumentError,'metodo sin implementar'
    end
    
    def hipotecarPropiedad(casilla)#public boolean hipotecarPropiedad(Casilla casilla)
      raise ArgumentError,'metodo sin implementar'
    end
      
    def inicializarJuego(nombres)#public void inicializarJuego( ArrayList<String> nombres)
      raise ArgumentError,'metodo sin implementar'
    end
      
    def intentarSalirCarcel(metodo)#public boolean intentarSalirCarcel( MetodoSalirCarcel metodo)
      raise ArgumentError,'metodo sin implementar'
    end
    
    def jugar #public boolean jugar()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def obtenerRanking #public ArrayList<Jugador> obtenerRanking
      raise ArgumentError,'metodo sin implementar'
    end
    
    def propiedadesHipotecadasJugador(hipotecadas)#public ArrayList<Casilla> propiedadesHipotecadasJugador(boolean hipotecadas)
      raise ArgumentError,'metodo sin implementar'
    end
      
    def siguienteJugador #public Jugador siguienteJugador()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def venderPropiedad(casilla)#public boolean venderPropiedad(Casilla casilla)
      raise ArgumentError,'metodo sin implementar'
    end
    
    private
    
    def encarcelarJugador#private void encarcelarJugador()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def inicializarCartasSorpresa#private void inicializarCartasSorpresa() 
      @mazo = Array.new
      
      @mazo << Sorpresa.new("Tu intuición te dice que mires debajo de esa piedra... ¡Que suerte, 50€!", 50, TipoSorpresa::PAGARCOBRAR)
      @mazo << Sorpresa.new("Tu intuición te dice que mires debajo de esa piedra... Te encuentras a un escarabajo con un cuchillo y te roba 50€",50,TipoSorpresa::PAGARCOBRAR)
      
      @mazo << Sorpresa.new("Te han declarado cómplice de Bárcenas, ¡debes ir a la carcel!", 9, TipoSorpresa::IRACASILLA) ######################## CARCEL #######################
      @mazo << Sorpresa.new("El espacio-tiempo esta hecho un caos, has retrocedido hasta la posición inicial de la partida !y sin cobrar nada¡", 0, TipoSorpresa::IRACASILLA)
      @mazo << Sorpresa.new("!Has encontrado un camino subterráneo secreto¡ Avanza hasta la casilla 8.", 8, TipoSorpresa::IRACASILLA)
      
      @mazo << Sorpresa.new("!Todo lo bueno tiene su lado malo¡ tienes que pagar 50€ por cada casa y hotel que tengas para pagar reparaciones.", 50, TipoSorpresa::PORCASAHOTEL)
      @mazo << Sorpresa.new("!Ratas, Ratas por todas partessss¡ Paga 100€ por cada casa y hotel que poseas.", 100, TipoSorpresa::PORCASAHOTEL)
      
      @mazo << Sorpresa.new("¡eres el elegido y por ello cada jugador te da 25€!", 3, TipoSorpresa::PORJUGADOR)
      @mazo << Sorpresa.new("Todo el mundo te mira mal, ¡y con razón! debes pagar 15€ a cada jugador sino quieres que te maten en el siguiente turno ",3,TipoSorpresa::PORJUGADOR)
      
      @mazo << Sorpresa.new("!Es tu dia de suerte, por un error te han declarado inocente y sales de la carcel!",0, TipoSorpresa::SALIRCARCEL)
      
      @mazo.shuffle
      
    end
    
    def inicializarJugadores(nombres)#private void inicializarJugadores(ArrayList<String> nombres ) {if(nombres.size() < MAXJUGADORES && nombres.size() > 2 )
      if (nombres.size() > 2)
        nombres.each do |s|
          if (nombres.size()< @@MAXJUGADORES)
            @jugadores << s
          end
        end
      else
        raise ArgumentError,'numero de jugadores incorrecto'
      end
    end
    
    def inicializarTablero #private void inicializarTablero()
      @tablero = Tablero.new
    end
    
    def salidaJugadores #void salidaJugadores() 
      raise ArgumentError,'metodo sin implementar'
    end
    
    public
    
    def to_s
      "Qytetet:\n
      Jugadores: #{@jugadores}\n
      JugadorActual: #{@jugadorActual}\n
      Tablero: #{@tablero}\n
      Sorpresas: #{@mazo}\n
      CartaActual: #{@cartaActual}\n
      Dado: #{@dado}"
    end
    
  end

end
