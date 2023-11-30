/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import com.itson.interfaces.IPartidaJuego;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Partida implements IPartidaJuego {
    private static Partida instanciaPartida;
    private Pozo pozo;
    private List<Jugador> listaJugadores;
    private int numCantidadFichas;
    private Tablero tablero;
    private int turno;
    private List<Ficha> listaFichas;

    private Partida() {
    }
    public static Partida instancia(){
        if (instanciaPartida==null) {
            instanciaPartida=new Partida();
        }
        return instanciaPartida;
    }
    
    
    public void guardarPartida(List<Jugador> jugadores, int numCantidadFichas){
         this.listaJugadores = jugadores;
        this.numCantidadFichas = numCantidadFichas;
        this.tablero=new Tablero();
        this.pozo=new Pozo();
                this.listaFichas = new ArrayList<>();

                turno=0;

    }
    @Override
    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
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
        return listaJugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.listaJugadores = jugadores;
    }

    public void pasarTurno() {
        turno++;
        if (turno==this.getJugadores().size()) {
            turno=0;
        }
    }

    public void terminarJuego() {
        int contadorPuntos=0;
        for (int i = 0; i < listaJugadores.size(); i++) {
            for (int j = 0; j < listaJugadores.get(i).getFichasJuego().size()-1; j++) {
                if ( listaJugadores.get(i).getFichasJuego().size()==0) {
                    break; 
                }
                contadorPuntos+=listaJugadores.get(i).getFichasJuego().get(j).getValorDerecho()
                        +listaJugadores.get(i).getFichasJuego().get(j).getValorIzquierdo();
            }
            listaJugadores.get(i).setPuntuacion(contadorPuntos);
        }
        this.ordenarListaPorPuntos(listaJugadores);
    }
    private void ordenarListaPorPuntos(List<Jugador> jugadores){
        for (int i = 0; i < jugadores.size(); i++) {
            for (int j = i + 1; j < jugadores.size(); j++) {
                if (jugadores.get(i).getPuntuacion() < jugadores.get(j).getPuntuacion()) {
                    Jugador jugadorTemp = jugadores.get(i);
                    jugadores.set(i, jugadores.get(j));
                    jugadores.set(j, jugadorTemp);
                }
            }
        }
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
        return "Partida{" + "pozo=" + pozo + ", jugadores=" + listaJugadores + ", numCantidadFichas=" + numCantidadFichas + ", tablero=" + tablero + '}';
    }

    public boolean posicionarFicha(Ficha fichaNva,int lado) {
       FichaTablero fichaTab = fichaNva.convertirFichaTab();
       fichaTab.setLado(lado);
        if (this.getTablero() == null) {
            this.setTablero(new Tablero());
        }
        if (this.getTablero().verificaFicha(fichaTab)) {
            this.getTablero().addFicha(fichaTab);
            this.getJugadores().get(this.getTurno()).quitarFicha(fichaNva);
            if (listaJugadores.get(this.getTurno()).verificarNumFichas() != 0) {
                this.pasarTurno();
            } else {
                this.terminarJuego();
               return true;
            }
        } else {
        }
    return false;
    }
    public void iniciarPartida(List<Jugador> jugadores, int cantidadFichas) {
        this.guardarPartida(jugadores, cantidadFichas);
        repartirFichas();
        setearTurnos();
    }

    private Jugador primerTurno() {
        Jugador primerTurno = listaJugadores.get(0);
        for (int i = 0; i < listaJugadores.size(); i++) {
            if (listaJugadores.get(i).getMulaMasAlta() != null) {
                primerTurno = listaJugadores.get(i);
                if (listaJugadores.get(i).getMulaMasAlta().getValorDerecho() >= primerTurno.getMulaMasAlta().getValorDerecho()) {
                    primerTurno = listaJugadores.get(i);
                }
            }
        }
        return primerTurno;
    }

    private void setearTurnos() {
        Jugador jugadorConMulaMasAlta = primerTurno();
        System.out.println("El jugador con la mula más alta es " + jugadorConMulaMasAlta.getNombre() + jugadorConMulaMasAlta.getMulaMasAlta());
        System.out.println(jugadorConMulaMasAlta);
        // Remover al jugador con la mula más alta
        listaJugadores.remove(jugadorConMulaMasAlta);

        // Mezclar aleatoriamente a los jugadores restantes
        Collections.shuffle(listaJugadores);

        // Agregar al jugador con la mula más alta al principio de la lista
        listaJugadores.add(0, jugadorConMulaMasAlta);

        // Imprimir el orden de los turnos
        for (int i = 0; i < listaJugadores.size(); i++) {
            System.out.println("Turno " + (i + 1) + ": " + listaJugadores.get(i).getNombre());
        }
    }
      /**
     * Genera y devuelve una lista de fichas para un juego de dominó.
     *
     * @return La lista de fichas generadas.
     */
    //Responsabilidad del dominio
    private List<Ficha> generaFichasDomino() {
        listaFichas = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                Ficha domino = new Ficha(i, j);
                listaFichas.add(domino);
            }
        }
        return listaFichas;
    }

    //Responsabilidad del dominio partida
    private List<Jugador> repartirFichas() {
        List<Ficha> fichas = generaFichasDomino();
        Collections.shuffle(fichas);
        Collections.shuffle(fichas);
        for (int i = 0; i < this.listaJugadores.size(); i++) {
            List<FichaJuego> mano = new ArrayList<>();
            for (int j = 0; j < this.numCantidadFichas; j++) {
                mano.add(fichas.remove(0).convertirFichaJuego());
            }
           listaJugadores.get(i).setFichas(mano);
        }
        Pozo pozo = new Pozo(fichas);
        this.setPozo(pozo);
        return listaJugadores;
    }

    public boolean jalarPozo(Jugador jugador) {
         List<Ficha> listaPozo = this.getPozo().getFichas();
        System.out.println(listaPozo);
        if (!this.getPozo().getFichas().isEmpty()) {
            List<FichaJuego> listaNueva = jugador.getFichasJuego();
            listaNueva.add(listaPozo.get(0).convertirFichaJuego());
            jugador.setFichas(listaNueva);
            this.getPozo().getFichas().remove(listaPozo.get(0));
            return true;
        }
        return false;
    }
}
