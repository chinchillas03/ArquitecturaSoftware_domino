/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.implementacionesInterfaces;

import com.itson.dominio.Avatar;
import com.itson.interfacesJugador.JugadorSala;

/**
 *
 * @author Usuario
 */
public class JugadorS implements JugadorSala{

    private String nombre;
    private Avatar avatar;

    public JugadorS(String nombre) {
        this.nombre = nombre;
    }

    public JugadorS(String nombre, Avatar avatar) {
        this.nombre = nombre;
        this.avatar = avatar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }
    
    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public Avatar avatar() {
        return avatar;
    }
    
}
