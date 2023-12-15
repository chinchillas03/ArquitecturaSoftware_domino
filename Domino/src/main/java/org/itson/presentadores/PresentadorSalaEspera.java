/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.presentadores;

import com.itson.dominio.Avatar;
import com.itson.dominio.Jugador;
import org.itson.listeners.SalaEsperaListener;
import java.util.List;
import org.itson.Modelos.ModelSalaEspera;
import org.itson.dtos.UnirsePartidaDTO;
import org.itson.frames.FrmSalaEspera;
import org.itson.listeners.Observador;
import org.itson.p2p.Cliente;

/**
 *
 * @author Usuario
 */
public class PresentadorSalaEspera implements SalaEsperaListener, Observador{

    private final FrmSalaEspera view = new FrmSalaEspera();
    private final ModelSalaEspera model = new ModelSalaEspera();
    private Cliente cliente = new Cliente();
    
    /**
     * Constructor de la clase PresentadorSalaEspera.
     * Inicializa la clase, se suscribe a los eventos de la vista de sala de espera, configura a los jugadores y muestra la lista de jugadores.
     */
    public PresentadorSalaEspera() {
        this.view.repaint();
        this.setPresenter();
    }
    
    public PresentadorSalaEspera(List<UnirsePartidaDTO> valores){
        this.setearValoresSalaEspera(valores);            
        this.setPresenter();
        this.cliente.suscribirse(this);
        this.view.repaint();
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    /**
     * Maneja el evento de hacer clic en el botón "Iniciar Partida" en la sala de espera.
     * Cierra la pantalla de sala de espera y muestra la pantalla de partida, pasando la información de los jugadores y la cantidad de fichas.
     */
    @Override
    public void clickBotonIniciarPartida() {
        this.cerrarPantallaSalaEspera();
        PresentadorPartida presentador = new PresentadorPartida();
        presentador.setModelPartida(this.model.getJugadores());
    }

    /**
     * Maneja el evento de hacer clic en el botón "Salir de la Partida" en la sala de espera.
     * Cierra la pantalla de sala de espera y vuelve a la pantalla de inicio.
     */
    @Override
    public void clickBotonSalirPartida() {
        this.cerrarPantallaSalaEspera();
        new PresentadorInicio().mostrarPantallaInicio();
    }

    public void suscribirseListener() {
        this.cliente.suscribirse(this);
    }
    
    /**
     * Muestra la lista de jugadores en la sala de espera.
     */
    @Override
    public void mostrarJugadores() {
        List<Jugador> jugadores = this.model.getJugadores();
        int contador = 0;
        for (Jugador jugadore : jugadores) {
            if (contador == 0) {
                this.view.setLblNombreJugador1(jugadore.getNombre());
                contador++;
            } else if (contador == 1) {
                this.view.setLblNombreJugador2(jugadore.getNombre());
                contador++;
            } else if (contador == 2) {

                this.view.setLblNombreJugador3(jugadore.getNombre());
            } else if (contador == 3) {

                this.view.setLblNombreJugador4(jugadore.getNombre());
                contador++;
            }
        }
        this.cargarCombosAvatares();
    }
    
    public void cargarCombosAvatares(){
        List<Avatar> avatares = this.model.getAvatares();
        this.view.setCmbAvatarJugador1(avatares);
        this.view.setCmbAvatarJugador2(avatares);
        this.view.setCmbAvatarJugador3(avatares);
        this.view.setCmbAvatarJugador4(avatares);
    }
    
    private void setPresenter(){
        this.view.setListener(this);
    }

    /**
     * Cierra la pantalla de sala de espera.
     */
    public void cerrarPantallaSalaEspera() {
        this.view.cerrarPantallaSalaEspera();
    }
    
    /**
     * Muestra la pantalla de sala de espera.
     */
    public void mostrarPantallaSalaEspera() {
        this.view.mostrarPantallaSalaEspera();
    }

    @Override
    public void setearValoresSalaEspera(List<UnirsePartidaDTO> valores) {
        this.model.setModel(valores);
        this.mostrarJugadores();
        this.mostrarPantallaSalaEspera();
    }

    @Override
    public void enviarFicha() {
    }

    @Override
    public void cambiarAvatar() {
    }

    @Override
    public void salir() {
    }

    @Override
    public void mostrarMarcador() {
    }

    @Override
    public void salirTodos() {
    }

    @Override
    public void jalarPozo() {
    }

    @Override
    public void pasarTurno() {
    }
}