/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.Modelos;

import com.itson.dominio.Jugador;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ModelPuntuaciones {
    
    private List<Jugador> jugadores;

    /**
     * Constructor por defecto de la clase ModelPuntuaciones.
     */
    public ModelPuntuaciones() {
        // El constructor por defecto no realiza ninguna acción especial.
    }

    /**
     * Constructor de la clase ModelPuntuaciones que recibe una lista de jugadores.
     * Inicializa la instancia de ModelPuntuaciones con la lista de jugadores proporcionada.
     *
     * @param jugadores La lista de jugadores y sus puntuaciones.
     */
    public ModelPuntuaciones(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Obtiene la lista de jugadores y sus puntuaciones.
     *
     * @return La lista de jugadores y sus puntuaciones.
     */
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Establece la lista de jugadores y sus puntuaciones.
     *
     * @param jugadores La lista de jugadores y sus puntuaciones que se desea configurar.
     */
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
}
