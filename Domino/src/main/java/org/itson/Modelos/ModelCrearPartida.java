/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.Modelos;

import com.itson.dominio.Partida;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ModelCrearPartida {
    
    private Integer cantidadFichas;
    
    public ModelCrearPartida(){            
    }

    public Integer getCantidadFichas() {
        return cantidadFichas;
    }

    public void setCantidadFichas(Integer cantidadFichas) {
        this.cantidadFichas = cantidadFichas;
    }
    
    public void crearPartida(){
        //codigo para crear partida
        Partida partida = new Partida();
    }
    
}
