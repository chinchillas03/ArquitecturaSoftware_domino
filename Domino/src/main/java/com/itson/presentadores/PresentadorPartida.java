/**
 * PresentadorPartida.java
 * Oct 18, 2023 11:29:18 PM
 */
package com.itson.presentadores;

import com.itson.dominio.Jugador;
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
//        frmTablero=new FrmTablero();
    }

    public void posicionarFicha() {
        modelTablero.posicionarFicha();
    }

    public void jalarPozo(Jugador jugador) {
        modelTablero.jalarPozo( jugador);
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
    public void iniciarPartida()
}
