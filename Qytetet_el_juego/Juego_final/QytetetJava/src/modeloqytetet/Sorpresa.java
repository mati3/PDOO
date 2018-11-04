/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;

/**
 *
 * @author chipi
 */
public class Sorpresa {
    private String texto; // describe la sorpresa
    private TipoSorpresa tipo; //tipo de enumerado
    private int valor ; // seccion 10 reglas del juego

    public Sorpresa(String texto, int valor, TipoSorpresa tipo) {
        this.texto = texto;
        this.tipo = tipo;
        this.valor = valor;
    }

    String getTexto() { // no se indica la visibilidad por defecto es package
        return texto;
    }

    TipoSorpresa getTipo() {
        return tipo;
    }

    int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return " Sorpresa{" + "texto=" + texto +  ", valor=" + Integer.toString(valor) + ", tipo=" + tipo + "}";
    }
    
    
}
