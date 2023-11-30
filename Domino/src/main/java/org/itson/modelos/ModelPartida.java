/**
 * ModelTablero.java
 * Oct 18, 2023 11:37:35 PM
 */
package org.itson.Modelos;

import com.itson.dominio.Ficha;
import com.itson.dominio.FichaJuego;
import com.itson.dominio.FichaTablero;
import com.itson.dominio.Jugador;
import com.itson.dominio.Partida;
import com.itson.dominio.Pozo;
import com.itson.dominio.Tablero;
import com.itson.interfaces.IPartidaJuego;
import com.itson.presentadores.PresentadorPartida;
import com.itson.presentadores.PresentadorPuntuaciones;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public class ModelPartida {

    private List<Jugador> listaJugadores;
    private int cantidadFichas;
    private Partida partida;

    /**
     * Constructor por defecto de la clase ModelTablero.
     */
    public ModelPartida() {
        listaJugadores = new ArrayList<>();
        this.partida = Partida.instancia();
    }

    /**
     * Obtiene la cantidad de fichas en el tablero.
     *
     * @return La cantidad de fichas en el tablero.
     */
    public int getCantidadFichas() {
        return cantidadFichas;
    }

    /**
     * Establece la cantidad de fichas en el tablero.
     *
     * @param cantidadFichas La cantidad de fichas que se desea configurar en el
     * tablero.
     */
    public void setCantidadFichas(int cantidadFichas) {
        this.cantidadFichas = cantidadFichas;
    }

    /**
     * Obtiene la lista de jugadores en el juego.
     *
     * @return La lista de jugadores en el juego.
     */
    public List<Jugador> getListaJugadores() {
        return partida.getJugadores();
    }

    /**
     * Establece la lista de jugadores en el juego.
     *
     * @param listaJugadores La lista de jugadores que se desea configurar en el
     * juego.
     */
    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }


    public boolean jalarPozo(Jugador jugador) {
      return partida.jalarPozo(jugador);
      
    }

    public boolean posicionarFicha(Ficha ficha, int lado) {
     return partida.posicionarFicha(ficha,lado);
    }

    public void pasarTurno() {
        partida.pasarTurno();
    }

    public IPartidaJuego iniciarPartida(List<Jugador> jugadores, int cantidadFichas) {
        this.partida = Partida.instancia();
        partida.iniciarPartida(jugadores, cantidadFichas);
        return partida;
    }

    public void terminarPartida() {
    partida.terminarJuego();
    }

   


}
