/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.presentadores;

import java.util.LinkedList;
import java.util.List;
import org.itson.dtos.UnirsePartidaDTO;
import org.itson.frames.FrmConexion;
import org.itson.listeners.ConexionListener;
import org.itson.modelos.ModelConfigurarConexion;

/**
 *
 * @author aroco
 */
public class PresentadorConfigurarConexion implements ConexionListener {

    private final FrmConexion view = new FrmConexion();
    private ModelConfigurarConexion model = new ModelConfigurarConexion();
    private String nombre;

    public PresentadorConfigurarConexion() {
        this.view.setListener(this);
    }

    @Override
    public void clickBotonUnirse(String ip, int puerto) {
        model.setModel(ip, puerto,nombre);
        this.mostrarSala();
        this.cerrarPantalla();
    }

    @Override
    public void clickBotonRegresar() {
        cerrarPantalla();
        new PresentadorInicio().mostrarPantallaInicio();
    }

    @Override
    public void mostrarPantallaSetIP() {
        System.out.println(nombre);
        this.view.setVisible(true);
    }

    @Override
    public void cerrarPantalla() {
        this.view.dispose();
    }

    public void setNombreJugador(String nombre) {
        this.nombre=nombre;
    }

    @Override
    public void mostrarSala() {       
    }

}
