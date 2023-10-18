/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.presentadores;

import com.itson.listeners.CrearPartidaListener;
import org.itson.Modelos.ModelCrearPartida;
import org.itson.Modelos.ModelSalaEspera;
import org.itson.frames.FrmCrearPartida;
import org.itson.frames.FrmInicio;
import org.itson.frames.FrmSalaEspera;

/**
 *
 * @author Usuario
 */
public class PresentadorCrearPartida implements CrearPartidaListener{

    private final FrmCrearPartida crearPartida;
    private final ModelCrearPartida modelo;
    
    public PresentadorCrearPartida(FrmCrearPartida crearPartida, ModelCrearPartida modelo){
        this.crearPartida = crearPartida;
        crearPartida.addListener(this);
        crearPartida.setVisible(true);
        this.modelo = modelo;
    }
    
    @Override
    public void clickSeleccionarCantidadFichas(Integer cantidadFichas) {
        // Seteo valor de fichas del modelo.
        modelo.setCantidadFichas(cantidadFichas);   
        
        //Cierro mi vista
        crearPartida.setVisible(false);
        
        //Hablo al siguiente presentador
        final FrmSalaEspera view = new FrmSalaEspera();
        final ModelSalaEspera model = new ModelSalaEspera();
        new PresentadorSalaEspera();
    }

    @Override
    public void clickCancelar() {
        this.crearPartida.setVisible(false);
        final FrmInicio view = new FrmInicio();
        PresentadorInicio inicio = new PresentadorInicio(view);
    }
    
}
