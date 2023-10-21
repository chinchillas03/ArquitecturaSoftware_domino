/**
 * PresentadorPartida.java
 * Oct 18, 2023 11:29:18 PM
 */
package com.itson.presentadores;

import com.itson.dominio.Jugador;
import com.itson.listeners.TableroJuegoListener;
import java.util.List;
import org.itson.Modelos.ModelTablero;
import org.itson.dibujo.Dibujante;
import org.itson.dibujo.Figuras;
import org.itson.frames.FrmPartida;
import org.itson.frames.FrmTablero;

/**
 *
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public class PresentadorPartida implements TableroJuegoListener {

    private final FrmPartida view = new FrmPartida();
    private final ModelTablero model = new ModelTablero();

    /**
     * Constructor de la clase PresentadorPartida. Inicializa la clase y se
     * suscribe a los eventos de la vista de partida.
     */
    public PresentadorPartida() {
        this.suscribirseListener();
    }

    /**
     * Maneja el evento de hacer clic en el botón "Abandonar Partida" en la
     * pantalla de partida. Cierra la pantalla de partida y muestra la pantalla
     * de puntuaciones, además de proporcionar información sobre la partida
     * actual.
     */
    @Override
    public void clickBotonAbandonarPartida() {
        this.cerrarPantallaPartida();
        PresentadorPuntuaciones presenter = new PresentadorPuntuaciones();
        presenter.mostrarPantallaPuntuaciones();
        presenter.setModelPuntuaciones(this.model.getListaJugadores());
    }

    /**
     * Maneja el evento de posicionar una ficha en el juego. Lleva a cabo la
     * lógica para posicionar una ficha en el tablero de juego.
     */
    @Override
    public void posicionarFicha() {
        this.model.posicionarFicha();
    }

    /**
     * Maneja el evento de jalar fichas del pozo. Realiza la lógica para que un
     * jugador pueda jalar fichas del pozo en el juego.
     *
     * @param jugador El jugador que intenta jalar fichas del pozo.
     */
    @Override
    public void jalarPozo(Jugador jugador) {
        this.model.jalarPozo(jugador);
    }

    /**
     * Actualiza la pantalla de partida con la información más reciente del
     * juego.
     */
    @Override
    public void actualizarPantalla() {
        // Actualiza la pantalla de partida con la información más reciente del juego.
    }

    /**
     * Muestra un mensaje de error en la pantalla de partida.
     */
    @Override
    public void mostrarMsgError() {
        // Muestra un mensaje de error en la pantalla de partida.
    }

    /**
     * Muestra una ficha en la pantalla de partida.
     */
    @Override
    public void mostrarFicha() {
        // Muestra una ficha en la pantalla de partida.
    }

    /**
     * Maneja el evento de pasar el turno a otro jugador en la partida. Realiza
     * la lógica para cambiar el turno de juego.
     */
    @Override
    public void pasarTurno() {
        this.model.pasarTurno();
    }

    /**
     * Registra el presentador como listener de eventos en la vista de partida.
     */
    private void suscribirseListener() {
        this.view.addListener(this);
    }

    /**
     * Muestra la pantalla de partida.
     */
    public void mostrarPantallaPartida() {
        this.view.mostrarPantallaPartida();
    }

    /**
     * Cierra la pantalla de partida.
     */
    public void cerrarPantallaPartida() {
        this.view.cerrarPantallaPartida();
    }

    /**
     * Establece el modelo de partida con una lista de jugadores.
     *
     * @param jugadores La lista de jugadores que participan en la partida.
     */
    public void setModelPartida(List<Jugador> jugadores) {
        this.model.setListaJugadores(jugadores);
        jugadores = this.model.getListaJugadores();
        this.view.setLblNombreJugador1(jugadores.get(0).getNombre());
        this.view.setLblNombreJugador2(jugadores.get(1).getNombre());
        this.view.setLblNombreJugador3(jugadores.get(2).getNombre());
        this.view.setLblNombreJugador4(jugadores.get(3).getNombre());
    }

    /**
     * Establece la cantidad de fichas en el juego.
     *
     * @param cantidadFichas La cantidad de fichas en el juego.
     */
    public void setCantidadFichas(int cantidadFichas) {
        this.model.setCantidadFichas(cantidadFichas);
    }
}