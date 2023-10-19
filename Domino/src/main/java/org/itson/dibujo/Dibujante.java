/**
* Dibujante.java
* Oct 18, 2023 11:03:11 PM
*/ 

package org.itson.dibujo;

/**
 *
 * 
 * @author Joel Antonio Lopez Cota ID:228926 
 */
public class Dibujante {
    
    /**
     * 
     */
    public Dibujante(){
        
    }
    
    public void dibujarTodos(Figuras[] listaFiguras){
        for (Figuras listaFigura : listaFiguras) {
            listaFigura.dibujar();
        }
    }
}
