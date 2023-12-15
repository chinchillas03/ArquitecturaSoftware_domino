/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.p2p;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import org.itson.dtos.ConexionSalaEsperaDTO;
import org.itson.dtos.JugadorDTO;
import org.itson.listeners.Observador;

/**
 *
 * @author Usuario
 */
public class Cliente implements Runnable {

    private Socket socket;
    private Socket socket2;
    private Socket socket3;
    private JugadorDTO jugador;
    private Servidor miServer;
    private List<ConexionSalaEsperaDTO> servidoresNodos;
    private List<Observador> observadores;

    public Cliente() {
        this.servidoresNodos = new LinkedList<>();
        Thread hilo = new Thread(this);
        hilo.start();
    }

    public void suscribirse(Observador observar){
        this.observadores.add(observar);
    }
    
    public List<ConexionSalaEsperaDTO> getServidoresNodos() {
        return servidoresNodos;
    }

    public void validarSocket(){
        if (this.socket == null) {
            this.socket = new Socket();
        }
    }
    
    public void setServidoresNodos(List<ConexionSalaEsperaDTO> servidoresNodos) {
        this.servidoresNodos = servidoresNodos;
    }

    public void agregarNodo(ConexionSalaEsperaDTO nuevoNodo) {
        this.servidoresNodos.add(nuevoNodo);
    }

    public void conectar(String ip, int puerto) {
        try {
            this.socket = new Socket(ip, puerto);
            setSocket(socket);
            ConexionSalaEsperaDTO nodo = new ConexionSalaEsperaDTO(miServer.getServer().getInetAddress().toString(), miServer.getServer().getLocalPort());
            ObjectOutputStream out = new ObjectOutputStream(this.socket.getOutputStream());
            out.writeObject(nodo);
            out.flush();
            ObjectInputStream in = new ObjectInputStream(this.socket.getInputStream());
            List<ConexionSalaEsperaDTO> nodosConocidos = (List<ConexionSalaEsperaDTO>) in.readObject();
            for (ConexionSalaEsperaDTO nodoConocido : nodosConocidos) {
                System.out.println("IP: " + nodoConocido.getIp() + ", Puerto: " + nodoConocido.getPuerto());
            }
            this.setServidoresNodos(nodosConocidos);            
            ConexionSalaEsperaDTO nodoPrincipal = new ConexionSalaEsperaDTO(ip, puerto);            
            this.conectarOtrosNodos(nodoPrincipal);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void conectarOtrosNodos(ConexionSalaEsperaDTO nodoPrincipal) {
        try {
            for (ConexionSalaEsperaDTO servidoresNodo : servidoresNodos) {
                if (servidoresNodo.getPuerto() == this.miServer.getNodo().getPuerto()) {
                } else if (servidoresNodo.getPuerto() == nodoPrincipal.getPuerto()) {
                } else {
                    String ip = "192.168.1.66";
                    int puerto = servidoresNodo.getPuerto();
                    ConexionSalaEsperaDTO dat = miServer.getNodo();
                    if (socket2 == null) {
                        socket2 = new Socket(ip, puerto);
                        ObjectOutputStream out = new ObjectOutputStream(socket2.getOutputStream());
                        out.writeObject(dat);
                    } else if (socket3 == null) {
                        socket3 = new Socket(ip, puerto);
                        ObjectOutputStream out = new ObjectOutputStream(socket3.getOutputStream());
                        out.writeObject(dat);
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
    }
}

