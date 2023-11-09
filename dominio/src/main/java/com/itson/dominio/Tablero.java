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
        if (!this.verificaCantidadFichas()) {
            int ladoIzquierdoTablero = fichas.get(0).getValorIzquierdo();
            int ladoDerechoTablero = fichas.get(fichas.size() - 1).getValorDerecho();
            System.out.println(ladoIzquierdoTablero);
            System.out.println(ladoDerechoTablero);
            int valorIzquierdo = ficha.getValorIzquierdo();
            int valorDerecho = ficha.getValorDerecho();
            if (ladoIzquierdoTablero == ficha.getValorIzquierdo()) {
                ficha.setValorDerecho(valorIzquierdo);
                ficha.setValorIzquierdo(valorDerecho);
                return true;
            } else if (ladoIzquierdoTablero == ficha.getValorDerecho()) {
                return true;
            } else if (ladoDerechoTablero == ficha.getValorIzquierdo()) {
                return true;
            } else if (ladoDerechoTablero == ficha.getValorDerecho()) {
                ficha.setValorDerecho(valorIzquierdo);
                ficha.setValorIzquierdo(valorDerecho);
                return true;
            }
            return false;
        }
        return true;
    }

    public void addFicha(FichaTablero ficha) {
        if (fichas.isEmpty()) {
            fichas.add(ficha);
            return;
        }
        int ladoIzquierdoTablero = fichas.get(0).getValorIzquierdo();
        if (ladoIzquierdoTablero == ficha.getValorDerecho()) {
            fichas.add(0, ficha);
        } else {
            fichas.add(ficha);
        }
    }

    @Override
    public String toString() {
        return "Tablero{" + "fichas=" + fichas + '}';
    }

}
