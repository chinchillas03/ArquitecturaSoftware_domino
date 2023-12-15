/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.p2p;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import org.itson.dtos.ConexionSalaEsperaDTO;

/**
 *
 * @author Usuario
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            int puerto = 9998;
            Servidor servidor = new Servidor(puerto);
            
            Cliente cliente = new Cliente();
            int puertoServidor = 9999;
            servidor.setCliente(cliente);
            cliente.setMiServer(servidor);
            
            cliente.conectar("192.168.1.66", puertoServidor);
            
        } catch (IOException e) {
        }
    }
    
}
