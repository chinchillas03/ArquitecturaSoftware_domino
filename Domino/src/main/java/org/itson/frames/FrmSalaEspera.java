/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.frames;

import com.itson.dominio.Avatar;
import com.itson.interfaces.JugadorSala;
import org.itson.listeners.SalaEsperaListener;
import java.util.List;
import javax.swing.ImageIcon;
/**
 *
 * @author Usuario
 */
public class FrmSalaEspera extends javax.swing.JFrame {

    private SalaEsperaListener listener;
    private JugadorSala jugador;
    
    /**
     * Creates new form FrmSalaEspera
     */
    public FrmSalaEspera() {
        initComponents();
    }

    public JugadorSala getJugador() {
        return jugador;
    }

    public void setJugador(JugadorSala jugador) {
        this.jugador = jugador;
    }

    public void setListener(SalaEsperaListener listener) {
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

    public void setCmbAvatarJugador1(List<Avatar> avatares) {
        for (Avatar avatare : avatares) {
            cmbAvatarJugador1.addItem(avatare.getIcon());
        }
    }

    public void setCmbAvatarJugador2(List<Avatar> avatares) {
        for (Avatar avatare : avatares) {
            cmbAvatarJugador2.addItem(avatare.getIcon());
        }
    }

    public void setCmbAvatarJugador3(List<Avatar> avatares) {
        for (Avatar avatare : avatares) {
            cmbAvatarJugador3.addItem(avatare.getIcon());
        }
    }

    public void setCmbAvatarJugador4(List<Avatar> avatares) {
        for (Avatar avatare : avatares) {
            cmbAvatarJugador4.addItem(avatare.getIcon());
        }
    }
    
    private void notificarBotonPrecionadoIniciarPartida(){
        listener.clickBotonIniciarPartida();      
    }
    
    private void notificarBotonPrecionadoSalir(){
        listener.clickBotonSalirPartida();
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
        cmbAvatarJugador2 = new javax.swing.JComboBox<>();
        cmbAvatarJugador3 = new javax.swing.JComboBox<>();
        cmbAvatarJugador4 = new javax.swing.JComboBox<>();

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(lblNombreJugador1)
                        .addGap(134, 134, 134)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIniciarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblNombreJugador2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNombreJugador3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(cmbAvatarJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(cmbAvatarJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(cmbAvatarJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                        .addComponent(lblNombreJugador4)
                        .addGap(134, 134, 134))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(cmbAvatarJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAvatarJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAvatarJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAvatarJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAvatarJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
    private javax.swing.JComboBox<ImageIcon> cmbAvatarJugador1;
    private javax.swing.JComboBox<ImageIcon> cmbAvatarJugador2;
    private javax.swing.JComboBox<ImageIcon> cmbAvatarJugador3;
    private javax.swing.JComboBox<ImageIcon> cmbAvatarJugador4;
    private javax.swing.JLabel lblNombreJugador1;
    private javax.swing.JLabel lblNombreJugador2;
    private javax.swing.JLabel lblNombreJugador3;
    private javax.swing.JLabel lblNombreJugador4;
    // End of variables declaration//GEN-END:variables
}
