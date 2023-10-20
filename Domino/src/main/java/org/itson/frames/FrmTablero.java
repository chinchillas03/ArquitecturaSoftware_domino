/**
* FrmTablero.java
* Oct 19, 2023 11:03:38 PM
*/ 

package org.itson.frames;

import com.itson.dominio.Jugador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.itson.Modelos.ModelTablero;

/**
 *
 * 
 * @author Joel Antonio Lopez Cota ID:228926 
 */
public class FrmTablero extends JFrame {
    ModelTablero tablero;
    
    public FrmTablero() {
        setTitle("Dibujando en JFrame");
        setSize(1024, 758); // Establece el tamaño del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         tablero=new ModelTablero();
         List<Jugador> lista= new ArrayList<>();
         lista.add(new Jugador());
         lista.add(new Jugador());
         lista.add(new Jugador());
         lista.add(new Jugador());
         tablero.iniciarPartida(lista,4);
        MiPanel panel = new MiPanel();
        panel.setLayout(null);
        JButton btnAbandonar= new JButton("Abandonar Partida");
         btnAbandonar.setBounds(420, 590, 150, 30);
        panel.add(btnAbandonar);
        JScrollPane jscp=new JScrollPane();
        jscp.setBounds(100, 150, 750, 400);
        JButton btnPozo=new JButton("Jalar Pozo");
                btnPozo.setBounds(880, 450, 100, 30);
        panel.add(jscp);
        panel.add(btnPozo);
        this.add(panel);
        btnAbandonar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción a realizar cuando se hace clic en el botón
                JOptionPane.showMessageDialog(null, "¡Botón clickeado!");
            }
        });
        this.setTitle("Domino");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
            new FrmTablero().setVisible(true);
    }
    
}

class MiPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja un rectángulo rojo en la posición (100, 100) con un ancho de 200 y una altura de 100
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1024, 50);
        
        // Dibuja un círculo azul en la posición (500, 300) con un radio de 50
        g.setColor(Color.BLACK);
        g.fillRect(0, 671, 1024, 50);
        
        
        g.setColor(Color.BLACK);
        g.fillOval(25, 65, 75, 75);
        
        g.setColor(Color.GRAY);
        g.fillOval(25, 585, 75, 75);
        
         g.setColor(Color.LIGHT_GRAY);
        g.fillOval(850, 65, 75, 75);
        
         g.setColor(Color.DARK_GRAY);
        g.fillOval(850, 585, 75, 75);
        
        // Puedes agregar más elementos aquí, como líneas, texto, etc.
    }
}
