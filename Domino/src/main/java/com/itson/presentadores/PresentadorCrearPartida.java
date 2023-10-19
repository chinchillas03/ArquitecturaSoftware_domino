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
        view.addListener(this);
        view.setVisible(true);
    }
    
    @Override
    public void clickSeleccionarCantidadFichas(Integer cantidadFichas) {
        // Seteo valor de fichas del modelo
        modelo.setCantidadFichas(cantidadFichas);   
        
        //Cierro mi vista
        view.setVisible(false);
        
        //Hablo al siguiente presentadorra
        PresentadorSalaEspera presenter = new PresentadorSalaEspera();
    }

    @Override
    public void clickCancelar() {
        this.pasarPantallaInicio();
    }
    
    private void pasarPantallaInicio(){
        this.view.setVisible(false);
        PresentadorInicio inicio = new PresentadorInicio();
    }
    
}
