/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.frames;

import com.itson.dominio.Jugador;
import com.itson.listeners.SalaEsperaListener;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.itson.Modelos.ModelSalaEspera;

/**
 *
 * @author Usuario
 */
public class FrmSalaEspera extends javax.swing.JFrame {

    private final ArrayList<SalaEsperaListener> listeners;
    private ModelSalaEspera model;
    
    /**
     * Creates new form FrmSalaEspera
     */
    public FrmSalaEspera() {
        listeners = new ArrayList<SalaEsperaListener>();
        initComponents();
    }

    public void addListener(final SalaEsperaListener listener) {
        listeners.add(listener);
    }
    
    private void notificarBotonPrecionadoIniciarPartida(){
        for (final SalaEsperaListener listener : listeners) {
            listener.clickBotonIniciarPartida();
        }
    }
    
    public void setModel(ModelSalaEspera model) {
        this.model = model;    
    }
    
    public void setModelPantalla(){
        List<Jugador> jugadores = new LinkedList<>();
        jugadores = this.model.getJugadores();
        
        lblNombreJugador1.setText(jugadores.get(0).getNombre());
        lblNombreJugador2.setText(jugadores.get(1).getNombre());
        lblNombreJugador3.setText(jugadores.get(2).getNombre());
        lblNombreJugador4.setText(jugadores.get(3).getNombre());
    }

    public ModelSalaEspera getModel() {
        return model;
    }
    
    private void notificarBotonPrecionadoSalir(){
        for (final SalaEsperaListener listener : listeners) {
            listener.clickBotonSalirPartida();
        }
    }
    
    public void mostrarPantallaSalaEspera(){
        this.setVisible(true);
    }
    
    public void cerrarPantallaSalaEspera(){
        this.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIniciarPartida = new javax.swing.JButton();
        lblNombreJugador1 = new javax.swing.JLabel();
        lblNombreJugador2 = new javax.swing.JLabel();
        lblNombreJugador4 = new javax.swing.JLabel();
        lblNombreJugador3 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        cmbAvatarJugador1 = new javax.swing.JComboBox<>();
        cmbAvatarJugador3 = new javax.swing.JComboBox<>();
        cmbAvatarJugador4 = new javax.swing.JComboBox<>();
        cmbAvatarJugador2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(229, 239, 226));
        setResizable(false);

        btnIniciarPartida.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btnIniciarPartida.setText("Iniciar partida");
        btnIniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarPartidaActionPerformed(evt);
            }
        });

        lblNombreJugador1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblNombreJugador1.setText("Jugador 1");

        lblNombreJugador2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblNombreJugador2.setText("Jugador 2");

        lblNombreJugador4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblNombreJugador4.setText("Jugador 4");

        lblNombreJugador3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblNombreJugador3.setText("Jugador 3");

        btnSalir.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(lblNombreJugador1)
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNombreJugador2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNombreJugador3))
                    .addComponent(btnIniciarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(lblNombreJugador4)
                .addGap(134, 134, 134))
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(cmbAvatarJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(cmbAvatarJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbAvatarJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(cmbAvatarJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAvatarJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAvatarJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAvatarJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAvatarJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreJugador1)
                    .addComponent(lblNombreJugador2)
                    .addComponent(lblNombreJugador4)
                    .addComponent(lblNombreJugador3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(btnIniciarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(49, 49, 49))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPartidaActionPerformed
        // TODO add your handling code here:
        this.notificarBotonPrecionadoIniciarPartida();
        this.dispose();
    }//GEN-LAST:event_btnIniciarPartidaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.notificarBotonPrecionadoSalir();
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarPartida;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Color> cmbAvatarJugador1;
    private javax.swing.JComboBox<Color> cmbAvatarJugador2;
    private javax.swing.JComboBox<Color> cmbAvatarJugador3;
    private javax.swing.JComboBox<Color> cmbAvatarJugador4;
    private javax.swing.JLabel lblNombreJugador1;
    private javax.swing.JLabel lblNombreJugador2;
    private javax.swing.JLabel lblNombreJugador3;
    private javax.swing.JLabel lblNombreJugador4;
    // End of variables declaration//GEN-END:variables
}
