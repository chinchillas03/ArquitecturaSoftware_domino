/**
* ModelTablero.java
* Oct 18, 2023 11:37:35 PM
*/ 

package org.itson.Modelos;

import com.itson.dominio.Ficha;
import com.itson.dominio.FichaJuego;
import com.itson.dominio.Jugador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * 
 * @author Joel Antonio Lopez Cota ID:228926 
 */
public class ModelTablero {
    List<Ficha> listaFichas;
    List<Jugador> listaJugadores;
    /**
     * 
     */
    public ModelTablero(){
        listaFichas = new ArrayList<>();
        listaJugadores = new ArrayList<>();
    }

    public List<Ficha> generaFichasDomino(){
        listaFichas = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                Ficha domino=new Ficha(i,j);
                listaFichas.add(domino);
            }
        }
        return listaFichas;
    }
    public List<Jugador> repartirFichas(List<Jugador> jugadores, int fichasPorJugador){
       List<Ficha> fichas=generaFichasDomino();
        Collections.shuffle(fichas);
        listaJugadores=jugadores;
        for (int i = 0; i < listaJugadores.size(); i++) {
            List<Ficha> mano = new ArrayList<>();
            for (int j = 0; j < fichasPorJugador; j++) {
                mano.add(fichas.remove(0));
            }
           listaJugadores.get(i).setFichas(converToFichaJuego(mano));
        } 
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
    
    public void jalarPozo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void posicionarFicha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void pasarTurno() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void iniciarPartida(List<Jugador> jugadores, int fichasPorJugador) {
        List<Jugador> jugadoresS=repartirFichas(jugadores, fichasPorJugador);
        System.out.println();
        for (int i = 0; i < jugadores.size(); i++) {
            
        System.out.println(jugadoresS.get(i).mulaMasAlta());
    }
    }
    public List<FichaJuego> recuperaListaJugadores(){
        return listaJugadores.get(1).getFichas();
    }
}
