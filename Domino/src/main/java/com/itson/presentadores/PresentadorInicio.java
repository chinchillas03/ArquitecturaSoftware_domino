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
        this.suscribirseListener();
    }

    @Override
    public void clickCrearPartida() {
        this.cerrarPantallaInicio();
        new PresentadorCrearPartida().mostrarPantallaCrearPartida();
    }

    @Override
    public void clickEntrarPartida() {
        this.cerrarPantallaInicio();
        new PresentadorSalaEspera().mostrarPantallaSalaEspera();
    }
    
    @Override
    public void clickConfigurarJugador() {
        this.cerrarPantallaInicio();
        new PresentadorConfigurarJugador().mostrarPantallaConfigurarJugador();
    }
    
    private void suscribirseListener(){
        this.view.addListener(this);
    }
    
    public void mostrarPantallaInicio(){
        this.view.mostrarPantallaInicio();
    }
    
    public void cerrarPantallaInicio(){
        this.view.cerrarPantallaInicio();
    }
 
}
