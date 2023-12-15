/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.p2p;

import org.itson.dtos.UniserPartidaDTO;

/**
 *
 * @author Usuario
 */
public class Protocolo {
  
    private String evento = "ESPERANDO";
    
    public String procesarInformacion(Object objecto){
        if (objecto instanceof UniserPartidaDTO) {
            evento = "CONEXION";
            return evento;
        } else if(true){
            return evento;
        }
        return evento;
    }
    
}
