/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloqytetet;


/**
 *
 * @author mati
 */
public class Dado {
    private static final Dado instance = new Dado();

    private Dado(){
    }

    public static Dado getInstance() {
        return instance;
    }
    
    int tirar(){
        return (int) (Math.random()*6 + 1);
    }
    
}
