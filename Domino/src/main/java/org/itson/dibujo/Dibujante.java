/**
 * Dibujante.java
 * Oct 18, 2023 11:03:11 PM
 */
package org.itson.dibujo;

import com.itson.interfaces.IPartidaJuego;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import org.itson.dibujo.FichaTabDibujo;

/**
 *
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public class Dibujante {

    private List<Figuras> listaFiguras;
    private FichaTabDibujo fichasTab;

    /**
     *
     */
    public Dibujante() {
        listaFiguras = new ArrayList<>();
        fichasTab = new FichaTabDibujo(512, 340, new ArrayList<>());

    }

    public void crearLista(IPartidaJuego partida) {
        listaFiguras.removeAll(listaFiguras);
        listaFiguras.add(new FichaJugDibujo(100, 715, partida.getJugadores().get(partida.getTurno()).getFichasJuego()));
        if (!partida.getTablero().verificaCantidadFichas()) {
            fichasTab.setFichasTablero(partida.getTablero().getFichas());
            listaFiguras.add(fichasTab);
        }
    }

    public void dibujarTodos(Graphics g, Graphics g2) {
        for (Figuras listaFigura : listaFiguras) {
            if (listaFigura instanceof FichaTabDibujo) {
                listaFigura.dibujar(g2);
            } else {
                listaFigura.dibujar(g);

            }
        }
    }
}
