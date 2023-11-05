/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.presentadores;

import com.itson.dominio.Avatar;
import com.itson.interfacesJugador.JugadorSala;
import com.itson.listeners.SalaEsperaListener;
import java.util.LinkedList;
import java.util.List;
import org.itson.Modelos.ModelSalaEspera;
import org.itson.frames.FrmSalaEspera;

/**
 *
 * @author Usuario
 */
public class PresentadorSalaEspera implements SalaEsperaListener{

    private final FrmSalaEspera view = new FrmSalaEspera();
    private final ModelSalaEspera model = new ModelSalaEspera();
    
    /**
     * Constructor de la clase PresentadorSalaEspera.
     * Inicializa la clase, se suscribe a los eventos de la vista de sala de espera, configura a los jugadores y muestra la lista de jugadores.
     */
    public PresentadorSalaEspera() {
        this.model.setModel();
        this.mostrarJugadores();
        this.setPresenter();
    }

    /**
     * Maneja el evento de hacer clic en el botón "Iniciar Partida" en la sala de espera.
     * Cierra la pantalla de sala de espera y muestra la pantalla de partida, pasando la información de los jugadores y la cantidad de fichas.
     */
    @Override
    public void clickBotonIniciarPartida() {
        this.cerrarPantallaSalaEspera();
        PresentadorPartida presentador = new PresentadorPartida();
        //presentador.setModelPartida(new Partida(this.model.getJugadores(),5));
    }

    /**
     * Maneja el evento de hacer clic en el botón "Salir de la Partida" en la sala de espera.
     * Cierra la pantalla de sala de espera y vuelve a la pantalla de inicio.
     */
    @Override
    public void clickBotonSalirPartida() {
        this.cerrarPantallaSalaEspera();
        new PresentadorInicio().mostrarPantallaInicio();
    }

    /**
     * Muestra la lista de jugadores en la sala de espera.
     */
    @Override
    public void mostrarJugadores() {
        List<JugadorSala> jugadores = new LinkedList<>();
        jugadores = this.model.getJugadores();
        this.view.setLblNombreJugador1(jugadores.get(0).nombre());
        this.view.setLblNombreJugador2(jugadores.get(1).nombre());
        this.view.setLblNombreJugador3(jugadores.get(2).nombre());
        this.view.setLblNombreJugador4(jugadores.get(3).nombre());
        this.cargarCombosAvatares();
    } 
    
    public void cargarCombosAvatares(){
        List<Avatar> avatares = new LinkedList<>();
        avatares = this.model.getAvatares();
        this.view.setCmbAvatarJugador1(avatares);
        this.view.setCmbAvatarJugador2(avatares);
        this.view.setCmbAvatarJugador3(avatares);
        this.view.setCmbAvatarJugador4(avatares);
    }
    
    private void setPresenter(){
        this.view.setListener(this);
    }

    /**
     * Cierra la pantalla de sala de espera.
     */
    public void cerrarPantallaSalaEspera() {
        this.view.cerrarPantallaSalaEspera();
    }
    
    /**
     * Muestra la pantalla de sala de espera.
     */
    public void mostrarPantallaSalaEspera() {
        this.view.mostrarPantallaSalaEspera();
    }

}
