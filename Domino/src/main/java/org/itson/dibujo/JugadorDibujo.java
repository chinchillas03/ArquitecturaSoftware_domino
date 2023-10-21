/**
* JugadorDibujo.java
* Oct 20, 2023 1:59:36 AM
*/ 

package org.itson.dibujo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * 
 * @author Joel Antonio Lopez Cota ID:228926 
 */
public class JugadorDibujo extends Figuras{
    private int x, y, width=75,height=75;
    private Color color;
    public JugadorDibujo(int x, int y,Color color) {
        this.x = x;
        this.y = y;
        this.color=color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void dibujar(Graphics g, JPanel jpanel) {
       super.paintComponent(g);
        g.setColor(color);
        g.fillOval(x, y, width, height); }
}
