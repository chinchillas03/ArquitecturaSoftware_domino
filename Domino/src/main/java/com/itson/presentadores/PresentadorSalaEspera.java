/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.presentadores;

import com.itson.dominio.Avatar;
import com.itson.listeners.SalaEsperaListener;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
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
        view.addListener(this);
        view.setVisible(true);
        this.view.setCombosAvatares(crearAvatares());
    }
    
    private List<Avatar> crearAvatares(){
        Avatar avatar1 = new Avatar();
        Avatar avatar2 = new Avatar();
        Avatar avatar3 = new Avatar();
        Avatar avatar4 = new Avatar();
        avatar1.setColor(Color.YELLOW);
        avatar2.setColor(Color.BLUE);
        avatar3.setColor(Color.GREEN);
        avatar4.setColor(Color.RED);
        List<Avatar> avatares = new LinkedList<>();
        avatares.add(avatar1);
        avatares.add(avatar2);
        avatares.add(avatar3);
        avatares.add(avatar4);
        return avatares;
    }
    
    @Override
    public void clickBotonIniciarPartida() {
        
    }

    @Override
    public void clickBotonSalirPartida() {
        view.setVisible(false);
        PresentadorInicio presenter = new PresentadorInicio();
    }
    
}
