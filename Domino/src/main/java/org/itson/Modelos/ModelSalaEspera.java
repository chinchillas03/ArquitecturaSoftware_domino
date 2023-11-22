/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.Modelos;

import com.itson.dominio.Avatar;
import com.itson.dominio.Jugador;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Usuario
 */
public class ModelSalaEspera {
    
    private List<Jugador> jugadores;
    private List<Avatar> avatares;
    
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

    /**
     * Inicializa la lista de jugadores en la sala de espera con jugadores predefinidos.
     * Esta función agrega jugadores a la lista de jugadores en la sala de espera.
     */
    public void setModel() {
        this.jugadores = new LinkedList<>();
        jugadores.add(new Jugador("Diego"));
        jugadores.add(new Jugador("Joel"));
        jugadores.add(new Jugador("Pepe"));
        jugadores.add(new Jugador("Paco"));    
       
        this.avatares = new LinkedList<>();
        avatares.add(new Avatar(new ImageIcon("/avatares/chemFuerte.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/doge.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/gato.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/hormiga.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/messiChiquito.png")));
        avatares.add(new Avatar(new ImageIcon("/avatares/pepe.png")));
        
    }

}
