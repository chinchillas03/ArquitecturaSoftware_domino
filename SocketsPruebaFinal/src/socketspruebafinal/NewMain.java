/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socketspruebafinal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;

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
            int puerto1 = 9999;
            Servidor servidor = new Servidor(puerto1);
            Cliente cliente = new Cliente();
            servidor.setCliente(cliente);
            cliente.setMiServer(servidor);
        } catch (Exception e) {
        }
    }

}
