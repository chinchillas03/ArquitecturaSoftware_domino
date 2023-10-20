/**
* TableroDibujo.java
* Oct 18, 2023 11:03:03 PM
*/ 

package org.itson.dibujo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * 
 * @author Joel Antonio Lopez Cota ID:228926 
 */
public class TableroDibujo extends Figuras {
    public int x;
    public int y;
    public int HEIGHT;
    public int WIDTH;
    /**
     * 
     */
    public TableroDibujo(){
        
    }

   

    @Override
    public void dibujar(Graphics g,JPanel jpanel) {
       JPanel tablero=new JPanel();
        tablero.setBackground(Color.GREEN);
        JScrollPane jscp = new JScrollPane(tablero); 
        jpanel.add(jscp);
    }
}
