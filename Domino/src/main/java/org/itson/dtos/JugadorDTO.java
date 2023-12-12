/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dtos;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class JugadorDTO implements Serializable{
    
    private String nombre;

    public JugadorDTO() {
    }

    public JugadorDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
