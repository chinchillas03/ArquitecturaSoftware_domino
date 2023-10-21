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
public class Jugador {
    
    private String nombre;
    private int puntuacion;
    private List<FichaJuego> fichas;

    public Jugador() {
    }

    public Jugador(String nombre, int puntuacion, List<FichaJuego> fichas) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.fichas = fichas;
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public List<FichaJuego> getFichas() {
        return fichas;
    }

    public void setFichas(List<FichaJuego> fichas) {
        this.fichas = fichas;
    }
    public FichaJuego getMulaMasAlta(){
        FichaJuego fichaAlta=null;
        for (FichaJuego ficha : fichas) {
            if (ficha.esMula()) {
                if (fichaAlta==null) {
                    fichaAlta=ficha;
                }else{
                    if (fichaAlta.getValorDerecho()<ficha.getValorDerecho()) {
                        fichaAlta=ficha;
                    }
                }
            }
        }
        return fichaAlta;
    }
    

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", puntuacion=" + puntuacion + ", fichas=" + fichas;
    }
    
}
