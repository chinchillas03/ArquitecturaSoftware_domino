/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import com.itson.interfaces.IPartidaJuego;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Partida implements IPartidaJuego {
    private static Partida instanciaPartida;
    private Pozo pozo;
    private List<Jugador> jugadores;
    private int numCantidadFichas;
    private Tablero tablero;

    private Partida() {
    }
    public static Partida instancia(){
        if (instanciaPartida==null) {
            instanciaPartida=new Partida();
        }
        return instanciaPartida;
    }
    
    
    public void GuardarPartida(List<Jugador> jugadores, int numCantidadFichas){
         this.jugadores = jugadores;
        this.numCantidadFichas = numCantidadFichas;
        this.tablero=new Tablero();
        this.pozo=new Pozo();
    }
    
    @Override
    public int getNumCantidadFichas() {
        return numCantidadFichas;
    }

    public void setNumCantidadFichas(int numCantidadFichas) {
        this.numCantidadFichas = numCantidadFichas;
    }

    @Override
    public Pozo getPozo() {
        return pozo;
    }

    public void setPozo(Pozo pozo) {
        this.pozo = pozo;
    }

    @Override
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void pasarTurno() {

    }

    public void terminarJuego() {

    }

    @Override
    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public String toString() {
        return "Partida{" + "pozo=" + pozo + ", jugadores=" + jugadores + ", numCantidadFichas=" + numCantidadFichas + ", tablero=" + tablero + '}';
    }
    
}
