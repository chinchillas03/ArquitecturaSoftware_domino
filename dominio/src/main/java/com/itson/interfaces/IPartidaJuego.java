/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.interfaces;

import com.itson.dominio.Jugador;
import com.itson.dominio.Pozo;
import com.itson.dominio.Tablero;
import java.util.List;

/**
 *
 * @author aroco
 */
public interface IPartidaJuego {

    int getNumCantidadFichas();

    Tablero getTablero();

    Pozo getPozo();

    List<Jugador> getJugadores();

    int getTurno();

}
