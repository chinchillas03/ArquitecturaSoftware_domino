/**
 * ModelTablero.java
 * Oct 18, 2023 11:37:35 PM
 */
package org.itson.Modelos;

import com.itson.dominio.Ficha;
import com.itson.dominio.FichaJuego;
import com.itson.dominio.FichaTablero;
import com.itson.dominio.Jugador;
import com.itson.dominio.Partida;
import com.itson.dominio.Pozo;
import com.itson.dominio.Tablero;
import com.itson.presentadores.PresentadorPartida;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public class ModelTablero {

    private List<Ficha> listaFichas;
    private List<Jugador> listaJugadores;
    private int cantidadFichas;
    private Partida partida;

    /**
     * Constructor por defecto de la clase ModelTablero.
     */
    public ModelTablero() {
        listaFichas = new ArrayList<>();
        listaJugadores = new ArrayList<>();
        this.partida = Partida.instancia();
    }

    /**
     * Obtiene la cantidad de fichas en el tablero.
     *
     * @return La cantidad de fichas en el tablero.
     */
    public int getCantidadFichas() {
        return cantidadFichas;
    }

    /**
     * Establece la cantidad de fichas en el tablero.
     *
     * @param cantidadFichas La cantidad de fichas que se desea configurar en el
     * tablero.
     */
    public void setCantidadFichas(int cantidadFichas) {
        this.cantidadFichas = cantidadFichas;
    }

    /**
     * Obtiene la lista de jugadores en el juego.
     *
     * @return La lista de jugadores en el juego.
     */
    public List<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    /**
     * Establece la lista de jugadores en el juego.
     *
     * @param listaJugadores La lista de jugadores que se desea configurar en el
     * juego.
     */
    public void setListaJugadores(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    /**
     * Genera y devuelve una lista de fichas para un juego de dominó.
     *
     * @return La lista de fichas generadas.
     */
    public List<Ficha> generaFichasDomino() {
        listaFichas = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                Ficha domino = new Ficha(i, j);
                listaFichas.add(domino);
            }
        }
        return listaFichas;
    }

    public List<Jugador> repartirFichas(List<Jugador> jugadores, int fichasPorJugador) {
        List<Ficha> fichas = generaFichasDomino();
        Collections.shuffle(fichas);
        Collections.shuffle(fichas);
        listaJugadores = jugadores;
        for (int i = 0; i < listaJugadores.size(); i++) {
            List<FichaJuego> mano = new ArrayList<>();
            for (int j = 0; j < fichasPorJugador; j++) {
                mano.add(fichas.remove(0).convertirFichaJuego());
            }
            System.out.println(mano);
            listaJugadores.get(i).setFichas(mano);
        }
        Pozo pozo=new Pozo(fichas);
        partida.setPozo(pozo);
        return listaJugadores;
    }




    

    public boolean jalarPozo(Jugador jugador) {
        List<Ficha> listaPozo = partida.getPozo().getFichas();
            System.out.println(listaPozo);
        if (!partida.getPozo().getFichas().isEmpty()) {
            List<FichaJuego> listaNueva = jugador.getFichasJuego();
            listaNueva.add(listaPozo.get(0).convertirFichaJuego());
            jugador.setFichas(listaNueva);
            partida.getPozo().getFichas().remove(listaPozo.get(0));
            return true;
        }
        return false;
    }

    public void posicionarFicha(Ficha ficha) {
        FichaTablero fichaNva=ficha.convertirFichaTab();
        if (partida.getTablero() == null) {
            partida.setTablero(new Tablero());
        }
        System.out.println(fichaNva);
        if (partida.getTablero().verificaFicha(fichaNva)) {
            partida.getTablero().addFicha(fichaNva);
           partida.getJugadores().get(0).quitarFicha(ficha);
        } 
        if (listaJugadores.get(0).verificarNumFichas() != 0) {
            partida.pasarTurno();
        } else {
            partida.terminarJuego();
        }
        System.out.println(partida.getTablero());
    }

    public void pasarTurno() {

    }

    public void iniciarPartida(List<Jugador> jugadores, int cantidadFichas) {
        this.partida=Partida.instancia();
        partida.GuardarPartida(jugadores, cantidadFichas);
        System.out.println(partida);
        this.listaJugadores = repartirFichas(partida.getJugadores(), partida.getNumCantidadFichas());
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



}
