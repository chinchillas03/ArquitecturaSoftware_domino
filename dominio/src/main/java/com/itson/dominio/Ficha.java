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
    private int x;
    private int y;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean esMula(){
        return valorDerecho==valorIzquierdo;
    }
    @Override
    public String toString() {
        return "Ficha{" + "valorIzquierdo=" + valorIzquierdo + ", valorDerecho=" + valorDerecho + '}';
    }
    
}
