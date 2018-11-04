#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "casilla"
require_relative "sorpresa"
require_relative "dado"
require_relative "jugador"
require_relative "tablero"
require_relative "tipo_casilla"
require_relative "titulo_propiedad"
require_relative "tipo_sorpresa"
require_relative "metodo_salir_carcel"

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
      #nicializarJuego(nombres)
      @dado = Dado.instance #private Dado dado = Dado.getInstance();
    end  
    
    
    def aplicarSorpresa#public boolean aplicarSorpresa()
      tienePropietario = false
      if @cartaActual.tipo == TipoSorpresa::PAGARCOBRAR
        @jugadorActual.modificarSaldo(@cartaActual.valor) 
      else
        if @cartaActual.tipo == TipoSorpresa::IRACASILLA
          esCarcel = @tablero.esCasillaCarcel(@cartaActual.valor)
          if esCarcel
            encarcelarJugador
          else
            nuevaCasilla = @tablero.obtenerCasillaNumero(@cartaActual.valor)
            tienePropietario = @jugadorActual.actualizarPosicion(nuevaCasilla)
          end
        else
          if @cartaActual.tipo == TipoSorpresa::PORCASAHOTEL
            @jugadorActual.pagarCobrarPorCasaYHotel(@cartaActual.valor)         
          else
            if @cartaActual.tipo == TipoSorpresa::PORJUGADOR
              @jugadores.each do |j|  
                if j != @jugadorActual
                  j.modificarSaldo(@cartaActual.valor)
                  @jugadorActual.modificarSaldo(@cartaActual.valor)
                end
              end  
            end
          end
        end
      end
      if @cartaActual.tipo == TipoSorpresa::SALIRCARCEL
        @jugadorActual.cartaLibertad = @cartaActual
      else
        @mazo << @cartaActual     
      end
      return tienePropietario
    end
    
    def cancelarHipoteca(casilla)#public boolean cancelarHipoteca(Casilla casilla)
       puedoCancelarHipotecaPropiedad = false 
        if(casilla.estaHipotecada && @jugadorActual.puedoPagarHipoteca(casilla))
            mispropiedadeshipotecadas = @jugadorActual.obtenerPropiedadesHipotecadas(true);
            mispropiedadeshipotecadas.each do |tp|
                if(tp == casilla.titulo)
                    casilla.cancelarHipoteca
                    tp.hipotecada = false
                    puedoCancelarHipotecaPropiedad = true 
                end
            end
        end
        return puedoCancelarHipotecaPropiedad
    end
      
    def comprarTituloPropiedad#public boolean comprarTituloPropiedad()
      return @jugadorActual.comprarTitulo
    end
      
    def edificarCasa(casilla)#public boolean edificarCasa(Casilla casilla)
      puedoEdificar = false
      if casilla.soyEdificable
        sePuedeEdificar = casilla.sePuedeEdificarCasa
        if sePuedeEdificar
          puedoEdificar = @jugadorActual.puedoEdificarCasa(casilla)
          if puedoEdificar
            costeEdificarCasa = casilla.edificarCasa
            @jugadorActual.modificarSaldo(-costeEdificarCasa)
          end
        end
      end
      return puedoEdificar
    end
    
    def edificarHotel(casilla)#public boolean edificarHotel(Casilla casilla)
      puedoEdificar = false
      if casilla.soyEdificable
        sePuedeEdificar = casilla.sePuedeEdificarHotel
        if sePuedeEdificar
          puedoEdificar = @jugadorActual.puedoEdificarHotel(casilla)
          if puedoEdificar
            costeEdificarCasa = casilla.edificarHotel
            @jugadorActual.modificarSaldo(-costeEdificarCasa)
          end
        end
      end
      return puedoEdificar
    end
    
    def hipotecarPropiedad(casilla)#public boolean hipotecarPropiedad(Casilla casilla)
      sePuedeHipotecar = false
      if casilla.soyEdificable
        sePuedeHipotecar = !casilla.estaHipotecada
        if sePuedeHipotecar
          puedoHipotecar = @jugadorActual.puedoHipotecar(casilla)
          if puedoHipotecar
            cantidadRecibida = casilla.hipotecar
            @jugadorActual.modificarSaldo(cantidadRecibida)
          end
        end
      end
      return sePuedeHipotecar
    end
      
    def inicializarJuego(nombres)#public void inicializarJuego( ArrayList<String> nombres)
      @jugadores = Array.new #private ArrayList<Jugador>
      inicializarJugadores(nombres) #private ArrayList<Jugador>
      inicializarTablero
      inicializarCartasSorpresa # ArrayList<Sorpresa>     
      @cartaActual = nil #sorpresa
      salidaJugadores
    end
      
    def intentarSalirCarcel(metodo)#public boolean intentarSalirCarcel( MetodoSalirCarcel metodo)
      libre = false
      if metodo == MetodoSalirCarcel::TIRANDODADO
        valor = @dado.tirar
        libre = valor > 5
      else
        if metodo == MetodoSalirCarcel::PAGANDOLIBERTAD
          aux = -@@LIBERTAD
          tengoSaldo = @jugadorActual.pagarLibertad(aux)
          libre = tengoSaldo
        end
      end
      if libre
       @jugadorActual.encarcelado = false         
      end
      return libre
    end
    
    def jugar #public boolean jugar()
      valorDado = @dado.tirar
      puts "Me ha salido un: " 
      puts valorDado
      casillaPosicion = @jugadorActual.casillaActual
      nuevaCasilla = @tablero.obtenerNuevaCasilla(casillaPosicion, valorDado)
      tienePropietario = @jugadorActual.actualizarPosicion(nuevaCasilla)
      if !nuevaCasilla.soyEdificable
        if nuevaCasilla.tipo == TipoCasilla::JUEZ
          encarcelarJugador
        else
          if nuevaCasilla.tipo == TipoCasilla::SORPRESA
            @cartaActual = @mazo[0]
            @mazo.delete(@cartaActual) # borro la primera carta del mazo despues de adjudicarla
          end
        end
      end
      return tienePropietario
    end
    
    def obtenerRanking #public 
      ranking = Hash.new
      @jugadores.each do |j|  
        capital = j.obtenerCapital
        ranking[j.nombre] = capital
      end
      return ranking
    end
    
    #Devuelve las casillas propiedad del jugadorActual que estén como hipotecadas # mirar si puedo llamar a obtenerPropiedadesHipotecadas de jugador
    def propiedadesHipotecadasJugador(hipotecadas)#public ArrayList<Casilla> propiedadesHipotecadasJugador(boolean hipotecadas)
      casillas = Array.new
      if(hipotecadas == true)
        @jugadorActual.propiedades.each do |propiedad|  
          if(propiedad.hipotecada == true)
            casillas << propiedad.getCasilla
          end
        end
      else(hipotecadas == false)
        @jugadorActual.propiedades.each do |propiedad|  
          if(propiedad.hipotecada == false)
            casillas << propiedad.getCasilla
          end
        end
      end
      return casillas
    end
      
    #Asigna a jugadorActual al siguiente en la lista de jugadores. Si
