/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.presentadores;

import com.itson.dominio.Jugador;
import com.itson.listeners.PuntuacionesListener;
import java.util.List;
import org.itson.Modelos.ModelPuntuaciones;
import org.itson.frames.FrmPuntuaciones;

/**
 *
 * @author Usuario
 */
public class PresentadorPuntuaciones implements PuntuacionesListener{

    private final FrmPuntuaciones view = new FrmPuntuaciones();
    private final ModelPuntuaciones model = new ModelPuntuaciones();

    /**
     * Constructor de la clase PresentadorPuntuaciones.
     * Inicializa la clase y se suscribe a los eventos de la vista de puntuaciones.
     */
    public PresentadorPuntuaciones() {
         this.view.setListener(this);
    }

    /**
     * Maneja el evento de hacer clic en el botón "Salir" en la pantalla de puntuaciones.
     * Cierra la pantalla de puntuaciones y muestra la pantalla de inicio.
     */
    @Override
    public void clickBotonSalir() {
        this.cerrarPantallaPuntuaciones();
        new PresentadorInicio().mostrarPantallaInicio();
    }
    /**
     * Muestra la pantalla de puntuaciones.
     */
    public void mostrarPantallaPuntuaciones() {
        this.view.mostrarPantallaPuntuaciones();
    }

    /**
     * Cierra la pantalla de puntuaciones.
     */
    public void cerrarPantallaPuntuaciones() {
        this.view.cerrarPantallaPuntuaciones();
    }
    

    /**
     * Establece el modelo de puntuaciones con una lista de jugadores.
     *
     * @param jugadores La lista de jugadores cuyas puntuaciones se mostrarán en la pantalla de puntuaciones.
     */
    public void setModelPuntuaciones(List<Jugador> jugadores) {
        this.model.setJugadores(jugadores);
        jugadores = this.model.getJugadores();
        this.view.setLblNombreJugador1(jugadores.get(0).getNombre());
        this.view.setLblNombreJugador2(jugadores.get(1).getNombre());
        this.view.setLblNombreJugador3(jugadores.get(2).getNombre());
        this.view.setLblNombreJugador4(jugadores.get(3).getNombre());
        System.out.println(this.model.getJugadores());
    }
    
}
