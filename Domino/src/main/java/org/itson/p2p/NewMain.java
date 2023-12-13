/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.p2p;

/**
 *
 * @author Usuario
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            int puerto = 9999;
            Servidor servidor = new Servidor(puerto);
            
            Cliente cliente = new Cliente();
            servidor.setCliente(cliente);
            cliente.setMiServer(servidor);
            
        } catch (Exception e) {
        }
    }
    
}
