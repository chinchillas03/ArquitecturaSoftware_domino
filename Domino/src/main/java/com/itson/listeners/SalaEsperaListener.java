/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.listeners;

/**
 *
 * @author Usuario
 */
public interface SalaEsperaListener {
    
    /**
     * Este método se llama cuando el usuario hace clic en el botón "Iniciar Partida" en la sala de espera.
     * Inicia la partida y permite a los jugadores comenzar el juego.
     */
    void clickBotonIniciarPartida();
    
    /**
     * Este método se llama cuando el usuario hace clic en el botón "Salir de la Partida" en la sala de espera.
     * Permite al usuario salir de la sala de espera y regresar a la pantalla principal o a otra ubicación relevante.
     */
    void clickBotonSalirPartida();
    
    /**
     * Este método se llama para mostrar la lista de jugadores en la sala de espera.
     * Actualiza la información de los jugadores presentes en la sala de espera.
     */
    void mostrarJugadores();
    
}
