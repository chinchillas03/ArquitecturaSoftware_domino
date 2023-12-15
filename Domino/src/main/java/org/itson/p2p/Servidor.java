/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.p2p;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import org.itson.dtos.ConexionSalaEsperaDTO;

/**
 *
 * @author Usuario
 */
public class Servidor implements Runnable{

    private ServerSocket server;
    private Cliente cliente;
    private ConexionSalaEsperaDTO nodo;
    private Protocolo protocolo;
    
    public Servidor(int puerto) throws IOException {
        this.protocolo = new Protocolo();
        this.server = new ServerSocket(puerto);
        this.nodo = new ConexionSalaEsperaDTO(server.getInetAddress().toString(), server.getLocalPort());
        Thread hilo = new Thread(this);
        hilo.start();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ConexionSalaEsperaDTO getNodo() {
        return nodo;
    }

    public void setNodo(ConexionSalaEsperaDTO nodo) {
        this.nodo = nodo;
    }

    public Servidor(ServerSocket server) {
        this.server = server;
    }

    public ServerSocket getServer() {
        return server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }
    
    public void enviarNuevoNodoACliente(ConexionSalaEsperaDTO nuevoNodo) {
        cliente.agregarNodo(nuevoNodo);
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("--------------------------------------------");
                System.out.println("Esperando conexión de cliente...");
                Socket socketConectado = this.server.accept();
                System.out.println("Cliente conectado");
                ObjectInputStream in = new ObjectInputStream(socketConectado.getInputStream());
                try {
                    ObjectOutputStream out = new ObjectOutputStream(socketConectado.getOutputStream());
                    Object entrada = in.readObject();       
                    String evento = protocolo.procesarInformacion(entrada);
                    if (evento.equals("CONEXION")) {
                        ConexionSalaEsperaDTO nodoNuevo = (ConexionSalaEsperaDTO) entrada;
                        System.out.println("Nodo con puerto servidor de: " + nodoNuevo.getPuerto() + " IP: " + nodoNuevo.getIp());
                        System.out.println("--------------------------------------------");
                        System.out.println("");
                        List<ConexionSalaEsperaDTO> nodos = cliente.getServidoresNodos();
                        if (nodos.size() <= 0) {
                            nodos.add(this.nodo);
                        }
                        cliente.agregarNodo(nodoNuevo);
                        out.writeObject(nodos);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

