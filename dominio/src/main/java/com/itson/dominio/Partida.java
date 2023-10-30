/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Partida {
    
    private Pozo pozo;
    private List<Jugador> jugadores;
    private int numCantidadFichas;

    public int getNumCantidadFichas() {
        return numCantidadFichas;
    }

    public void setNumCantidadFichas(int numCantidadFichas) {
        this.numCantidadFichas = numCantidadFichas;
    }
    public Partida() {
    }

    public Partida(List<Jugador> jugadores, int numCantidadFichas) {
        this.jugadores = jugadores;
        this.numCantidadFichas = numCantidadFichas;
    }

    public Partida(Pozo pozo, List<Jugador> jugadores) {
        this.pozo = pozo;
        this.jugadores = jugadores;
    }

    public Pozo getPozo() {
        return pozo;
    }

    public void setPozo(Pozo pozo) {
        this.pozo = pozo;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    public void pasarTurno(){
        
    }
    public void terminarJuego(){
        
    }
    
}
