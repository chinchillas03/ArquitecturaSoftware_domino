/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.presentadores;

import org.itson.frames.FrmSetIP;
import org.itson.listeners.SetIPListener;
import org.itson.modelos.ModelSetIP;

/**
 *
 * @author aroco
 */
public class PresentadorSetIP implements SetIPListener {

    private final FrmSetIP view = new FrmSetIP();
        private ModelSetIP model = new ModelSetIP();


    public PresentadorSetIP() {
        this.view.setListener(this);
    }

    @Override
    public void clickBotonUnirse(String ip, int puerto) {
//        this.model.setIp(ip);
//        this.model.setPuerto(puerto);
        new PresentadorSalaEspera().mostrarPantallaSalaEspera();
    }

    @Override
    public void clickBotonRegresar() {
        cerrarPantalla();
        new PresentadorInicio().mostrarPantallaInicio();
    }

    @Override
    public void mostrarSala() {
        PresentadorSalaEspera presentador = new PresentadorSalaEspera();
        presentador.mostrarJugadores();
    }

    @Override
    public void mostrarPantallaSetIP() {
        this.view.setVisible(true);
    }

    @Override
    public void cerrarPantalla() {
        this.view.dispose();
    }

}
