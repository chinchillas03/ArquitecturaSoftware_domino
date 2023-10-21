/**
* Dibujante.java
* Oct 18, 2023 11:03:11 PM
*/ 

package org.itson.dibujo;

import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * 
 * @author Joel Antonio Lopez Cota ID:228926 
 */
public class Dibujante  {
    JPanel panel;
    /**
     * 
     */
    public Dibujante(){
        
    }

    public Dibujante(JPanel panel) {
        this.panel = panel;
    }
    
    
    public void dibujarTodos(List<Figuras>listaFiguras){
        Graphics g=panel.getGraphics();
        for (Figuras listaFigura : listaFiguras) {
            listaFigura.dibujar(g,panel);
        }
    }
}
