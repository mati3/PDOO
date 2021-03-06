/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIQytetet;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modeloqytetet.Calle;
import modeloqytetet.MetodoSalirCarcel;
import modeloqytetet.Qytetet;
import modeloqytetet.TipoCasilla;
/**
 *
 * @author mati
 */
public class ControladorQytetet extends javax.swing.JFrame {

        private  Qytetet modeloQytetet  ;
        private Calle calle;

    public Qytetet getModeloQytetet() {
        return modeloQytetet;
    }

    public void setModeloQytetet(ArrayList<String> nombres) {
        this.modeloQytetet = Qytetet.getInstance(nombres);
    } 
    /**
     * Creates new form ControladorQytetet
     */
    public ControladorQytetet() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Boton_siguiente_jugador = new javax.swing.JButton();
        Boton_aplicar_sorpresa = new javax.swing.JButton();
        Boton_comprar_propiedad = new javax.swing.JButton();
        Boton_jugar = new javax.swing.JButton();
        Boton_salir_calcel_pagando = new javax.swing.JButton();
        Boton_salir_carcel_dado = new javax.swing.JButton();
        vistaQytetet = new GUIQytetet.VistaQytetet();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Boton_siguiente_jugador.setText("Siguiente Jugador");
        Boton_siguiente_jugador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Boton_siguiente_jugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_siguiente_jugadorActionPerformed(evt);
            }
        });

        Boton_aplicar_sorpresa.setText("Aplicar Sorpresa");
        Boton_aplicar_sorpresa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Boton_aplicar_sorpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_aplicar_sorpresaActionPerformed(evt);
            }
        });

        Boton_comprar_propiedad.setText("Comprar Propiedad");
        Boton_comprar_propiedad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Boton_comprar_propiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_comprar_propiedadActionPerformed(evt);
            }
        });

        Boton_jugar.setText("Jugar");
        Boton_jugar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Boton_jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_jugarActionPerformed(evt);
            }
        });

        Boton_salir_calcel_pagando.setText("Salir Cárcel Pagando");
        Boton_salir_calcel_pagando.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Boton_salir_calcel_pagando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_salir_calcel_pagandoActionPerformed(evt);
            }
        });

        Boton_salir_carcel_dado.setText("Salir Cárcel Dado");
        Boton_salir_carcel_dado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Boton_salir_carcel_dado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_salir_carcel_dadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Boton_salir_carcel_dado, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton_salir_calcel_pagando, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(Boton_jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Boton_comprar_propiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Boton_aplicar_sorpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Boton_siguiente_jugador, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(vistaQytetet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vistaQytetet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(Boton_salir_carcel_dado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Boton_salir_calcel_pagando, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Boton_comprar_propiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton_aplicar_sorpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton_siguiente_jugador, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(Boton_jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_siguiente_jugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_siguiente_jugadorActionPerformed
        // TODO add your handling code here:
        modeloQytetet.siguienteJugador();
        Boton_siguiente_jugador.setEnabled(false);
        Boton_jugar.setEnabled(true);
        this.vistaQytetet.actualizar(modeloQytetet);
    }//GEN-LAST:event_Boton_siguiente_jugadorActionPerformed

    private void Boton_aplicar_sorpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_aplicar_sorpresaActionPerformed
        // TODO add your handling code here: cuando tengo una sorpresa es obligatoria ? desabilitar el boton de siguiente jugador. ******************************************
        boolean aplicada = modeloQytetet.aplicarSorpresa();
        if (aplicada){
            JOptionPane.showMessageDialog(this, "He plicado la sorpresa "); 
        }
        Boton_aplicar_sorpresa.setEnabled(false);
        this.vistaQytetet.actualizar(modeloQytetet);
    }//GEN-LAST:event_Boton_aplicar_sorpresaActionPerformed

    private void Boton_comprar_propiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_comprar_propiedadActionPerformed
        // TODO add your handling code here:
        boolean comprado = modeloQytetet.comprarTituloPropiedad();
        if (comprado){
            JOptionPane.showMessageDialog(this, "He comprado el titulo de propiedad ");  
        }
        this.vistaQytetet.actualizar(modeloQytetet);
    }//GEN-LAST:event_Boton_comprar_propiedadActionPerformed

    private void Boton_jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_jugarActionPerformed
        // TODO add your handling code here:
        boolean tienepropietario = modeloQytetet.jugar();
        if(tienepropietario){
           JOptionPane.showMessageDialog(this, "La asilla tiene propietario y hemos pagado el coste sila casilla no es mia");   
        }
        if(modeloQytetet.getJugadorActual().getCasillaActual().getTipo() == TipoCasilla.CARCEL){
            this.Boton_salir_calcel_pagando.setEnabled(true);
            this.Boton_salir_carcel_dado.setEnabled(true);
        }
        else if(modeloQytetet.getJugadorActual().getCasillaActual().getTipo() == TipoCasilla.SORPRESA){
            this.Boton_aplicar_sorpresa.setEnabled(true);
        }else if(modeloQytetet.getJugadorActual().getCasillaActual().getTipo() == TipoCasilla.CALLE){
            calle = (Calle)modeloQytetet.getJugadorActual().getCasillaActual();
            if(!calle.tengoPropietario()){
                Boton_comprar_propiedad.setEnabled(true);
            }
        }
        this.Boton_jugar.setEnabled(false);
        this.Boton_siguiente_jugador.setEnabled(true);
        
        
        this.vistaQytetet.actualizar(modeloQytetet);
    }//GEN-LAST:event_Boton_jugarActionPerformed

    private void Boton_salir_calcel_pagandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_salir_calcel_pagandoActionPerformed
        // TODO add your handling code here:
        boolean resultado = modeloQytetet.intentarSalirCarcel(MetodoSalirCarcel.PAGANDOLIBERTAD);
        this.Boton_salir_calcel_pagando.setEnabled(false);
        this.Boton_salir_carcel_dado.setEnabled(false);
        if(resultado){
            JOptionPane.showMessageDialog(this, "Sales de la cárcel");
            this.Boton_jugar.setEnabled(true);
        }else {
            JOptionPane.showMessageDialog(this, "NO sales de la carcel");
            this.Boton_siguiente_jugador.setEnabled(true);
        }
        this.vistaQytetet.actualizar(modeloQytetet);
    }//GEN-LAST:event_Boton_salir_calcel_pagandoActionPerformed

    private void Boton_salir_carcel_dadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_salir_carcel_dadoActionPerformed
        // TODO add your handling code here:
        boolean resultado = modeloQytetet.intentarSalirCarcel(MetodoSalirCarcel.TIRANDODADO);
        this.Boton_salir_calcel_pagando.setEnabled(false);
        this.Boton_salir_carcel_dado.setEnabled(false);
        if(resultado){
            JOptionPane.showMessageDialog(this, "Sales de la cárcel");
            this.Boton_jugar.setEnabled(true);
        }else {
            JOptionPane.showMessageDialog(this, "NO sales de la carcel");
            this.Boton_siguiente_jugador.setEnabled(true);
        }
        this.vistaQytetet.actualizar(modeloQytetet);
    }//GEN-LAST:event_Boton_salir_carcel_dadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        ControladorQytetet controladorQytetet= new ControladorQytetet();
        Dado.createInstance(controladorQytetet);
        CapturaNombreJugadores capturaNombres = new CapturaNombreJugadores(controladorQytetet, true);
        ArrayList<String> nombres= capturaNombres.obtenerNombres();
        controladorQytetet.setModeloQytetet(nombres);
        controladorQytetet.vistaQytetet.actualizar(controladorQytetet.getModeloQytetet());
        controladorQytetet.Boton_comprar_propiedad.setEnabled(false);
        controladorQytetet.Boton_siguiente_jugador.setEnabled(false);
        controladorQytetet.Boton_aplicar_sorpresa.setEnabled(false);
        controladorQytetet.Boton_salir_calcel_pagando.setEnabled(false);
        controladorQytetet.Boton_salir_carcel_dado.setEnabled(false);
        //controladorQytetet.habilitarComenzarTurno();
        controladorQytetet.setVisible(true); //Esta debe ser la última línea de código del main
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_aplicar_sorpresa;
    private javax.swing.JButton Boton_comprar_propiedad;
    private javax.swing.JButton Boton_jugar;
    private javax.swing.JButton Boton_salir_calcel_pagando;
    private javax.swing.JButton Boton_salir_carcel_dado;
    private javax.swing.JButton Boton_siguiente_jugador;
    private GUIQytetet.VistaQytetet vistaQytetet;
    // End of variables declaration//GEN-END:variables

    public void habilitarComenzarTurno(){
        this.Boton_comprar_propiedad.setEnabled(false);
        this.Boton_siguiente_jugador.setEnabled(false);
        this.Boton_aplicar_sorpresa.setEnabled(false);
        if(modeloQytetet.getJugadorActual().getEncarcelado()){
            this.Boton_salir_calcel_pagando.setEnabled(true);
            this.Boton_salir_carcel_dado.setEnabled(true);
        }
        else
            this.Boton_jugar.setEnabled(true);
    }
    
    public void actualizar(){
       // habilitarComenzarTurno();
        this.repaint(); //Investiga para qué sirven estos métodos
        this.revalidate();
    }
    
}