#el turno lo tenía el último jugador de la lista, se pasará el turno al primero de la lista.
    def siguienteJugador #public void siguienteJugador()
      entero = @jugadores.size
      if(@jugadorActual == @jugadores[entero-1])
        @jugadorActual = @jugadores[0]
      else
        entero = @jugadores.index(@jugadorActual)
        @jugadorActual = @jugadores[entero+1]
      end
    end
    
    def venderPropiedad(casilla)#public boolean venderPropiedad(Casilla casilla)#***********************************************
      puedoVender = false
      if casilla.soyEdificable
        puedoVender = @jugadorActual.puedoVenderPropiedad(casilla)
        puts "puedovender"
        puts puedoVender
        if puedoVender
          @jugadorActual.venderPropiedad(casilla)
        end
      end
      return puedoVender
    end
    
    private
    
    def encarcelarJugador#private void encarcelarJugador()
      if !@jugadorActual.tengoCartaLibertad
        casillaCarcel = @tablero.carcel
        @jugadorActual.irACarcel(casillaCarcel)
      else
        carta = @jugadorActual.devolverCartaLibertad
        @mazo[@mazo.size] < carta####################################3
      end
    end
    
    def inicializarCartasSorpresa#private void inicializarCartasSorpresa() 
      @mazo = Array.new
      
      @mazo << Sorpresa.new("Tu intuicion te dice que mires debajo de esa piedra... ¡Que suerte, 50€!", 50, TipoSorpresa::PAGARCOBRAR)
      @mazo << Sorpresa.new("Tu intuicion te dice que mires debajo de esa piedra... Te encuentras a un escarabajo con un cuchillo y te roba 50€",-50,TipoSorpresa::PAGARCOBRAR)
      
      @mazo << Sorpresa.new("Te han declarado cómplice de Bárcenas, ¡debes ir a la carcel!", 9, TipoSorpresa::IRACASILLA) ######################## CARCEL #######################
      @mazo << Sorpresa.new("El espacio-tiempo esta hecho un caos, has retrocedido hasta la posición inicial de la partida !y sin cobrar nada¡", 0, TipoSorpresa::IRACASILLA)
      @mazo << Sorpresa.new("!Has encontrado un camino subterráneo secreto¡ Avanza hasta la casilla 8.", 8, TipoSorpresa::IRACASILLA)
      
      @mazo << Sorpresa.new("!Todo lo bueno tiene su lado malo¡ tienes que pagar 50€ por cada casa y hotel que tengas para pagar reparaciones.", -50, TipoSorpresa::PORCASAHOTEL)
      @mazo << Sorpresa.new("!Ratas, Ratas por todas partessss¡ Paga 100€ por cada casa y hotel que poseas.", -100, TipoSorpresa::PORCASAHOTEL)
      
      @mazo << Sorpresa.new("¡eres el elegido y por ello cada jugador te da 25€!", 25, TipoSorpresa::PORJUGADOR)
      @mazo << Sorpresa.new("Todo el mundo te mira mal, ¡y con razon! debes pagar 15€ a cada jugador sino quieres que te maten en el siguiente turno ",-15,TipoSorpresa::PORJUGADOR)
      
      @mazo << Sorpresa.new("!Es tu dia de suerte, por un error te han declarado inocente y sales de la carcel!",0, TipoSorpresa::SALIRCARCEL)
      
      @mazo = @mazo.shuffle
    end
    
    def inicializarJugadores(nombres)#private void inicializarJugadores(ArrayList<String> nombres ) {if(nombres.size() < MAXJUGADORES && nombres.size() > 2 )
      if (nombres.size() >= 2)
        nombres.each do |s|
          if (nombres.size()< @@MAXJUGADORES)
            @jugadores << Jugador.new(s)
          end
        end
      else
        raise ArgumentError,'numero de jugadores incorrecto'
      end
    end
    
    def inicializarTablero #private void inicializarTablero()
      @tablero = Tablero.new
    end
    
    #Posiciona a todos los jugadores en la casilla de salida, con un saldo de 7500 € y asigna de forma aleatoria el jugador actual.
    def salidaJugadores #void salidaJugadores() 
      @jugadores.each do |j|
        if j.saldo != 7500
            j.saldo = 7500
        end
        if(j.casillaActual.tipo != TipoCasilla::SALIDA)
          j.casillaActual = @tablero.casillas[0] # posiciono en el tablero, la casilla 0 es la salida
        end
      end
      @jugadorActual = @jugadores[rand(@jugadores.size)]
    end
   
    
    public
    
    def to_s
      cadena = "\nQytetet:\n" 
      @jugadores.each do |j|  
        cadena += "Jugadores: #{j.to_s}\n"
      end
      cadena +="JugadorActual: #{@jugadorActual.to_s}\n
      Tablero: #{@tablero.to_s}\n"
      @mazo.each do |m|
        cadena += "Sorpresas: #{m.to_s}\n"
      end
      if @cartaActual != nil
      cadena +="CartaActual: #{@cartaActual.to_s}\n"
      else
        cadena +=" NO hay ninguna carta actual"
      end
      return cadena
    end
    
  end

end
