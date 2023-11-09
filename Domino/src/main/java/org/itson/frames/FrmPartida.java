/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.frames;

import com.itson.dominio.Partida;
import com.itson.interfaces.IPartidaJuego;
import com.itson.listeners.TableroJuegoListener;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import org.itson.dibujo.Dibujante;

/**
 *
 * @author Usuario
 */
public class FrmPartida extends javax.swing.JFrame {

    private TableroJuegoListener listener;
    private Dibujante dibujante;
    private IPartidaJuego partida= Partida.instancia();
    /**
     * Creates new form FrmPartida
     */
    public FrmPartida() {
        initComponents();
        this.btnPasarTurno.setVisible(false);
        dibujante = new Dibujante();
    }

    public void addListener(TableroJuegoListener listener) {
        this.listener = listener;
    }

    private void notificarBotonPrecionadoAbandonarPartida() {
        listener.clickBotonAbandonarPartida();
    }

    public void setLblNombreJugador1(String texto) {
        this.lblJugador1.setText(texto);
    }

    public void setLblNombreJugador2(String texto) {
        this.lblJugador2.setText(texto);
    }

    public void setLblNombreJugador3(String texto) {
        this.lblJugador3.setText(texto);
    }

    public void setLblNombreJugador4(String texto) {
        this.lblJugador4.setText(texto);
    }
  

    public void mostrarPantallaPartida() {
        this.setVisible(true);
    }

    public void cerrarPantallaPartida() {
        this.setVisible(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        actualizarPantalla(Partida.instancia(), g ,this.pnlTablero.getGraphics());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPartida = new javax.swing.JPanel();
        btnAbandonarPartida = new javax.swing.JButton();
        lblJugador1 = new javax.swing.JLabel();
        panelJuego = new javax.swing.JScrollPane();
        pnlTablero = new javax.swing.JPanel();
        lblJugador2 = new javax.swing.JLabel();
        lblJugador3 = new javax.swing.JLabel();
        lblJugador4 = new javax.swing.JLabel();
        btnJalarPozo = new javax.swing.JButton();
        btnPasarTurno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Partida");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnlPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPartidaMouseClicked(evt);
            }
        });

        btnAbandonarPartida.setText("Abandonar Partida");
        btnAbandonarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbandonarPartidaActionPerformed(evt);
            }
        });

        lblJugador1.setText("jugador");

        panelJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelJuegoMouseClicked(evt);
            }
        });

        pnlTablero.setBackground(new java.awt.Color(51, 102, 0));

        javax.swing.GroupLayout pnlTableroLayout = new javax.swing.GroupLayout(pnlTablero);
        pnlTablero.setLayout(pnlTableroLayout);
        pnlTableroLayout.setHorizontalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 898, Short.MAX_VALUE)
        );
        pnlTableroLayout.setVerticalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        panelJuego.setViewportView(pnlTablero);

        lblJugador2.setText("jugador");

        lblJugador3.setText("jugador");

        lblJugador4.setText("jugador");

        btnJalarPozo.setText("Jalar Pozo");
        btnJalarPozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJalarPozoActionPerformed(evt);
            }
        });

        btnPasarTurno.setText("Pasar Turno");

        javax.swing.GroupLayout pnlPartidaLayout = new javax.swing.GroupLayout(pnlPartida);
        pnlPartida.setLayout(pnlPartidaLayout);
        pnlPartidaLayout.setHorizontalGroup(
            pnlPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPartidaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJugador2)
                    .addGroup(pnlPartidaLayout.createSequentialGroup()
                        .addComponent(lblJugador1)
                        .addGap(34, 34, 34)
                        .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPasarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnJalarPozo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJugador4)
                    .addComponent(lblJugador3))
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPartidaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAbandonarPartida)
                .addGap(481, 481, 481))
        );
        pnlPartidaLayout.setVerticalGroup(
            pnlPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPartidaLayout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(pnlPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugador2)
                    .addComponent(lblJugador3))
                .addGap(4, 4, 4)
                .addGroup(pnlPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPartidaLayout.createSequentialGroup()
                        .addComponent(btnJalarPozo)
                        .addGap(18, 18, 18)
                        .addComponent(btnPasarTurno)
                        .addGap(305, 305, 305))
                    .addGroup(pnlPartidaLayout.createSequentialGroup()
                        .addComponent(panelJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPartidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJugador1)
                            .addComponent(lblJugador4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(btnAbandonarPartida)
                        .addGap(40, 40, 40))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnJalarPozoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJalarPozoActionPerformed
        if (partida.getPozo().getFichas() != null) {
            listener.jalarPozo(partida.getJugadores().get(0));
        } else {
            JOptionPane.showMessageDialog(null, "Hola se acabaron las fichas del pozo");
            this.btnJalarPozo.setEnabled(false);
        }

        this.repaint();
    }//GEN-LAST:event_btnJalarPozoActionPerformed

    private void btnAbandonarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarPartidaActionPerformed
        // TODO add your handling code here:
        this.notificarBotonPrecionadoAbandonarPartida();
    }//GEN-LAST:event_btnAbandonarPartidaActionPerformed

    private void panelJuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelJuegoMouseClicked
        // TODO add your handling code here:
        listener.actualizarPantalla();
    }//GEN-LAST:event_panelJuegoMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void pnlPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPartidaMouseClicked
        this.posicionarFicha(evt);
    }//GEN-LAST:event_pnlPartidaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbandonarPartida;
    private javax.swing.JButton btnJalarPozo;
    private javax.swing.JButton btnPasarTurno;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblJugador3;
    private javax.swing.JLabel lblJugador4;
    private javax.swing.JScrollPane panelJuego;
    private javax.swing.JPanel pnlPartida;
    private javax.swing.JPanel pnlTablero;
    // End of variables declaration//GEN-END:variables
    public void posicionarFicha(java.awt.event.MouseEvent evt) {
        listener.posicionarFicha(evt);
        this.repaint();
    }
 
    public void actualizarPantalla(IPartidaJuego partida, Graphics g, Graphics g2) {
        dibujante.crearLista(partida);
        dibujante.dibujarTodos(g);
    }

    public void mostrarMsgError() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void mostarFicha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
