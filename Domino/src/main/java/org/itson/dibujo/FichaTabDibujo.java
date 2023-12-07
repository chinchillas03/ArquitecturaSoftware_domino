/**
 * FichaTabDibujo.java
 * Oct 18, 2023 11:03:30 PM
 */
package org.itson.dibujo;

import com.itson.dominio.FichaTablero;
import com.itson.dominio.PosicionFicha;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

/**
 *
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public class FichaTabDibujo extends Figuras {

    private int x, y;
    private List<FichaTablero> fichasTablero;
    private int ladoDerecho;
    private int ladoIzquierdo;
    
    public FichaTabDibujo(int x, int y, List<FichaTablero> fichasTablero) {
        this.x = x;
        this.y = y;
        this.fichasTablero = fichasTablero;
    }

    public int getLadoDerecho() {
        return ladoDerecho;
    }

    public void setLadoDerecho(int ladoDerecho) {
        this.ladoDerecho = ladoDerecho;
    }

    public int getLadoIzquierdo() {
        return ladoIzquierdo;
    }

    public void setLadoIzquierdo(int ladoIzquierdo) {
        this.ladoIzquierdo = ladoIzquierdo;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<FichaTablero> getFichasTablero() {
        return fichasTablero;
    }

    public void setFichasTablero(List<FichaTablero> fichasTablero) {
        if (!fichasTablero.equals(this.fichasTablero)) {
                  this.fichasTablero = fichasTablero;
    }
    }
    
    @Override
    public void dibujar(Graphics g) {
        y=180;
        x=370;
        for (int i = 0; i < fichasTablero.size(); i++) {
            if (fichasTablero.get(i).getLado()!=null) {
                ordenarFichas(fichasTablero,i);
            }
            if (fichasTablero.get(i).esMula()) {
                x += 24;
                g.setColor(Color.WHITE);
                g.fillRect(x, y, 25, 50);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, 25, 50);
                g.drawLine(x, y + 25, x + 25, y + 25);
                drawVerticalDots(g, fichasTablero.get(i).getValorIzquierdo(), x + 3, y + 3);
                drawVerticalDots(g, fichasTablero.get(i).getValorDerecho(), x + 3, y + 25);
                x+=10;
            } else {
                x += 24;
                g.setColor(Color.WHITE);
                g.fillRect(x, y + 15, 50, 25);
                g.setColor(Color.BLACK);
                g.drawRect(x, y + 15, 50, 25);
                g.drawLine(x + 25, y + 15, x + 25, y + 40);
                drawDots(g, this.getLadoIzquierdo(), x + 3, y + 18); // Ajusta las coordenadas de los puntos según la posición y
                drawDots(g, this.getLadoDerecho(), x + 25, y + 18); // Ajusta las coordenadas de los puntos según la posición y
                x += 28;

            }

        }
    }

    private void ordenarFichas(List<FichaTablero> fichasTablero,int i) {
        if (fichasTablero.get(i).getValorDerecho()!=fichasTablero.get(i).getValorIzquierdo()) {
            this.setLadoDerecho(fichasTablero.get(i).getValorIzquierdo());
            this.setLadoIzquierdo(fichasTablero.get(i).getValorDerecho());
        }else{
            this.setLadoDerecho(fichasTablero.get(i).getValorDerecho());
            this.setLadoIzquierdo(fichasTablero.get(i).getValorIzquierdo());
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

    private void drawDots(Graphics g, int dots, int x, int y) {
        switch (dots) {
            case 0:
                break;
            case 1:
                drawDot(g, x + 10, y + 6);
                break;
            case 2:
                drawDot(g, x + 5, y + 5);
                drawDot(g, x + 15, y + 10);
                break;
            case 3:
                drawDot(g, x + 3, y + 3);
                drawDot(g, x + 10, y + 6);
                drawDot(g, x + 17, y + 10);
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
