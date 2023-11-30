/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.presentadores;

import com.itson.listeners.ConfigurarJugadorListener;
import javax.swing.JOptionPane;
import org.itson.Modelos.ModelConfigurarJugador;
import org.itson.frames.FrmConfiguracionJugador;

/**
 *
 * @author Usuario
 */
public class PresentadorConfigurarJugador implements ConfigurarJugadorListener{

    private final FrmConfiguracionJugador view = new FrmConfiguracionJugador();
    private final ModelConfigurarJugador model = new ModelConfigurarJugador();

    public PresentadorConfigurarJugador() {
       this.view.setListener(this);
    }
    
    @Override
    public void clickBotonAplicar(String nombre) {
        this.model.setNombre(nombre);
        this.cerrarPantallaConfigurarJugador();
        new PresentadorInicio().mostrarPantallaInicio();
    }
    @Override
    public void clickBotonCancelar() {
        this.cerrarPantallaConfigurarJugador();
        new PresentadorInicio().mostrarPantallaInicio();
    }
    @Override
    //Modificar
    public boolean validarJugador(String nombre){
        if (!this.model.validarJugador(nombre) == true) {
          this.mostrarMensaje(nombre);
        }
        return true;
    }
    
    public void mostrarMensaje(String mensaje){
        this.view.mostrarMensaje(mensaje);
    }

    public void mostrarPantallaConfigurarJugador(){
        this.view.mostrarPantallaConfigurarJugador();
    }
    
    public void cerrarPantallaConfigurarJugador(){
        this.view.cerrarPantallaConfigurarJugador();
    }
    
}
