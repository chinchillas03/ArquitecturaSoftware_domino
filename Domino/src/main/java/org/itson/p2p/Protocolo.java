/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.p2p;

import java.util.List;
import org.itson.dtos.InformacionServidorDTO;
import org.itson.listeners.ObservadorProtocolo;

/**
 *
 * @author Usuario
 */
public class Protocolo {
    
    private List<ObservadorProtocolo> observadores;

    public List<ObservadorProtocolo> getObservadores() {
        return observadores;
    }

    public void setObserver(ObservadorProtocolo observer) {
        this.observadores.add(observer);
    }
    
    public void procesarInformacion(Object objecto){
        if (objecto instanceof InformacionServidorDTO) {
            for (ObservadorProtocolo observadore : observadores) {
                observadore.regresarInformacion();
            }
        }
    }
    
}
