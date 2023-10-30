/**
* Dibujante.java
* Oct 18, 2023 11:03:11 PM
*/ 

package org.itson.dibujo;

import com.itson.dominio.FichaJuego;
import com.itson.dominio.Partida;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 * @author Joel Antonio Lopez Cota ID:228926 
 */
public class Dibujante  {
    private List<Figuras> listaFiguras;
    /**
     * 
     */
    public Dibujante(){
        listaFiguras=new ArrayList<>();
    }

   private void crearLista(Partida partida){
       listaFiguras.removeAll(listaFiguras);
       listaFiguras.add(new JugadorDibujo(15,705,Color.RED));
       listaFiguras.add(new JugadorDibujo(15,45,Color.BLUE));
       listaFiguras.add(new JugadorDibujo(1000,45,Color.RED));
       listaFiguras.add(new JugadorDibujo(1000,705,Color.RED));
       listaFiguras.add(new FichaJugDibujo(100,715,partida.getJugadores().get(0).getFichas()));
       System.out.println(partida.getJugadores().get(0).getFichas());
   }
    
    public void dibujarTodos(Partida partida, Graphics g){
        crearLista(partida);
        for (Figuras listaFigura : listaFiguras) {
            listaFigura.dibujar(g);
        }
    }
}
