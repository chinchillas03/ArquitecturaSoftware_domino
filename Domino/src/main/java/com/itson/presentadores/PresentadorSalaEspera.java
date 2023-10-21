/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.presentadores;

import com.itson.listeners.SalaEsperaListener;
import org.itson.Modelos.ModelSalaEspera;
import org.itson.frames.FrmSalaEspera;

/**
 *
 * @author Usuario
 */
public class PresentadorSalaEspera implements SalaEsperaListener{

    private final FrmSalaEspera view = new FrmSalaEspera();
    private final ModelSalaEspera model = new ModelSalaEspera();
    
    public PresentadorSalaEspera(){     
        this.suscribirseListener();
    }
    
    @Override
    public void clickBotonIniciarPartida() {
        this.cerrarPantallaSalaEspera();
//        new PresentadorPartida.mostrarPantallaPartida();
    }

    @Override
    public void clickBotonSalirPartida() {
        this.cerrarPantallaSalaEspera();
        new PresentadorInicio().mostrarPantallaInicio();
    }
    
    private void suscribirseListener(){
        this.view.addListener(this);
    }
    
    public void cerrarPantallaSalaEspera(){
        this.view.cerrarPantallaSalaEspera();
    }
    
    public void mostrarPantallaSalaEspera(){
        this.view.mostrarPantallaSalaEspera();
    }
    
}
