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
    
    public boolean contains(int x, int y){
       return this.x >= x && this.x <= x + 25 && this.y >= y && this.y <= y + 50;
    }
    public FichaJuego convertirFichaJuego(){
         FichaJuego fichaJ = new FichaJuego();
            fichaJ.setValorDerecho(this.getValorDerecho());
            fichaJ.setValorIzquierdo(this.getValorIzquierdo());
            return fichaJ;
    }
     public FichaTablero convertirFichaTab(){
        FichaTablero fichaJ = new FichaTablero();
        fichaJ.setValorDerecho(this.getValorDerecho());
        fichaJ.setValorIzquierdo(this.getValorIzquierdo());
        return fichaJ;
    }
    @Override
    public String toString() {
        return "Ficha{" + "valorIzquierdo=" + valorIzquierdo + ", valorDerecho=" + valorDerecho + ", x=" + x + ", y=" + y + '}';
    }
   
    
    
}
