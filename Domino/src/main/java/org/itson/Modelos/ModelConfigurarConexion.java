/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.modelos;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.itson.dtos.UnirsePartidaDTO;
import org.itson.p2p.Cliente;
import org.itson.p2p.Servidor;
import org.itson.presentadores.PresentadorSalaEspera;

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
    
    public void setModel(String ip, int puerto,String nombre){       
        try {
            int puerto1 = 9998;
            Servidor servidor = new Servidor(puerto1);
            Cliente cliente = new Cliente();
            servidor.setCliente(cliente);
            cliente.setMiServer(servidor);
            cliente.conectar(ip, puerto, nombre);
            List<UnirsePartidaDTO> valores = new LinkedList<>();
            valores.add(new UnirsePartidaDTO(nombre));
            PresentadorSalaEspera pres = new PresentadorSalaEspera();
            pres.setCliente(cliente);
            pres.suscribirseListener();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
