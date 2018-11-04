#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "casilla"
require_relative "titulo_propiedad"
require_relative "sorpresa"
require_relative "qytetet"

module ModeloQytetet
  class Jugador
    
    attr_accessor :encarcelado, :nombre, :saldo, :cartaLibertad, :casillaActual, :propiedades
    
    def initialize(nombre)
      @encarcelado = false #boolean
      @nombre = nombre #string
      @saldo = 7500 #int
      @cartaLibertad = nil  # Sorpresa
      @casillaActual  = Casilla.crear_casillas_especiales(0,TipoCasilla::SALIDA) # Casilla
      @propiedades = Array.new() # TituloPropiedad
    end
    
    
    #Devuelve verdadero cuando el jugador es propietario de algún título de propiedad y falso en caso contrario.
    def tengoPropiedades #public boolean tengoPropiedades()
      aux = false
      if (@propiedades.size > 0)
        aux = true
      end
      return aux
    end
    
    def actualizarPosicion(casilla) #boolean actualizarPosicion(Casilla casilla){
      tienePropietario = false
      if casilla.numeroCasilla < @casillaActual.numeroCasilla
        modificarSaldo(500)
      end
      @casillaActual = casilla
      if (casilla.soyEdificable)
        tienePropietario = casilla.tengoPropietario
        if tienePropietario
          propencarcelado = casilla.propietarioEncarcelado
          if !propencarcelado
            modificarSaldo(-casilla.cobrarAlquiler)
          end
        end
      else
        if casilla.tipo == TipoCasilla::IMPUESTO
          coste = 1500#casilla.coste # si dejo casilla como coste es cero, no me resta nada, asi que asigno aqui 150
          modificarSaldo(-coste)
        end
      end
      return tienePropietario
    end
    
    def comprarTitulo #boolean comprarTitulo()
      puedoComprar = false
      if @casillaActual.soyEdificable
        tengoPropietario = @casillaActual.tengoPropietario
        if !tengoPropietario
          costeCompra = @casillaActual.coste
          if costeCompra <= @saldo
            titulo = @casillaActual.asignarPropietario(self)
            @propiedades << @casillaActual.titulo
            #@propiedades.each do |p|
            #end
            modificarSaldo(-costeCompra)
            puedoComprar = true
          end
        end
      end
      return puedoComprar
    end
    
    #Devuelve la carta Sorpresa cartaLibertad, pues el jugador ya ha hecho uso de ella. Esto implica que el jugador se queda sin esa carta. Presta atención a las referencias nulas, tendrás que utilizar una variable intermedia.
    def devolverCartaLibertad #Sorpresa devolverCartaLibertad()
      carta_aux = @cartaLibertad
      if (@cartaLibertad != nil)
        @cartaLibertad = nil
      end
      return carta_aux
    end
    
    def irACarcel(casilla) #void irACarcel(Casilla casilla){
            #casilla = carcel
      @casillaActual = casilla
      @encarcelado = true
    end
    
    # Añade al saldo la cantidad del argumento. Si el argumento es negativo, el saldo quedará reducido.
    def modificarSaldo(cantidad) #void modificarSaldo(int cantidad )
      @saldo = @saldo + cantidad
    end
    
    def obtenerCapital #int obtenerCapital()
      aux = @saldo
      @propiedades.each do |tp|  
        if(tp.hipotecada)
          aux = aux + tp.casilla.coste  + ((tp.casilla.numCasas + tp.casilla.numHoteles) * tp.precioEdificar) - tp.hipotecaBase
        else
          aux = aux + tp.casilla.coste + ((tp.casilla.numCasas + tp.casilla.numHoteles) * tp.precioEdificar)
        end
      end
      return aux
    end
    
    #Devuelve los títulos de propiedad del jugadorActual que estén hipotecados (cuando el parámetro hipotecada sea true) o que no estén hipotecados (cuando el parámetro hipotecada sea false).
    def obtenerPropiedadesHipotecadas(hipotecada) #ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada) { # qytetet propiedadesHipotecadasJugador
      titulprop = Array.new
      if(hipotecada == true)
        @propiedades.each do |propiedad|  
          if(propiedad.hipotecada == true)
            titulprop << propiedad
          end
        end
      else  
        @propiedades.each do |propiedad|  
          if(propiedad.hipotecada == false)
            titulprop << propiedad
          end
        end
      end
      return titulprop
    end
    
    def pagarCobrarPorCasaYHotel(cantidad) #void pagarCobrarPorCasaYHotel(int cantidad)
      total = cuantasCasasHotelesTengo
      modificarSaldo(total*cantidad)
    end
    
    def pagarLibertad(cantidad) #boolean pagarLibertad(int cantidad){ // cantidad = PrecioLibertad
      tengoSaldo = tengoSaldo(cantidad)
      if tengoSaldo
        modificarSaldo(-cantidad)
      end
      return tengoSaldo
    end
    
    def puedoEdificarCasa(casilla)#boolean puedoEdificarCasa(Casilla casilla){
      esMia = esDeMipropiedad(casilla)
      tengoSaldo = false
      if esMia
        costeEdificarCasa = casilla.titulo.precioEdificar
        tengoSaldo = tengoSaldo(costeEdificarCasa)
      end
      return (esMia && tengoSaldo)
    end
    
    def puedoEdificarHotel(casilla)#boolean puedoEdificarHotel(Casilla casilla){
      esMia = esDeMipropiedad(casilla)
      tengoSaldo = false
      if esMia
        costeEdificarHotel = casilla.titulo.precioEdificar
        tengoSaldo = tengoSaldo(costeEdificarHotel)
      end
      return (esMia && tengoSaldo)
    end
    
    def puedoHipotecar(casilla)#boolean puedoHipotecar(Casilla casilla){
      esDeMipropiedad(casilla)
    end
    
    def puedoPagarHipoteca(casilla)#boolean puedoPagarHipoteca(Casilla casilla){
      return tengoSaldo(casilla.calcularValorHipoteca);
    end
    
    #Cierto sólo si la casilla es de la propiedad de ese jugador (usa para ello el método que acabas de implementar esDeMipropiedad(casilla)) y no la tiene hipotecada.
    def puedoVenderPropiedad(casilla)#boolean puedoVenderPropiedad(Casilla casillaa){
      puedo = false
      if esDeMipropiedad(casilla)
        if !casilla.estaHipotecada
          puedo = true
        end
      end
      return puedo
    end
    
    #Cierto sólo si cartaLibertad no es nula.
    def tengoCartaLibertad#boolean tengoCartaLibertad()
      aux = false
      if(@cartaLibertad!=nil)
        aux true
      end
      return aux
    end
    
    def venderPropiedad(casilla)#void venderPropiedad(Casilla casilla)
      precioVenta = casilla.venderTitulo 
      modificarSaldo(precioVenta)
      eliminarDeMisPropiedades(casilla)
    end
    
    private
    
    #Devuelve el total de casas y hoteles que tiene ese jugador en todas sus propiedades.
    def cuantasCasasHotelesTengo #private int cuantasCasasHotelesTengo()
      return @propiedades.size
    end
    
    #Elimina el titulo de propiedad de esa casilla de su lista de propiedades.
    def eliminarDeMisPropiedades(casilla) #private void eliminarDeMisPropiedades(Casilla casilla)
          @propiedades.delete(casilla.titulo) 
    end
    
    #Cierto si el jugador tiene entre sus propiedades el título de propiedad de esa casilla.
    def esDeMipropiedad(casilla) #private boolean esDeMipropiedad(Casilla casilla) llamo con puedoVenderPropiedad
      aux = false
      @propiedades.each do |tp|  
        if(tp.getCasilla == casilla)
          aux = true
        end
      end
      return aux
    end
    
    #Devuelve verdadero si el saldo del jugador es superior o igual a cantidad.
    def tengoSaldo(cantidad) #private boolean tengoSaldo(int cantidad)
      return (@saldo >= cantidad)
    end
    
    public
    
    def to_s
      cadena =  "Jugador: 
      Encarcelado: #{@encarcelado}
      Nombre: #{@nombre}
      Saldo: #{@saldo}\n"
      if(@cartaLibertad!=nil)
      cadena += "CartaLibertad: #{@cartaLibertad.to_s} "
      end
      cadena +="CasillaActual: #{@casillaActual.to_s}"
      @propiedades.each do |prop|  
        cadena +="Propiedades: #{prop.to_s}"
      end
      return cadena
    end
    
  end
end
