#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "qytetet"
require_relative "casilla"
require_relative "jugador"
require_relative "titulo_propiedad"
require_relative "vista_textual_qytetet"

module InterfazTextualQytetet
  class ControladorQytetet
    
    include ModeloQytetet
    
    def initialize
      @juego #clase qytetet
      @jugador # clase jugador
      @casilla # clase casilla
      @vista = VistaTextualQytetet.new # clase VistaTextualQytetet,
    end
     
    def inicializacionJuego # void
      jugadores = @vista.obtener_nombre_jugadores
      @juego = Qytetet.instance
      @juego.inicializarJuego(jugadores)
      @vista.mostrar(" muestro el juego " + @juego.to_s + " \n")
      @jugador = @juego.jugadorActual
      @vista.mostrar(" muestro el jugador \n" +@jugador.to_s + "\n")
      @casilla = @jugador.casillaActual
      @vista.pausar
    end
    
    def desarrolloJuego #void
      termino = false ;
      while(!termino)
        tienePropietario = false;
        @vista.mostrar("\n nuevo turno")
        @vista.mostrar("jugador JUGADOR: " + @jugador.to_s)
        @vista.pausar
            
        if(@jugador.encarcelado)
          elegir=@vista.menu_salir_carcel             
          logrosalicarcel = false 
          if(elegir == 0) # tiro dado
            logrosalicarcel = @juego.intentarSalirCarcel(MetodoSalirCarcel::TIRANDODADO)
            @vista.mostrar(" eligo tirar el dado: " + logrosalicarcel.to_s)
          elsif(elegir == 1) #pago 200 euros
            logrosalicarcel=@juego.intentarSalirCarcel(MetodoSalirCarcel::PAGANDOLIBERTAD)
            @vista.mostrar(" eligo pagar 200 euros: " + logrosalicarcel.to_s)
          else
            @vista.mostrar("error, debe elegir una opcion")
          end
          if(logrosalicarcel)
            @vista.mostrar(" jugador liberado de la carcel, sigue jugando ")
          end
        end
        if (!@jugador.encarcelado)
          tienePropietario = @juego.jugar()
          @casilla = @jugador.casillaActual
          @vista.mostrar("he terminado de jugar")
          @vista.mostrar(" CasillaActual: ***************** " + @casilla.to_s)
          @vista.pausar
          @vista.mostrar(" tienePropietario: " + tienePropietario.to_s)
          if(@casilla.tipo == TipoCasilla::CALLE)
            @vista.mostrar(" Estoy en una casilla tipo CALLE : \n " )
            # si tiene propietario y no soy yo, tengo que pagar alquiler
            if(@casilla.tengoPropietario && @casilla.titulo.nombre != @jugador.nombre)
              @vista.mostrar(" Tengo que pagar alquiler \n " ) # se hace en jugar
              @vista.mostrar(" SaldoNuevo Jugador" + @jugador.saldo.to_s)
            else# si no tiene propietario la puedo comprar, darle opciones
              @vista.mostrar(" Puedes comprar un titulo de Propiedad \n ")
              
              if(@vista.elegir_quiero_comprar)
                neox =@juego.comprarTituloPropiedad
                @vista.mostrar("comprarTituloPropiedad "+ neox.to_s)
                @jugador.propiedades.each do |a|
                  @vista.mostrar("Mis propiedades " + a.to_s)
                end
                @vista.pausar
              end
            end
          else
            @vista.mostrar(" la casilla no es de tipo calle")
            if(@casilla.tipo == TipoCasilla::SORPRESA)#es de tipo sorpres
              tienePropietario= @juego.aplicarSorpresa()
              @vista.mostrar("Estoy en una casilla SORPRESA, He aplicado mi sorpresa CartaActual: \n " + @juego.cartaActual.to_s)
            end
            @vista.pausar
          end
     #////// tengo propiedades, no estoy en bancarrota y no estoy en la carcel, GESTION INMOBILIARIA //////////////////
          if(@jugador.saldo > 0 && @jugador.tengoPropiedades)
            @vista.mostrar(" Empezamos con las propiedades...... que hacemos con ellas.............. ")
            opc = @vista.menu_gestion_inmobiliaria
            conseguido = false
            case opc
            when 0
              @vista.mostrar(" Paso de turno ")
            when 1 # muestro todas las propiedades
              @vista.mostrar(" lista de propiedades 1")
              @jugador.propiedades.each do |aux|
                @vista.mostrar(aux.to_s + "\n ")
              end
              @vista.mostrar(" termino de mostrar prioridades ")
              @casilla = ElegirCasillaDePropiedad(nil)
              conseguido = @juego.edificarCasa(@casilla)
              @vista.mostrar(" Edifico una casa " + conseguido.to_s)
            when 2 # muestro todas las propiedades
              @vista.mostrar(" lista de propiedades 2")
              @jugador.propiedades.each do |aux|
                @vista.mostrar(aux.to_s + "\n ")
              end
              @casilla = ElegirCasillaDePropiedad(nil)
              conseguido = @juego.edificarHotel(@casilla)
              @vista.mostrar(" Edifico un Hotel " + conseguido.to_s)
            when 3 # muestro solo las NO hipotecadas
              @vista.mostrar(" lista de propiedades 3")
              @juego.propiedadesHipotecadasJugador(false).each do |aux|
                @vista.mostrar(aux.to_s + "\n ")
              end
              @casilla = ElegirCasillaDePropiedad(false)
              conseguido = @juego.venderPropiedad(@casilla)#****************************************************************************
              @vista.mostrar(" Vendo Propiedad elegida " + conseguido.to_s)
            when 4 # muestro solo las NO hipotecadas
              @vista.mostrar(" lista de propiedades 4")
              @juego.propiedadesHipotecadasJugador(false).each do |aux|
                @vista.mostrar(aux.to_s + "\n ")
              end
              @casilla = ElegirCasillaDePropiedad(false)
              conseguido = @juego.hipotecarPropiedad(@casilla)
              @vista.mostrar(" Hipoteco propiedad elegida " + conseguido.to_s)
            when 5 # muestro solo las SI hipotecadas
              @vista.mostrar(" lista de propiedades 5")
              @juego.propiedadesHipotecadasJugador(true).each do |aux|
                @vista.mostrar(aux.to_s + "\n ")
              end
              @casilla = ElegirCasillaDePropiedad(true)
              if(@casilla == nil)
                @vista.mostrar(" ************** NO hay propiedades Hipotecadas. ************ " )
              else
                conseguido = @juego.cancelarHipoteca(@casilla)
                @vista.mostrar(" Cancelo la hipoteca " + conseguido.to_s)
              end
            else
              @vista.mostrar(" error en case ")
            end
          end
        end # cierro no encarcelado (!@jugador.encarcelado)
        
        if(@juego.jugadorActual.saldo <= 0)
          @vista.mostrar("jugador en bancarrota, se termina el juego \n")
          @vista.mostrar(" ranking de mejor a peor \n")
          map =  @juego.obtenerRanking()
          map.each { |k, v| puts "Key=#{k}, + Value=#{v}"}
          termino = true
        end
        @juego.siguienteJugador
        @jugador = @juego.jugadorActual
        @casilla = @jugador.casillaActual
      end           
    end
       
    #hipotecada true eligo casillas hipotecadas, false No hipotecadas, nil = todas
    def ElegirCasillaDePropiedad(hip=nil)# return Casilla
      casillas = Array.new
      if(hip == true)
        @jugador.propiedades.each do |tp|  
          if tp.hipotecada == true
            casillas << tp.getCasilla
          end
        end
      elsif(hip == false)
        @jugador.propiedades.each do |tp|  
          if tp.hipotecada == false
            casillas << tp.getCasilla
          end
        end
      elsif(hip == nil)
        @jugador.propiedades.each do |tp|  
          casillas << tp.getCasilla
          
        end
      end
      casilla_local = nil
      if(casillas.size > 0)
        casilla_local = elegirPropiedad(casillas)
     end
      return casilla_local
    end
   
    # añadir el siguiente método a ControladorQytetet
    def elegirPropiedad(propiedades)#public Casilla elegirPropiedad(ArrayList<Casilla> propiedades){ 
     @vista.mostrar("\tCasilla\tTitulo");
       
        listaPropiedades= Array.new
        for prop in propiedades  # crea una lista de strings con numeros y nombres de propiedades
                propString= prop.numeroCasilla.to_s+' '+prop.titulo.nombre; 
                listaPropiedades << propString
        end
        seleccion=@vista.menu_elegir_propiedad(listaPropiedades)  # elige de esa lista del menu
        propiedades.at(seleccion)
    end
    
    def self.main       
        c = ControladorQytetet.new
        c.inicializacionJuego
        c.desarrolloJuego
    end
  end
  ControladorQytetet.main
end