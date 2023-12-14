/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.presentadores;

import org.itson.frames.FrmConexion;
import org.itson.listeners.ConexionListener;
import org.itson.listeners.ObservadorProtocolo;
import org.itson.modelos.ModelConfigurarConexion;
import org.itson.p2p.Protocolo;

/**
 *
 * @author aroco
 */
public class PresentadorConfigurarConexion implements ConexionListener, ObservadorProtocolo {

    private final FrmConexion view = new FrmConexion();
    private ModelConfigurarConexion model = new ModelConfigurarConexion();
    private Protocolo protocolo = new Protocolo();

    public PresentadorConfigurarConexion() {
        this.view.setListener(this);
        this.protocolo.setObserver(this);
    }

    @Override
    public void clickBotonUnirse(String ip, int puerto) {
        model.setModel(ip, puerto);
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

    @Override
    public void regresarInformacion() {
        
    }

}
