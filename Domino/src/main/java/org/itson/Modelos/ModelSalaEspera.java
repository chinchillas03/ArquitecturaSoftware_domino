/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.Modelos;

import com.itson.dominio.Avatar;
import com.itson.implementacionesInterfaces.JugadorS;
import com.itson.interfacesJugador.JugadorSala;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Usuario
 */
public class ModelSalaEspera {
    
    private List<JugadorSala> jugadores;
    private List<Avatar> avatares;
    
    /**
     * Obtiene la lista de jugadores que están en la sala de espera.
     * @return 
     */
    public List<JugadorSala> getJugadores() {
        return jugadores;
    }

    public List<Avatar> getAvatares() {
        return avatares;
    }

    public void setAvatares(List<Avatar> avatares) {
        this.avatares = avatares;
    }

    /**
     * Inicializa la lista de jugadores en la sala de espera con jugadores predefinidos.
     * Esta función agrega jugadores a la lista de jugadores en la sala de espera.
     */
    public void setModel() {
        this.jugadores = new LinkedList<>();
        jugadores.add(new JugadorS("Diego"));
        jugadores.add(new JugadorS("Joel"));
        jugadores.add(new JugadorS("Pepe"));
        jugadores.add(new JugadorS("Paco"));       
        
        this.avatares = new LinkedList<>();
        avatares.add(new Avatar(new ImageIcon("/avatares/chemFuerte.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/doge.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/gato.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/hormiga.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/messiChiquito.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/pepe.png")));
    }

}
