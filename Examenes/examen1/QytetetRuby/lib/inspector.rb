#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "casilla"

module ModeloQytetet
  class Inspector
    
    attr_accessor :manual, :nombre, :codigo
    @@manual = " debo inspeccionar las casillas con cuidado y esmero "
    @@contador = 0
    def initialize(n,c)
      @misCasillas = Array.new #Casillas
      @nombre = n
      @codigo = c # int
      Inspector.incrementarContador
    end
    
    def self.incrementarContador
      @@contador = @@contador + 1
    end
    
    def self.contador
      @@contador
    end
    
    def self.crear(nombre)
      c = Inspector.contador
      new(nombre,c)
    end
    
    def self.imprimirManual # metodo de instancia de la clase
      puts @@manual
    end
    
    def asignar_casilla(casilla)
      @misCasillas << casilla
    end
    
    def inspeccionar
      @misCasillas.each do |cas|  
        puts cas.titulo.nombre
      end
    end
    
    private
    def desasignar_casillas
      @misCasillas.each do |cas|  
        @misCasillas.delete(cas)
      end
    end
    
  end
end
