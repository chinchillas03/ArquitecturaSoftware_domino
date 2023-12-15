/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dtos;

import com.itson.dominio.PosicionFicha;
import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class FichaDTO implements Serializable{
    
    private int ladoIzquierdo;
    private int ladoDerecho;
    private PosicionFicha lado;

    public FichaDTO() {
    }

    public FichaDTO(int ladoIzquierdo, int ladoDerecho, PosicionFicha lado) {
        this.ladoIzquierdo = ladoIzquierdo;
        this.ladoDerecho = ladoDerecho;
        this.lado = lado;
    }

    public int getLadoIzquierdo() {
        return ladoIzquierdo;
    }

    public void setLadoIzquierdo(int ladoIzquierdo) {
        this.ladoIzquierdo = ladoIzquierdo;
    }

    public int getLadoDerecho() {
        return ladoDerecho;
    }

    public void setLadoDerecho(int ladoDerecho) {
        this.ladoDerecho = ladoDerecho;
    }

    public PosicionFicha getLado() {
        return lado;
    }

    public void setLado(PosicionFicha lado) {
        this.lado = lado;
    }
    
}
