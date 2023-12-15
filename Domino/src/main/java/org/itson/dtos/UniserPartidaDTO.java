/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dtos;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class UniserPartidaDTO implements Serializable {

    private String ip;
    private int puerto;
    private String nombreJugador;

    public UniserPartidaDTO() {
    }

    public UniserPartidaDTO(String ip, int puerto) {
        this.ip = ip;
        this.puerto = puerto;
    }

    public UniserPartidaDTO(String ip, int puerto, String nombreJugador) {
        this.ip = ip;
        this.puerto = puerto;
        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }
}
