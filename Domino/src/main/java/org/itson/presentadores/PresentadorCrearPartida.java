/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.presentadores;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.itson.listeners.CrearPartidaListener;
import org.itson.Modelos.ModelCrearPartida;
import org.itson.dtos.UnirsePartidaDTO;
import org.itson.frames.FrmCrearPartida;
import org.itson.p2p.Cliente;
import org.itson.p2p.Servidor;

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
    public void clickCrearPartida(Integer cantidadFichas) {
        // Seteo valor de fichas del modelo
        this.modelo.crearPartida(cantidadFichas);   
        
        //Cierro mi vista
        this.cerrarPantallaCrearPartida();
        
        //Hablo al siguiente presentadorra
        this.mostrarPantallaSalaEspera();
        
        try {
            int puerto1 = 9999;
            Servidor servidor = new Servidor(puerto1);
            Cliente cliente = new Cliente();
            servidor.setCliente(cliente);
            cliente.setMiServer(servidor);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }        
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
        List<UnirsePartidaDTO> valores = new LinkedList<>();
        valores.add(new UnirsePartidaDTO(modelo.getNombre()));
        new PresentadorSalaEspera(valores);
    }
    public void setNombreJugador(String nombre){
       this.modelo.setNombreJugador(nombre);
    }
    private void pasarPantallaInicio(){
        this.cerrarPantallaCrearPartida();
        new PresentadorInicio().mostrarPantallaInicio();
    }
    
}
