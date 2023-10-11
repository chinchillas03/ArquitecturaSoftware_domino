/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

/**
 *
 * @author Usuario
 */
public class Ficha {
    
    private int valorIzquierdo;
    private int valorDerecho;

    public Ficha() {
    }

    public Ficha(int valorIzquierdo, int valorDerecho) {
        this.valorIzquierdo = valorIzquierdo;
        this.valorDerecho = valorDerecho;
    }

    public int getValorIzquierdo() {
        return valorIzquierdo;
    }

    public void setValorIzquierdo(int valorIzquierdo) {
        this.valorIzquierdo = valorIzquierdo;
    }

    public int getValorDerecho() {
        return valorDerecho;
    }

    public void setValorDerecho(int valorDerecho) {
        this.valorDerecho = valorDerecho;
    }
    
}
