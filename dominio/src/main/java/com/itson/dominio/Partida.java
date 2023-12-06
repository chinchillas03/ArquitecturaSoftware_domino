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
    
    public static Partida instancia() {
        if (instanciaPartida == null) {
            instanciaPartida = new Partida();
        }
        return instanciaPartida;
    }
    
    public void crearPartida(int numCantidadFichas) {
        this.numCantidadFichas = numCantidadFichas;
    }
    
    public void guardarPartida(List<Jugador> jugadores) {
        this.listaJugadores = jugadores;
        this.listaFichas = new ArrayList<>();
        turno = 0;
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
        if (turno == this.getJugadores().size()) {
            turno = 0;
        }
    }
    
    public void terminarJuego() {
        //Jugador podra regresar su puntaje
        //Ficha tmbn debe de regresar cuantos puntos
        for (int i = 0; i < listaJugadores.size(); i++) {
            listaJugadores.get(i).calcularPuntos();
        }
        this.ordenarListaPorPuntos();
    }
    
    private void ordenarListaPorPuntos() {
        for (Jugador listaJugadore : listaJugadores) {
            listaJugadore.calcularPuntos();
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
    
    public boolean posicionarFicha(Ficha fichaNva, PosicionFicha lado) {
        FichaTablero fichaTab = fichaNva.convertirFichaTab();
        if (lado == null) {
            tablero.agregarFicha(fichaTab);
            return true;
        }
        fichaTab.setLado(lado);
        
        if (tablero == null) {
            this.setTablero(new Tablero());
        }
        //Modificar para que se ponga la primera
        if (tablero.verificaFicha(fichaTab)) {
            tablero.agregarFicha(fichaTab);
            //Jugador en turno
            listaJugadores.get(this.getTurno()).quitarFicha(fichaNva);
            if (listaJugadores.get(turno).verificarNumFichas() != 0) {
                pasarTurno();
            } else {
                terminarJuego();
                return true;
            }
        }
        return false;
    }
    
    public void iniciarPartida(List<Jugador> jugadores) {
        guardarPartida(jugadores);
        repartirFichas();
        setearTurnos();
         posicionarFicha(jugadores.get(0).getMulaMasAlta(), null);
        jugadores.get(0).quitarFicha(jugadores.get(0).getMulaMasAlta());
    }
    
    private Jugador primerTurno() {
        Jugador primerTurno = listaJugadores.get(0);
        for (int i = 0; i < listaJugadores.size(); i++) {
            if (listaJugadores.get(i).getMulaMasAlta() != null) {
                primerTurno = listaJugadores.get(i);
                if (listaJugadores.get(i).getMulaMasAlta().getValorFicha() > primerTurno.getMulaMasAlta().getValorFicha()) {
                    primerTurno = listaJugadores.get(i);
                }
            }
        }
        return primerTurno;
    }
    
    private void setearTurnos() {
        Jugador jugadorConMulaMasAlta = primerTurno();
        // Remover al jugador con la mula más alta
        listaJugadores.remove(jugadorConMulaMasAlta);

        // Mezclar aleatoriamente a los jugadores restantes
        Collections.shuffle(listaJugadores);
       
        // Agregar al jugador con la mula más alta al principio de la lista
        listaJugadores.add(0, jugadorConMulaMasAlta);
    }

    /**
     * Genera y devuelve una lista de fichas para un juego de dominó.
     *
     * @return La lista de fichas generadas.
     */
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
    
    private List<Jugador> repartirFichas() {
        List<Ficha> fichas = generaFichasDomino();
        Collections.shuffle(fichas);
        Collections.shuffle(fichas);
        for (int i = 0; i < this.listaJugadores.size(); i++) {
            List<FichaJuego> mano =  listaJugadores.get(i).getFichasJuego();
            for (int j = 0; j < this.numCantidadFichas; j++) {
                mano.add(new FichaJuego(fichas.get(0).getValorIzquierdo(),fichas.get(0).getValorDerecho()));
                fichas.remove(0);
            }
        }
        Pozo pozo = new Pozo(fichas);
        this.setPozo(pozo);
        return listaJugadores;
    }
    
    public boolean jalarPozo(Jugador jugador) {
        List<Ficha> listaPozo = this.getPozo().getFichas();
        if (!getPozo().getFichas().isEmpty()) {
            List<FichaJuego> listaNueva = jugador.getFichasJuego();
            listaNueva.add(listaPozo.get(0).convertirFichaJuego());
            jugador.setFichas(listaNueva);
            getPozo().getFichas().remove(listaPozo.get(0));
            return true;
        }
        return false;
    }
    
}
