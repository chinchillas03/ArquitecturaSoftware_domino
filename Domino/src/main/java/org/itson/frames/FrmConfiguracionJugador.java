/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.frames;

import com.itson.listeners.ConfigurarJugadorListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class FrmConfiguracionJugador extends javax.swing.JFrame {

    private final ArrayList<ConfigurarJugadorListener> listeners;
    
    /**
     * Creates new form FrmConfiguracionJugador
     */
    public FrmConfiguracionJugador() {
        this.listeners = new ArrayList<ConfigurarJugadorListener>();
        initComponents();
    }
    
    public void addListener(final ConfigurarJugadorListener listener) {
        listeners.add(listener);
    }
    
    private String obtenerNombreJugador(){
        String nombre = txtNombreJugador.getText();
        return nombre;
    }
    
    public void mostrarPantallaConfigurarJugador(){
        this.setVisible(true);
    }
    
    public void cerrarPantallaConfigurarJugador(){
        this.setVisible(false);
    }
    
    public boolean validarCampoNombre(){
        int tamTexto = txtNombreJugador.getText().length();
        if (txtNombreJugador.getText().isBlank() || txtNombreJugador.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo del nombre esta vacio", "Campo nombre vacio", JOptionPane.ERROR_MESSAGE);
            return true;
        } else if (tamTexto < 3){
            JOptionPane.showMessageDialog(null, "El campo del nombre es muy corto", "Campo nombre corto", JOptionPane.ERROR_MESSAGE);
            return true;
        } else if (tamTexto > 15){
            JOptionPane.showMessageDialog(null, "El campo del nombre es muy grande", "Campo nombre demasiado grande", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }
    
    private void notificarBotonPrecionadoAplicar(){
        if (validarCampoNombre() == false) {
            for (final ConfigurarJugadorListener listener : listeners) {
                listener.clickBotonAplicar(this.obtenerNombreJugador());
            }
        }
    }
    
    private void notificarPrecionadoCancelar(){
        for (final ConfigurarJugadorListener listener : listeners) {
            listener.clickBotonCancelar();
        }
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
        jLabel2 = new javax.swing.JLabel();
        txtNombreJugador = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAplicar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Configura tu jugador");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Nombre:");

        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAplicar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAplicar.setText("Aplicar");
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAplicar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAplicar))
                .addGap(41, 41, 41))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        // TODO add your handling code here:
        this.notificarBotonPrecionadoAplicar();
    }//GEN-LAST:event_btnAplicarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.notificarPrecionadoCancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtNombreJugador;
    // End of variables declaration//GEN-END:variables
}
