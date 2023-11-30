/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.listeners;

import com.itson.dominio.Ficha;
import com.itson.dominio.Jugador;
import com.itson.dominio.Partida;
import com.itson.interfaces.IPartidaJuego;

/**
 *
 * @author Usuario
 */
public interface TableroJuegoListener {
    
    /**
     * Este método se llama cuando el usuario hace clic en el botón "Abandonar Partida" en el tablero de juego.
     * Permite al usuario abandonar la partida en curso
     */
    void clickBotonAbandonarPartida();
    
    /**
     * Este método se llama cuando el usuario intenta posicionar una ficha en el tablero de juego.Gestiona la acción de colocar una ficha en una posición específica del tablero.
     */
    void posicionarFicha(Ficha ficha, int lado);

    /**
     * Este método se llama cuando el usuario decide jalar una ficha del pozo en el tablero de juego.
     *
     * @param jugador El jugador que realiza la acción de jalar una ficha del pozo.
     */
    void jalarPozo(Jugador jugador);
   
    /**
     * Actualiza la pantalla del tablero de juego para reflejar cambios recientes en la partida.
     * @param partida
     */
    void actualizarPantalla(); 

    /**
     * Muestra un mensaje de error o notificación en el tablero de juego.
     */
    void mostrarMsgError(String mensaje);

   

    /**
     * Permite al jugador pasar su turno en el juego, pasando al siguiente jugador en la secuencia.
     */
    void pasarTurno();   
    
}
