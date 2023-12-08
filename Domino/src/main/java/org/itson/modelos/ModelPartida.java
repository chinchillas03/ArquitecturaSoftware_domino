/**
 * ModelTablero.java
 * Oct 18, 2023 11:37:35 PM
 */
package org.itson.Modelos;

import com.itson.dominio.Ficha;
import com.itson.dominio.Jugador;
import com.itson.dominio.Partida;
import com.itson.dominio.PosicionFicha;
import com.itson.interfaces.IPartidaJuego;
import java.util.ArrayList;
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
    private boolean PartidaTerminada=false;

    /**
     * Constructor por defecto de la clase ModelTablero.
     */
    public ModelPartida() {
        this.partida = Partida.instancia();
                listaJugadores = partida.getJugadores();
    }

    public boolean isPartidaTerminada() {
        return PartidaTerminada;
    }

    public void setPartidaTerminada(boolean PartidaTerminada) {
        this.PartidaTerminada = PartidaTerminada;
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

    public boolean posicionarFicha(Ficha ficha, PosicionFicha lado) {
     
        if (partida.posicionarFicha(ficha, lado)) {
            if (partida.getJugadorTurno().verificarNumFichas()!=0) {
                pasarTurno();
            } else {
                terminarPartida();
                PartidaTerminada=true;
        }
            return true;
    }
        return false;
    }

    public void pasarTurno() {
        partida.pasarTurno();
    }

    public IPartidaJuego iniciarPartida(List<Jugador> jugadores) {
        this.partida = Partida.instancia();
        partida.iniciarPartida(jugadores);
        return partida;
    }

    public void terminarPartida() {
        partida.terminarJuego();
    }

}
