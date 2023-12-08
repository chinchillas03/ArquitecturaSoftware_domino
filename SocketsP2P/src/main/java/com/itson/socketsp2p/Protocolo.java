/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.socketsp2p;

import java.util.List;
import org.itson.observador.*;

/**
 *
 * @author Usuario
 */
public class Protocolo{
    
    private Servidor server;
    private List<observarConexion> presentadorConexion;
    private List<observarFicha> agregarFicha;
    private List<observarSalir> salir;
    private List<observarSalirTodos> salirTodos;
    private List<observarCambiarAvatar> cambiarAvatar;
    private List<observarFinPartida> finPartida;

    public Protocolo() {
    }

    public Servidor getServer() {
        return server;
    }

    public void setServer(Servidor server) {
        this.server = server;
    }

    public void setPresentadorConexion(observarConexion presentadorConexion) {
        this.presentadorConexion.add(presentadorConexion);
    }

    public void setAgregarFicha(observarFicha agregarFicha) {
        this.agregarFicha.add(agregarFicha);
    }

    public void setSalir(observarSalir salir) {
        this.salir.add(salir);
    }
    
    public void setSalirTodos(observarSalirTodos salirTodos) {
        this.salirTodos.add(salirTodos);
    }

    public void setFinPartida(observarFinPartida finPartida) {
        this.finPartida.add(finPartida);
    }

    public void setCambiarAvatar(observarCambiarAvatar cambiarAvatar) {
        this.cambiarAvatar.add(cambiarAvatar);
    } 
    
    public void nuevaConexion(){
//        for (protocoloObservable observable : presentadorConexion) {
//            observable.nuevaConexion();
//        }
    }
    
    public void agregarFicha(){
        for (observarFicha observable : agregarFicha) {
            observable.agregarFicha();
        }
    }
    
    public void cambiarAvatar(){
        for (observarCambiarAvatar observable : cambiarAvatar) {
            observable.cambiarAvatar();
        }
    }
    
    public void salir(){
        for (observarSalir observable : salir) {
            observable.salir();
        }
    }
    
    public void mostrarMarcador(){
        for (observarFinPartida observable : finPartida) {
            observable.finPartida();
        }
    }
    
    public void salirTodos(){
        for (observarSalirTodos observable : salirTodos) {
            observable.salirTodos();
        }
    }
    
}

