/**
 * PresentadorPartida.java
 * Oct 18, 2023 11:29:18 PM
 */
package com.itson.presentadores;

import com.itson.dominio.FichaJuego;
import com.itson.dominio.Jugador;
import java.util.List;
import org.itson.Modelos.ModelTablero;
import org.itson.dibujo.Dibujante;
import org.itson.dibujo.Figuras;
import org.itson.frames.FrmTablero;

/**
 *
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public class PresentadorPartida {
    FrmTablero frmTablero;
    ModelTablero modelTablero;
    
    /**
     *
     */
    public PresentadorPartida(){
        this.modelTablero = new ModelTablero();

    }

    public void posicionarFicha() {
        modelTablero.posicionarFicha();
    }

    public boolean jalarPozo(Jugador jugador) {
       return modelTablero.jalarPozo( jugador);
    }

    public void actualizarPantalla() {
//        frmTablero.actualizarPantalla();
    }

    public void mostrarMsgError() {
//        frmTablero.mostrarMsgError();
    }

    public void mostrarFicha() {
//        frmTablero.mostrarFicha();
    }

    public void pasarTurno() {
        modelTablero.pasarTurno();
    }

    public void iniciarPartida(List<Jugador> listaJugadores, int cantidadFichas) {
        modelTablero.iniciarPartida(listaJugadores, cantidadFichas);
    }

    public List<FichaJuego> recuperaListaJugadores() {
       return modelTablero.recuperaListaJugadores();
    }
}
