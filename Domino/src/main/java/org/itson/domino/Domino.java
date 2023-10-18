/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.itson.domino;

import com.itson.presentadores.PresentadorInicio;
import javax.swing.SwingUtilities;
import org.itson.frames.FrmInicio;

/**
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public class Domino {

    public Domino (){
        final FrmInicio inicio = new FrmInicio();
        new PresentadorInicio(inicio);
    }
    
    public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Domino();
            }
        });
    }
}
