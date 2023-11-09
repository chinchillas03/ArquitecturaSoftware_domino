/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import com.itson.interfaces.IJugadorPartida;
import com.itson.interfaces.JugadorSala;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Jugador implements JugadorSala,IJugadorPartida{
    
    private String nombre;
    private Avatar avatar;
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

    @Override
    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }
    
    @Override
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

    @Override
    public List<FichaJuego> getFichasJuego() {
        return fichas;
    }

    public void setFichas(List<FichaJuego> fichas) {
        this.fichas = fichas;
    }
    @Override
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
    public boolean quitarFicha(Ficha ficha){
        for (FichaJuego ficha1 : fichas) {
            if (ficha1.equals(ficha)) {
                fichas.remove(ficha);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int verificarNumFichas(){
        return fichas.size();
    }
    
    public boolean validarNombre(String nombre){
        int tamNombre = nombre.length();
        if (nombre.isBlank() || nombre.isEmpty() || tamNombre > 15 || tamNombre > 3) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", puntuacion=" + puntuacion + ", fichas=" + fichas;
    }

 
    
}
