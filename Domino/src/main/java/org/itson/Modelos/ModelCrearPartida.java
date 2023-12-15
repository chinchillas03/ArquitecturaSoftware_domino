/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.Modelos;

import com.itson.dominio.Jugador;
import com.itson.dominio.Partida;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ModelCrearPartida {
    
    private Integer cantidadFichas;
    private Partida partida=Partida.instancia();
    private String nombre;
    /**
     * Constructor por defecto de la clase ModelCrearPartida.
     * Crea una instancia de la clase sin inicializar la cantidad de fichas.
     */
    public ModelCrearPartida() {
        // El constructor por defecto no realiza ninguna acción especial.
    }

    /**
     * Obtiene la cantidad de fichas configurada para la partida.
     *
     * @return La cantidad de fichas para la partida.
     */
    public Integer getCantidadFichas() {
        return cantidadFichas;
    }

    /**
     * Establece la cantidad de fichas para la partida.
     *
     * @param cantidadFichas La cantidad de fichas que se desea configurar para la partida.
     */
    public void setCantidadFichas(Integer cantidadFichas) {
        this.cantidadFichas = cantidadFichas;
    }

    /**
     * Crea una nueva partida utilizando la cantidad de fichas configurada.
     * Esta función no devuelve la partida creada; solo la instancia de la clase ModelCrearPartida se utiliza para configurar la cantidad de fichas.
     */
    public void crearPartida(int cantidadFichas) {
        Partida partida = Partida.instancia();
        partida.getJugadores().add(new Jugador(nombre));
        partida.crearPartida(cantidadFichas);
        System.out.println(partida);
        
    }

    public void setNombreJugador(String nombre) {
        this.nombre=nombre;
    }
    
}
