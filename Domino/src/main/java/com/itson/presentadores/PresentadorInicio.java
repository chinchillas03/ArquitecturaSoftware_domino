/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.presentadores;

import com.itson.listeners.InicioListener;
import org.itson.frames.FrmInicio;

/**
 *
 * @author Usuario
 */
public class PresentadorInicio implements InicioListener{
    
    private final FrmInicio view = new FrmInicio();
    
    public PresentadorInicio(){
        this.view.setListener(this);
    }

    @Override
    public void clickCrearPartida() {
        this.cerrarPantallaInicio();
        new PresentadorCrearPartida().mostrarPantallaCrearPartida();
    }
    //Activar cuando ya haya una partida
    @Override
    public boolean clickEntrarPartida() {
//        this.cerrarPantallaInicio();
//        new PresentadorSalaEspera().mostrarPantallaSalaEspera();
        this.view.mostrarMensajeError("No existe ninguna partida");
        return false;
        
    }
    
    @Override
    public void clickConfigurarJugador() {
        this.cerrarPantallaInicio();
        new PresentadorConfigurarJugador().mostrarPantallaConfigurarJugador();
    }
   
    public void mostrarPantallaInicio(){
        this.view.mostrarPantallaInicio();
    }
    
    public void cerrarPantallaInicio(){
        this.view.cerrarPantallaInicio();
    }
 
}
