/**
* ModelTablero.java
* Oct 18, 2023 11:37:35 PM
*/ 

package org.itson.Modelos;

import com.itson.dominio.Ficha;
import com.itson.dominio.FichaJuego;
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
    private Pozo pozo;
    private Tablero tablero;
    private Partida partida;
    /**
     * Constructor por defecto de la clase ModelTablero.
     */
    public ModelTablero() {
        listaFichas = new ArrayList<>();
        listaJugadores = new ArrayList<>();
        pozo = new Pozo();
        this.partida= new Partida();
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
     * @param cantidadFichas La cantidad de fichas que se desea configurar en el tablero.
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
     * @param listaJugadores La lista de jugadores que se desea configurar en el juego.
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
    
    public List<Jugador> repartirFichas(List<Jugador> jugadores, int fichasPorJugador){
       List<Ficha> fichas=generaFichasDomino();
        Collections.shuffle(fichas);
        Collections.shuffle(fichas);
        listaJugadores=jugadores;
        for (int i = 0; i < listaJugadores.size(); i++) {
            List<Ficha> mano = new ArrayList<>();
            for (int j = 0; j < fichasPorJugador; j++) {
                mano.add(fichas.remove(0));
            }
            System.out.println(mano);
           listaJugadores.get(i).setFichas(converToFichaJuego(mano));
        }                
        pozo.setFichas(listaFichas);
        System.out.println(pozo);
        return listaJugadores;
    }
    
    
    private List<FichaJuego> converToFichaJuego(List<Ficha> lista){
        List<FichaJuego> listaNueva=new ArrayList<>();
        for (Ficha ficha : lista) {
            FichaJuego fichaJ=new FichaJuego();
            fichaJ.setValorDerecho(ficha.getValorDerecho());
            fichaJ.setValorIzquierdo(ficha.getValorIzquierdo());
            listaNueva.add(fichaJ);
    }
    return listaNueva;
    }
    private List<Ficha> converToFicha(List<FichaJuego> lista){
        List<Ficha> listaNueva=new ArrayList<>();
        for (Ficha ficha : lista) {
            Ficha fichaJ=new FichaJuego();
            fichaJ.setValorDerecho(ficha.getValorDerecho());
            fichaJ.setValorIzquierdo(ficha.getValorIzquierdo());
            listaNueva.add(fichaJ);
    }
    return listaNueva;
    }
    
    public boolean jalarPozo(Jugador jugador) {
               List<FichaJuego> listaPozo =converToFichaJuego(pozo.getFichas());
        if (!pozo.getFichas().isEmpty()) {
             List<FichaJuego> listaNueva=jugador.getFichas();
             listaNueva.add(listaPozo.remove(0));
            jugador.setFichas(listaNueva);
            pozo.setFichas(converToFicha(listaPozo));
            System.out.println(jugador);
            return true;
        }
        return false;
    }

    public void posicionarFicha() {
        if (tablero.verificaFicha()) {
            //Cambiar a jugador, solo es una prueba
            listaJugadores.get(0).quitarFicha();
            tablero.addFicha();
            if (listaJugadores.get(0).verificarNumFichas()) {
               partida.pasarTurno();
            }else{
               partida.terminarJuego();
            }
        }
    }

    public void pasarTurno() {
      
    }
    
    public void iniciarPartida(Partida partida) {
        this.listaJugadores=repartirFichas(partida.getJugadores(), partida.getNumCantidadFichas());
        setearTurnos();
               System.out.println(listaJugadores);

    }
    private Jugador primerTurno(){
        Jugador primerTurno= listaJugadores.get(0);
        for (int i = 0; i < listaJugadores.size(); i++) {
            if (listaJugadores.get(i).getMulaMasAlta()!=null) {
                primerTurno=listaJugadores.get(i);
                  if (listaJugadores.get(i).getMulaMasAlta().getValorDerecho()>=primerTurno.getMulaMasAlta().getValorDerecho()) {
                primerTurno=listaJugadores.get(i);
            }
            }
        }
        return primerTurno;
    }
    private void setearTurnos(){
        Jugador jugadorConMulaMasAlta = primerTurno();
        System.out.println("El jugador con la mula más alta es " +jugadorConMulaMasAlta.getNombre()+ jugadorConMulaMasAlta.getMulaMasAlta());
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
    public List<FichaJuego> recuperaListaJugadores(){
        return listaJugadores.get(1).getFichas();
    }
    
}