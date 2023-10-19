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
        view.addListener(this);
        view.setVisible(true);
    }

    @Override
    public void clickCrearPartida() {
        this.view.setVisible(false);
        PresentadorCrearPartida presenter = new PresentadorCrearPartida();
    }

    @Override
    public void clickEntrarPartida() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
