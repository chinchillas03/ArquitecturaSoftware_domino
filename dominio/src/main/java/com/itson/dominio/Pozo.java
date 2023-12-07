/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Pozo {
    private List<Ficha> fichas;

    public Pozo() {
    }

    public Pozo(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }
    
    public boolean verificarFichas(){
        return fichas==null;
    }
    
    public void quitarFicha(Ficha ficha){
        fichas.remove(ficha);
    }

    @Override
    public String toString() {
        return "Pozo{" + "fichas=" + fichas + '}';
    }

    public boolean jalarPozo(Jugador jugador) {
        System.out.println(getFichas());
        if (!getFichas().isEmpty()) {
            List<FichaJuego> listaNueva = jugador.getFichasJuego();
            listaNueva.add(new FichaJuego(getFichas().get(0).getValorIzquierdo(),getFichas().get(0).getValorDerecho()));
            getFichas().remove(getFichas().get(0));
            return true;
        }
        return false;
    }
    
     
}
