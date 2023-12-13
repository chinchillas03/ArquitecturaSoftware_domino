/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.p2p;

import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class NewMain3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            int puerto = 9996;
            Servidor servidor = new Servidor(puerto);
            
            Cliente cliente = new Cliente();
            int puertoServidor = 9997;
            servidor.setCliente(cliente);
            cliente.setMiServer(servidor);
            
            cliente.conectar("192.168.1.66", puertoServidor);
            
        } catch (IOException e) {
        }
    }
    
}
