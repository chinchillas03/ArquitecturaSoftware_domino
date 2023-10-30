/**
* FichaJugDibujo.java
* Oct 18, 2023 11:03:40 PM
*/ 

package org.itson.dibujo;

import com.itson.dominio.FichaJuego;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * 
 * @author Joel Antonio Lopez Cota ID:228926 
 */
public class FichaJugDibujo extends Figuras {
   private int x,y;
   private List<FichaJuego> fichasJugador;
    /**
     * 
     */


    public FichaJugDibujo(int x, int y, List<FichaJuego> fichasJugador) {
        this.x = x;
        this.y = y;
        this.fichasJugador = fichasJugador;
    }
    
    @Override
    public void dibujar(Graphics g) {
        for (int i = 0; i < fichasJugador.size(); i++) {
            fichasJugador.get(i).setX(this.x);
            fichasJugador.get(i).setY(this.y);
             g.setColor(Color.WHITE);
                g.fillRect(x, y, 25, 50);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, 25, 50);
                g.drawLine(x, y + 25, x + 25, y + 25);
                drawVerticalDots(g, fichasJugador.get(i).getValorIzquierdo(), x + 3, y + 3);
                drawVerticalDots(g, fichasJugador.get(i).getValorDerecho(), x + 3, y + 25);
                x+=30;
        }
    }
    
     private void drawVerticalDots(Graphics g, int dots, int x, int y) {
        switch (dots) {
            case 0:
                break;
            case 1:
                drawDot(g, x + 8, y + 9);
                break;
            case 2:
                drawDot(g, x + 3, y + 5);
                drawDot(g, x + 15, y + 10);
                break;
            case 3:
                drawDot(g, x + 2, y + 3);
                drawDot(g, x + 8, y + 9);
                drawDot(g, x + 15, y + 15);
                break;
            case 4:
                drawDot(g, x + 3, y + 3);
                drawDot(g, x + 17, y + 3);
                drawDot(g, x + 3, y + 10);
                drawDot(g, x + 17, y + 10);
                break;
            case 5:
                drawDot(g, x + 3, y + 3);
                drawDot(g, x + 17, y + 2);
                drawDot(g, x + 10, y + 6);
                drawDot(g, x + 3, y + 10);
                drawDot(g, x + 17, y + 10);
                break;
            case 6:
                drawDot(g, x + 3, y + 1);
                drawDot(g, x + 17, y + 1);
                drawDot(g, x + 3, y + 7);
                drawDot(g, x + 17, y + 7);
                drawDot(g, x + 3, y + 13);
                drawDot(g, x + 17, y + 13);
        }
    }
      private void drawDot(Graphics g, int x, int y) {
        g.fillOval(x, y, 4, 4);
    }
}
