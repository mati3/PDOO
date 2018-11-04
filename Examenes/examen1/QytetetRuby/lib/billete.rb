#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "tipo_billete"

module ModeloQytetet
  class Billete
    attr_accessor:color, :tipo
    
    @@moneda = "EURO" # string = EURO
    
    def initialize(c,t)
      @color = c # string
      @tipo = t #tipobillete
    end
    
    def to_s
      "Billetes: \n
        color: #{@color} \n 
        tipo: #{@tipo} \n "
    end
  end
end
