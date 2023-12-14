/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.presentadores;

import org.itson.listeners.InicioListener;
import org.itson.frames.FrmInicio;

/**
 *
 * @author Usuario
 */
public class PresentadorInicio implements InicioListener{
    
    private final FrmInicio view = new FrmInicio();
    private String nombre;
    public PresentadorInicio(){
        this.view.setListener(this);
    }
    
    @Override
    public void clickCrearPartida() {
        this.cerrarPantallaInicio();
        new PresentadorCrearPartida().mostrarPantallaCrearPartida();
    }

    @Override
    public void clickEntrarPartida() {
        this.cerrarPantallaInicio();
        PresentadorConfigurarConexion presentador= new PresentadorConfigurarConexion();
        presentador.setNombreJugador(nombre);
        presentador.mostrarPantallaSetIP();
    }
    
    @Override
    public void clickConfigurarJugador() {
        this.cerrarPantallaInicio();
        new PresentadorConfigurarJugador().mostrarPantallaConfigurarJugador();
    }
   
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void mostrarPantallaInicio(){
        System.out.println(nombre);
        this.view.mostrarPantallaInicio();
    }
    
    public void cerrarPantallaInicio(){
        this.view.cerrarPantallaInicio();
    }
 
}
