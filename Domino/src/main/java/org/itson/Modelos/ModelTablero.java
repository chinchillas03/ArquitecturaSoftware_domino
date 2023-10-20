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

    /**
     * 
     */
    public ModelTablero(){

    }

    public List<Ficha> generaFichasDomino(){
        List<Ficha> fichas = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                Ficha domino=new Ficha(i,j);
                fichas.add(domino);
            }
        }
        return fichas;
    }
    public List<Jugador> repartirFichas(List<Jugador> jugadores, int fichasPorJugador){
       List<Ficha> fichas=generaFichasDomino();
        Collections.shuffle(fichas);
       List<Jugador> jugador=jugadores;
        for (int i = 1; i < jugador.size(); i++) {
            List<Ficha> mano = new ArrayList<>();
            for (int j = 0; j < fichasPorJugador; j++) {
                mano.add(fichas.remove(0));
            }
           jugador.get(i).setFichas(converToFichaJuego(mano));
        } 
        return jugadores;
    }
    
    
    public List<FichaJuego> converToFichaJuego(List<Ficha> lista){
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
        System.out.println(repartirFichas(jugadores, fichasPorJugador));
    }
}
