/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.frames;

import com.itson.listeners.PuntuacionesListener;
import com.itson.presentadores.PresentadorPuntuaciones;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class FrmPuntuaciones extends javax.swing.JFrame {

    private PuntuacionesListener listener;
    
    /**
     * Creates new form FrmPuntuaciones
     */
    public FrmPuntuaciones() {
        initComponents();
    }

    public void setListener(PuntuacionesListener listener) {
        this.listener = listener;
    }
    
    public void setLblNombreJugador1(String texto) {
        this.lblNombreJugador1.setText(texto);
    }

    public void setLblNombreJugador2(String texto) {
        this.lblNombreJugador2.setText(texto);
    }

    public void setLblNombreJugador3(String texto) {
        this.lblNombreJugador3.setText(texto);
    }

    public void setLblNombreJugador4(String texto) {
        this.lblNombreJugador4.setText(texto);
    }
    
    private void notificarBotonPrecionadoSalir(){
        listener.clickBotonSalir();        
    }
    
    public void mostrarPantallaPuntuaciones(){
        this.setVisible(true);
    }
    
    public void cerrarPantallaPuntuaciones(){
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

        jLabel1 = new javax.swing.JLabel();
        lblSegundoLugar = new javax.swing.JLabel();
        lblTercerLugar = new javax.swing.JLabel();
        lblCuartoLugar = new javax.swing.JLabel();
        lblPrimerLugar = new javax.swing.JLabel();
        lblNombreJugador1 = new javax.swing.JLabel();
        lblNombreJugador2 = new javax.swing.JLabel();
        lblNombreJugador3 = new javax.swing.JLabel();
        lblNombreJugador4 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(229, 239, 226));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Juego Terminado!!");

        lblSegundoLugar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblSegundoLugar.setText("Segundo Lugar:");

        lblTercerLugar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTercerLugar.setText("Tercer Lugar:");

        lblCuartoLugar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCuartoLugar.setText("Cuarto Lugar:");

        lblPrimerLugar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPrimerLugar.setText("Primer Lugar:");

        lblNombreJugador1.setText("Jugador 1");

        lblNombreJugador2.setText("Jugador 2");

        lblNombreJugador3.setText("Jugador 3 ");

        lblNombreJugador4.setText("Jugador 4");

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSalir.setText("Salir");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCuartoLugar)
                            .addComponent(lblSegundoLugar)
                            .addComponent(lblPrimerLugar)
                            .addComponent(lblTercerLugar))
                        .addGap(173, 173, 173)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombreJugador1)
                            .addComponent(lblNombreJugador2)
                            .addComponent(lblNombreJugador3)
                            .addComponent(lblNombreJugador4))))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(260, 260, 260))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrimerLugar)
                    .addComponent(lblNombreJugador1))
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSegundoLugar)
                    .addComponent(lblNombreJugador2))
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTercerLugar)
                    .addComponent(lblNombreJugador3))
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuartoLugar)
                    .addComponent(lblNombreJugador4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(54, 54, 54))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.notificarBotonPrecionadoSalir();
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCuartoLugar;
    private javax.swing.JLabel lblNombreJugador1;
    private javax.swing.JLabel lblNombreJugador2;
    private javax.swing.JLabel lblNombreJugador3;
    private javax.swing.JLabel lblNombreJugador4;
    private javax.swing.JLabel lblPrimerLugar;
    private javax.swing.JLabel lblSegundoLugar;
    private javax.swing.JLabel lblTercerLugar;
    // End of variables declaration//GEN-END:variables
}
