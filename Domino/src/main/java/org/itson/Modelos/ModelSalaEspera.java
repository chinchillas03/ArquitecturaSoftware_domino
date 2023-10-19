/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.Modelos;

import com.itson.dominio.Avatar;
import com.itson.dominio.Jugador;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ModelSalaEspera {
    
    private List<Jugador> jugadores;
    private List<Avatar> avatares;

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Avatar> getAvatares() {
        return avatares;
    }

    public void setAvatares(List<Avatar> avatares) {
        this.avatares = avatares;
    }
    
}
