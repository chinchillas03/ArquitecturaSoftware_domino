/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

/**
 *
 * @author Usuario
 */
public class FichaTablero extends Ficha{
    public PosicionFicha lado;

    public PosicionFicha getLado() {
        return lado;
    }

    public void setLado(PosicionFicha lado) {
        this.lado = lado;
    }
    
}
