#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "casilla"

module ModeloQytetet
  class Jugador
    
    attr_accessor :encarcelado, :nombre, :saldo, :cartaLibertad, :casillaActual, :propiedades
    
    def initialize(nombre)
      @encarcelado = false #boolean
      @nombre = nombre #string
      @saldo = 7500 #int
      @cartaLibertad = Sorpresa.new('sorpresa',0,TipoSorpresa::salircarcel)
      @casillaActual = Casilla.new(0,0,TipoCasilla::salida)
      @propiedades = Array.new()
    end
    
    
    
    def tengoPropiedades #public boolean tengoPropiedades()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def actualizarPosicion(casilla) #boolean actualizarPosicion(Casilla casilla){
      raise ArgumentError,'metodo sin implementar'
    end
    
    def comprarTitulo #boolean comprarTitulo()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def devolverCartaLibertad #Sorpresa devolverCartaLibertad()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def irACarcel(casilla) #void irACarcel(Casilla casilla){
            #casilla = carcel
      raise ArgumentError,'metodo sin implementar'
    end
    
    def modificarSaldo(cantidad) #void modificarSaldo(int cantidad )
      raise ArgumentError,'metodo sin implementar'
    end
    
    def obtenerCapital #int obtenerCapital()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def obtenerPropiedadesHipotecadas(hipotecada) #ArrayList<TituloPropiedad> obtenerPropiedadesHipotecadas(boolean hipotecada) {
      raise ArgumentError,'metodo sin implementar'
    end
    
    def pagarCobrarPorCasaYHotel(cantidad) #void pagarCobrarPorCasaYHotel(int cantidad)
      raise ArgumentError,'metodo sin implementar'
    end
    
    def pagarLibertad(cantidad) #boolean pagarLibertad(int cantidad){ // cantidad = PrecioLibertad
      raise ArgumentError,'metodo sin implementar'
    end
    
    def puedoEdificarCasa(casilla)#boolean puedoEdificarCasa(Casilla casilla){
      raise ArgumentError,'metodo sin implementar'
    end
    
    def puedoEdificarHotel(casilla)#boolean puedoEdificarHotel(Casilla casilla){
      raise ArgumentError,'metodo sin implementar'
    end
    
    def puedoHipotecar(casilla)#boolean puedoHipotecar(Casilla casilla){
      raise ArgumentError,'metodo sin implementar'
    end
    
    def puedoPagarHipoteca(casilla)#boolean puedoPagarHipoteca(Casilla casilla){
      raise ArgumentError,'metodo sin implementar'
    end
    
    def puedoVenderPropiedad(casilla)#boolean puedoVenderPropiedad(Casilla casillaa){
      raise ArgumentError,'metodo sin implementar'
    end
    
    def tengoCartaLibertad#boolean tengoCartaLibertad()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def venderPropiedad(casilla)#void venderPropiedad(Casilla casilla)
      raise ArgumentError,'metodo sin implementar'
    end
    
    private
    
    def cuantasCasasHotelesTengo #private int cuantasCasasHotelesTengo()
      raise ArgumentError,'metodo sin implementar'
    end
    
    def eliminarDeMisPropiedades(casilla) #private void eliminarDeMisPropiedades(Casilla casilla)
      raise ArgumentError,'metodo sin implementar'
    end
    
    def esDeMipropiedad(casilla) #private boolean esDeMipropiedad(Casilla casilla)
      raise ArgumentError,'metodo sin implementar'
    end
    
    def tengoSaldo(cantidad) #private boolean tengoSaldo(int cantidad)
      raise ArgumentError,'metodo sin implementar'
    end
    
  end
end
