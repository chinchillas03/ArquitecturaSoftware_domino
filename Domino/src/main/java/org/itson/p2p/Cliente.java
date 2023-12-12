/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.p2p;

import com.itson.socketsp2p.JugadorDTO;
import com.itson.socketsp2p.SocketServidorDTO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import org.itson.dtos.InformacionServidorDTO;

/**
 *
 * @author Usuario
 */
public class Cliente implements Runnable {

    private Socket socket;
    private JugadorDTO jugador;
    private Servidor miServer;
    private List<InformacionServidorDTO> servidoresNodos;

    public Cliente() {
        this.servidoresNodos = new LinkedList<>();
        Thread hilo = new Thread(this);
        hilo.start();
    }

    public List<InformacionServidorDTO> getServidoresNodos() {
        return servidoresNodos;
    }

    public void validarSocket(){
        if (this.socket == null) {
            this.socket = new Socket();
        }
    }
    
    public void setServidoresNodos(List<InformacionServidorDTO> servidoresNodos) {
        this.servidoresNodos = servidoresNodos;
    }

    public void agregarNodo(InformacionServidorDTO nuevoNodo) {
        this.servidoresNodos.add(nuevoNodo);
//        this.broadcast(nuevoNodo);
    }

    public void conectar(String ip, int puerto) {
        try {
            this.socket = new Socket(ip, puerto);
            setSocket(socket);

            InformacionServidorDTO nodo = new InformacionServidorDTO(miServer.getServer().getInetAddress().toString(), miServer.getServer().getLocalPort());

            ObjectOutputStream out = new ObjectOutputStream(this.socket.getOutputStream());

            out.writeObject(nodo);
            out.flush(); 

            ObjectInputStream in = new ObjectInputStream(this.socket.getInputStream());
            List<InformacionServidorDTO> nodosConocidos = (List<InformacionServidorDTO>) in.readObject();

            for (InformacionServidorDTO nodoConocido : nodosConocidos) {
                System.out.println("IP: " + nodoConocido.getIp() + ", Puerto: " + nodoConocido.getPuerto());
            }
            this.setServidoresNodos(nodosConocidos);

            in.close();
            out.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void broadcast(InformacionServidorDTO nuevoNodo) {
        try {
            for (InformacionServidorDTO servidoresNodo : servidoresNodos) {
                if (miServer.getServer().getInetAddress().toString().equals(servidoresNodo.getIp()) && miServer.getServer().getLocalPort() == servidoresNodo.getPuerto()) {
                } else {
                    String ip = servidoresNodo.getIp();
                    int puerto = servidoresNodo.getPuerto();
                    try (Socket socket = new Socket(servidoresNodo.getIp(), servidoresNodo.getPuerto()); ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

                        out.writeObject(nuevoNodo);
                    }
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

    public JugadorDTO getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDTO jugador) {
        this.jugador = jugador;
    }

    @Override
    public void run() {
        try {
            if (socket != null) {
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                SocketServidorDTO nodo = new SocketServidorDTO(miServer.getServer().getInetAddress().toString(), socket.getLocalPort());
                out.writeObject(nodo);
                out.flush(); // Agrega un flush después de escribir en el flujo

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                List<SocketServidorDTO> nodos = (List<SocketServidorDTO>) in.readObject();

                for (SocketServidorDTO nodo1 : nodos) {
                    System.out.println("Nodos con puerto: " + nodo1.getPuerto() + " IP: " + nodo1.getIp());
                }

                for (SocketServidorDTO nodo1 : nodos) {
                    if (!nodo1.getIp().equals(socket.getInetAddress().toString()) && nodo1.getPuerto() == socket.getLocalPort()) {

                    } else if (!"localhost".equals(nodo1.getIp()) && nodo1.getPuerto() == socket.getLocalPort()) {

                    } else {
                        Socket newSocket = new Socket("localhost", nodo1.getPuerto());
                        ObjectOutputStream newOut = new ObjectOutputStream(newSocket.getOutputStream());
                        newOut.writeObject(nodo);
                        newOut.flush();
                        newOut.close(); 

                        newSocket.close();
                    }
                }

                in.close();
                out.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

