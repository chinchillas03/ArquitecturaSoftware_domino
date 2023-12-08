/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.Modelos;

import com.itson.dominio.Jugador;

/**
 *
 * @author Usuario
 */
public class ModelConfigurarJugador {
    
    private String nombre;
    private Jugador jugador;
    public ModelConfigurarJugador() {
    }

    public ModelConfigurarJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean validarJugador(String nombre){
        if (jugador==null) {
            jugador=new Jugador();
        }
        if (this.jugador.validarNombre(nombre) == true) {
            return true;
        }
        return false;
    }
    
}
