/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.modelos;

import org.itson.p2p.Cliente;

/**
 *
 * @author aroco
 */
public class ModelConfigurarConexion {
    public int puerto;
    public String ip;

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public void setModel(String ip, int puerto){
        Cliente cliente = new Cliente();
        cliente.conectar(ip, puerto);
    }
    
}
