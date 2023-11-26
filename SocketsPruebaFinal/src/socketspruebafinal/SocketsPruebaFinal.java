/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socketspruebafinal;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class SocketsPruebaFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        try {
            
            int puerto2 = 9998;
            ServerSocket nuevoServer = new ServerSocket(puerto2);
            Nodo nodoNuevo = new Nodo(nuevoServer);
            Socket socket = new Socket("localhost", 9999);
            SocketServidorDTO servidorDTO2 = new SocketServidorDTO("localhost", puerto2);
            nodoNuevo.setNodo(servidorDTO2);
            nodoNuevo.setSocket(socket);
            Vista vista = new Vista(nodoNuevo);
            vista.setVisible(true);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            
            out.writeObject(servidorDTO2);
            
            out.close();

        } catch (Exception e) {
        }
    }

}
