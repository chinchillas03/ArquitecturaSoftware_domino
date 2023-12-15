/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.Modelos;

import com.itson.dominio.Avatar;
import com.itson.dominio.Jugador;
import com.itson.dominio.Partida;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import org.itson.dtos.UnirsePartidaDTO;

/**
 *
 * @author Usuario
 */
public class ModelSalaEspera {
    
    private List<Jugador> jugadores;
    private List<Avatar> avatares;
    private Partida partida= Partida.instancia();
    /**
     * Obtiene la lista de jugadores que están en la sala de espera.
     * @return 
     */
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public List<Avatar> getAvatares() {
        return avatares;
    }

    public void setAvatares(List<Avatar> avatares) {
        this.avatares = avatares;
    }
    public int getCantidadFichas(){
        return partida.getNumCantidadFichas();
    }

    /**
     * Inicializa la lista de jugadores en la sala de espera con jugadores predefinidos.
     * Esta función agrega jugadores a la lista de jugadores en la sala de espera.
     */
    public void setModel(List<UnirsePartidaDTO> valores) {
        this.jugadores = new LinkedList<>();
        int contador = 0;
        for (UnirsePartidaDTO valore : valores) {
            if (contador == 0) {
                jugadores.add(new Jugador(valore.getNombreJugador()));
                contador++;
            } else if (contador == 1) {
                jugadores.add(new Jugador(valore.getNombreJugador()));
                contador++;
            } else if (contador == 2) {
                jugadores.add(new Jugador(valore.getNombreJugador()));
                contador++;
            } else if (contador == 3) {
                jugadores.add(new Jugador(valore.getNombreJugador()));
                contador++;
            }

        }
        this.avatares = new LinkedList<>();
        avatares.add(new Avatar(new ImageIcon("*/avatares/chemFuerte.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/doge.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/gato.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/hormiga.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/messiChiquito.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/pepe.png")));

    }

}
