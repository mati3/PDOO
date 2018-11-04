#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module ModeloQytetet
  class Sorpresa
    
    attr_reader :texto, :valor, :tipo
    
    def initialize(t,v,tp)
      @texto = t
      @valor = v
      @tipo = tp #tipo_sorpresa
    end
    
    def to_s
      " Sorpresa:
          Texto: #{@texto} 
          Valor: #{@valor}
          Tipo: #{@tipo}"
    end
    
  end
end
