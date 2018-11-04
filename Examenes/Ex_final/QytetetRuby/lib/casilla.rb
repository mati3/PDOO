 #encoding: utf-8
 # To change this license header, choose License Headers in Project Properties.
 # To change this template file, choose Tools | Templates
 # and open the template in the editor.
 
 require_relative "tipo_casilla"
 require_relative "titulo_propiedad"

module ModeloQytetet
  class Casilla
    
    attr_accessor :numeroCasilla, :tipo
       
    def initialize(numCasilla, tip)  # dos constructores
      @numeroCasilla = numCasilla  # int
      @tipo = tip  # TipoCasilla 
    end 
    
    def soyEdificable #boolean soyEdificable()
      return (@tipo == TipoCasilla::CALLE)
    end
    
    def to_s
      cadena =" CASILLA: 
      numeroCasilla: #{@numeroCasilla}
      tipo: #{@tipo} \n "
      cadena += " \nFin de casilla\n"
      return cadena
    end  
    
  end
end

