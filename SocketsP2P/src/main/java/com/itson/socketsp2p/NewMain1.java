/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.itson.socketsp2p;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        try {
            
            int puerto1 = 9998;
            
            Servidor servidor = new Servidor(puerto1);
            Cliente cliente = new Cliente();
            servidor.setCliente(cliente);
            
            cliente.setMiServer(servidor);
            String ip = "192.168.1.66";
            int puerto = 9999;
            
            cliente.conectar(ip, puerto);
            
        } catch (IOException e) {
        }
    }
    
}
