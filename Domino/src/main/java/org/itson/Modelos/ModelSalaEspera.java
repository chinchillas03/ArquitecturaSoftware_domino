/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.Modelos;

import com.itson.dominio.Jugador;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ModelSalaEspera {
    
    private List<Jugador> jugadores ;
    private int cantidadFichas;

    /**
     * Obtiene la lista de jugadores que están en la sala de espera.
     */
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Obtiene la cantidad de fichas disponibles en la sala de espera.
     *
     * @return La cantidad de fichas disponibles en la sala de espera.
     */
    public int getCantidadFichas() {
        return cantidadFichas;
    }

    /**
     * Establece la cantidad de fichas disponibles en la sala de espera.
     *
     * @param cantidadFichas La cantidad de fichas que se desea configurar en la sala de espera.
     */
    public void setCantidadFichas(int cantidadFichas) {
        this.cantidadFichas = cantidadFichas;
    }

    /**
     * Inicializa la lista de jugadores en la sala de espera con jugadores predefinidos.
     * Esta función agrega jugadores a la lista de jugadores en la sala de espera.
     */
    public void setJugadores() {
        List<Jugador> jugadores = new LinkedList<>();
        jugadores.add(new Jugador("Diego"));
        jugadores.add(new Jugador("Joel"));
        jugadores.add(new Jugador("Pepe"));
        jugadores.add(new Jugador("Paco"));
        this.jugadores = jugadores;
    }

}
