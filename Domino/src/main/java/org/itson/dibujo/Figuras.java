/**
* Figuras.java
* Oct 18, 2023 11:01:51 PM
*/ 

package org.itson.dibujo;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * 
 * @author Joel Antonio Lopez Cota ID:228926 
 */
public abstract class Figuras extends JPanel{
    public abstract void dibujar(Graphics g,JPanel panel);
}
