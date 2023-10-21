/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.presentadores;

import com.itson.listeners.PuntuacionesListener;
import org.itson.Modelos.ModelPuntuaciones;
import org.itson.frames.FrmPuntuaciones;

/**
 *
 * @author Usuario
 */
public class PresentadorPuntuaciones implements PuntuacionesListener{

    private final FrmPuntuaciones view = new FrmPuntuaciones();
    private final ModelPuntuaciones model = new ModelPuntuaciones();

    public PresentadorPuntuaciones() {
        this.suscribirseListener();
    }
    
    @Override
    public void clickBotonSalir() {
        this.cerrarPantallaPuntuaciones();
        new PresentadorInicio().mostrarPantallaInicio();
    }
    
    private void suscribirseListener(){
        this.view.addListener(this);
    }
    
    private void cerrarPantallaPuntuaciones(){
        this.view.cerrarPantallaPuntuaciones();
    }
    
}
