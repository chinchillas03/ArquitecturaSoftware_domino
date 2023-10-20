/**
* JugadorDibujo.java
* Oct 20, 2023 1:59:36 AM
*/ 

package org.itson.dibujo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

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
    public void dibujar(Graphics g, JPanel jpanel) {
        System.out.println("soy la ficha");
        g.setColor(color);
        g.fillOval(x, y, width, height); }
}
