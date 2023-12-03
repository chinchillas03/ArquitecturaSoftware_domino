/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socketspruebafinal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class NewMain2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        try {
            
            int puerto1 = 9996;
            Servidor servidor = new Servidor(puerto1);
            Cliente cliente = new Cliente();
            servidor.setCliente(cliente);
            
            cliente.setMiServer(servidor);
            Socket socket = new Socket("192.168.1.66", 9999);
            cliente.setSocket(socket);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            SocketServidorDTO nodo = new SocketServidorDTO(servidor.getServer().getInetAddress().toString(), puerto1);
            out.writeObject(nodo);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            List<SocketServidorDTO> nodos = (List<SocketServidorDTO>) in.readObject();

            for (SocketServidorDTO nodo1 : nodos) {
                System.out.println("Nodos con puerto: " + nodo1.getPuerto() + "IP: " + nodo1.getIp());
            }
            
            in.close();
            out.close();

        } catch (IOException e) {
        }
    }
    
}
