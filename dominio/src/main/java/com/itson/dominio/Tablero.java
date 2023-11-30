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
            int valorIzquierdo = ficha.getValorIzquierdo();
            int valorDerecho = ficha.getValorDerecho();
            System.out.println(ficha.getLado());
            if (ficha.getLado()==0) {
                 if (ladoIzquierdoTablero == ficha.getValorIzquierdo()) {
                ficha.setValorDerecho(valorIzquierdo);
                ficha.setValorIzquierdo(valorDerecho);
                return true;
            } else if (ladoIzquierdoTablero == ficha.getValorDerecho()) {
                return true;
            }}else{
               if (ladoDerechoTablero == ficha.getValorIzquierdo()) {
                return true;
            } else if (ladoDerechoTablero == ficha.getValorDerecho()) {
                ficha.setValorDerecho(valorIzquierdo);
                ficha.setValorIzquierdo(valorDerecho);
                return true;
            }
            return false;
            }
       return true;
    }else if (this.verificaCantidadFichas()) {
            return true;
        }
        return false;
    }
 
    public void addFicha(FichaTablero ficha) {
       
        if (fichas.isEmpty()) {
            if (ficha.esMula()) {
            fichas.add(ficha);
            return;
        }
        }
        if (ficha.getLado()==0) {
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
