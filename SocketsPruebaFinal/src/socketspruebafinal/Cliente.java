/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketspruebafinal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Cliente implements Serializable, Runnable{
    
    private Socket socket;
    private Jugador jugador;
    private Servidor miServer;
    private List<SocketServidorDTO> servidoresNodos;

    public Cliente() {
        this.servidoresNodos = new LinkedList<>();
        Thread hilo = new Thread(this);
        hilo.start();
    }

    public List<SocketServidorDTO> getServidoresNodos() {
        return servidoresNodos;
    }

    public void setServidoresNodos(List<SocketServidorDTO> servidoresNodos) {
        this.servidoresNodos = servidoresNodos;
    }

    public void agregarNodo(SocketServidorDTO nuevoNodo){
        this.servidoresNodos.add(nuevoNodo);
        this.broadcast(nuevoNodo);
    }    
    
    public void broadcast(SocketServidorDTO nuevoNodo){
        try {
            for (SocketServidorDTO servidoresNodo : servidoresNodos) {
                if (miServer.getServer().getInetAddress().toString().equals(servidoresNodo.getIp()) && miServer.getServer().getLocalPort() == servidoresNodo.getPuerto()) {                    
                }else{
                    this.socket = new Socket(servidoresNodo.getIp(), servidoresNodo.getPuerto());
                    
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    
                    out.writeObject(nuevoNodo);
                    
                    out.close();
                    
                    this.socket.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public Servidor getMiServer() {
        return miServer;
    }

    public void setMiServer(Servidor miServer) {
        this.miServer = miServer;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket1) {
        this.socket = socket1;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void run() {
        try {
            this.socket = getSocket();

            if (socket != null) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                List<SocketServidorDTO> nodos = (List<SocketServidorDTO>) in.readObject();

                this.setServidoresNodos(nodos);

                in.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
