#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

#EXAMEN-inicio

require_relative "tablero"

module Obras
  class Constructora
    
    include ModeloQytetet
    
    attr_accessor:direccion
    attr_reader :nombre
    
    @@cif = "Q2467896F" #string
    def initialize(t,n,d)
      @tablero = t # Tablero
      @nombre = n
      @direccion = d
    end
    
    def self.crear(t,n)
      aux = false
      t.casillas.each do |cas|
          if(cas.tipo == TipoCasilla::CALLE && aux == false)
            d = t.casilla.get(cas.titulo.nombre)
            aux = true
          end
      end
      new(t,n,d)
    end
    
    def self.set_organo_colegiado(nuevo_cif)
      @@cif = nuevo_cif
    end
    
    def edificar
      @tablero.casillas.each do |cas|
        if(cas.tipo == TipoCasilla::CALLE)
          cas.numCasas += 1
        end
      end
    end
    
    def to_s
      "Constructora: \n
        Tablero: #{@tablero} \n 
        Nombre: #{@nombre} \n 
        Direccion: #{@direccion}"
    end
    
  end
end
#EXAMEN-fin