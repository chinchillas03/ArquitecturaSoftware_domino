/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.presentadores;

import com.itson.listeners.CrearPartidaListener;
import org.itson.Modelos.ModelCrearPartida;
import org.itson.frames.FrmCrearPartida;

/**
 *
 * @author Usuario
 */
public class PresentadorCrearPartida implements CrearPartidaListener{

    private final FrmCrearPartida view =  new FrmCrearPartida();
    private final ModelCrearPartida modelo = new ModelCrearPartida();
    
    public PresentadorCrearPartida(){
        this.view.setListener(this);
    }
    
    @Override
    public void clickSeleccionarCantidadFichas(Integer cantidadFichas) {
        // Seteo valor de fichas del modelo
        this.modelo.setCantidadFichas(cantidadFichas);   
        
        //Cierro mi vista
        this.cerrarPantallaCrearPartida();
        
        //Hablo al siguiente presentadorra
        this.mostrarPantallaSalaEspera();
    }

    @Override
    public void clickCancelar() {
        this.pasarPantallaInicio();
    }
    
    public void cerrarPantallaCrearPartida(){
        this.view.cerrarPantallaCrearPartida();
    }
    
    public void mostrarPantallaCrearPartida(){
        this.view.mostrarPantallaCrearPartida();
    }
    
    public void mostrarPantallaSalaEspera(){
        new PresentadorSalaEspera().mostrarPantallaSalaEspera();
    }
    
    private void pasarPantallaInicio(){
        this.cerrarPantallaCrearPartida();
        new PresentadorInicio().mostrarPantallaInicio();
    }
    
}
