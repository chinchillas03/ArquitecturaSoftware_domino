/**
 * PresentadorPartida.java
 * Oct 18, 2023 11:29:18 PM
 */
package com.itson.presentadores;

import com.itson.dominio.Ficha;
import com.itson.dominio.Jugador;
import com.itson.dominio.PosicionFicha;
import com.itson.listeners.TableroJuegoListener;
import java.util.List;
import org.itson.Modelos.ModelPartida;
import org.itson.frames.FrmPartida;

/**
 *
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public class PresentadorPartida implements TableroJuegoListener {

    private FrmPartida view = new FrmPartida();
    private ModelPartida model = new ModelPartida();

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
        this.model.terminarPartida();
        presenter.setModelPuntuaciones(this.model.getListaJugadores());
    }

    /**
     * Maneja el evento de posicionar una ficha en el juego. Lleva a cabo la
     * lógica para posicionar una ficha en el tablero de juego.
     */
    @Override
    public void posicionarFicha(Ficha fichaJuego,PosicionFicha lado) {
//        if (fichaJuego==null) {
//            this.view.mostrarMsgError("Seleccione una ficha correcta");
//        }
//Mostrar mensaje error ficha
        if (this.model.posicionarFicha(fichaJuego,lado)) {
            //actualizar el modelo de la partida IPartidaJuego
            this.actualizarPantalla();
        }
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
          PresentadorPuntuaciones presenter = new PresentadorPuntuaciones();
          presenter.setModelPuntuaciones(this.model.getListaJugadores());
        presenter.mostrarPantallaPuntuaciones();
    }

    /**
     * Muestra un mensaje de error en la pantalla de partida.
     *
     * @param mensaje es el mensaje del error
     */
    @Override
    public void mostrarMsgError(String mensaje) {
        this.view.mostrarMsgError(mensaje);
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
     *
     * @param partida
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
     * @param partida
     */
    public void setModelPartida(List<Jugador> jugadores) {
        this.view.setPartida(this.model.iniciarPartida(jugadores));
        this.view.setLblNombreJugador1(jugadores.get(0).getNombre());
        this.view.setLblNombreJugador2(jugadores.get(1).getNombre());
        this.view.setLblNombreJugador3(jugadores.get(2).getNombre());
        this.view.setLblNombreJugador4(jugadores.get(3).getNombre());
        this.mostrarPantallaPartida();

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
