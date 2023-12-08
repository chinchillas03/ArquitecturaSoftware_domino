/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Tablero {

    private List<FichaTablero> fichas;
    private int extremoDerecho;
    private int extremoIzquierdo;

    public Tablero() {
        fichas = new ArrayList<>();
    }

    public Tablero(List<FichaTablero> fichas) {
        this.fichas = fichas;
    }

    public List<FichaTablero> getFichas() {
        return fichas;
    }

    public void setFichas(List<FichaTablero> fichas) {
        this.fichas = fichas;
    }

    public boolean verificaCantidadFichas() {
        return fichas.isEmpty();
    }

    public boolean verificaFicha(FichaTablero ficha) {
        if (ficha.getLado() == PosicionFicha.DERECHO) {
            return verificarLadoDerecho(ficha);
        } else {
            return verificarLadoIzquierdo(ficha);
        }

    }

    public int getExtremoDerecho() {
        return extremoDerecho;
    }

    public void setExtremoDerecho(int extremoDerecho) {
        this.extremoDerecho = extremoDerecho;
    }

    public int getExtremoIzquierdo() {
        return extremoIzquierdo;
    }

    public void setExtremoIzquierdo(int extremoIzquierdo) {
        this.extremoIzquierdo = extremoIzquierdo;
    }

    public void agregarFicha(FichaTablero ficha) {
        if (fichas.isEmpty()) {
            if (ficha.esMula()) {
                fichas.add(ficha);
                this.setExtremoDerecho(ficha.getValorDerecho());
                this.setExtremoIzquierdo(ficha.getValorIzquierdo());
                return;
            }
        }
        if (ficha.getLado() == PosicionFicha.IZQUIERDO) {
            fichas.add(0, ficha);
        } else {
            fichas.add(ficha);

        }
        actualizarExtremos(ficha);
        
        System.out.println(extremoDerecho);
        System.out.println(extremoIzquierdo);
    }

    @Override
    public String toString() {
        return "Tablero{" + "fichas=" + fichas + '}';
    }

    private boolean verificarLadoDerecho(FichaTablero ficha) {
        int ladoDerechoTablero = this.getExtremoDerecho();
        int valorIzq=ficha.getValorIzquierdo();
        int valorDer=ficha.getValorDerecho();
        if (ladoDerechoTablero == ficha.getValorIzquierdo()) {
            return true;
        } else if (ladoDerechoTablero == ficha.getValorDerecho()) {
           ficha.setValorDerecho(valorIzq);
          ficha.setValorIzquierdo(valorDer);
          return true;
        }
        return false;
    }

    private boolean verificarLadoIzquierdo(FichaTablero ficha) {
        int ladoIzquierdoTablero = this.getExtremoIzquierdo();
        int valorIzq=ficha.getValorIzquierdo();
        int valorDer=ficha.getValorDerecho();
        if (ladoIzquierdoTablero == ficha.getValorIzquierdo()) {
          ficha.setValorDerecho(valorIzq);
          ficha.setValorIzquierdo(valorDer);
            return true;
        } else if (ladoIzquierdoTablero == ficha.getValorDerecho()) {
            return true;
        }
        return false;
    }

    private void actualizarExtremos(FichaTablero ficha) {
        if (ficha.getLado() == PosicionFicha.DERECHO) {
            if (this.getExtremoDerecho() == ficha.getValorIzquierdo()) {
                this.setExtremoDerecho(ficha.getValorDerecho());
            } else {
                this.setExtremoDerecho(ficha.getValorIzquierdo());
            }
        }
        if (ficha.getLado()== PosicionFicha.IZQUIERDO) {
            if (this.getExtremoIzquierdo()== ficha.getValorDerecho()) {
                this.setExtremoIzquierdo(ficha.getValorIzquierdo());
            } else {
                this.setExtremoIzquierdo(ficha.getValorIzquierdo());
            }

        }
    }

}
