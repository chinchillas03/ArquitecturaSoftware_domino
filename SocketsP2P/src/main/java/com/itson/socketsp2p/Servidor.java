/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.socketsp2p;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Servidor implements Runnable, Serializable{

    private ServerSocket server;
    private Cliente cliente;
    private SocketServidorDTO nodo;
    private Protocolo protocolo;
    
    public Servidor(int puerto) throws IOException {
        this.protocolo = new Protocolo();
        this.server = new ServerSocket(puerto);
        this.nodo = new SocketServidorDTO(server.getInetAddress().toString(), server.getLocalPort());
        Thread hilo = new Thread(this);
        hilo.start();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
    
    public void enviarNuevoNodoACliente(SocketServidorDTO nuevoNodo) {
        cliente.agregarNodo(nuevoNodo);
    }

    public void regresarInformacionANodo(SocketServidorDTO nuevoNodo) {
        List<SocketServidorDTO> nodos = cliente.getServidoresNodos();
        boolean entrada = true;
        try {
            for (SocketServidorDTO nodo : nodos) {
                if (nodo.getPuerto() == nuevoNodo.getPuerto() && nodo.getIp() == nuevoNodo.getIp()) {
                    entrada = false;
                }
            }

            while (entrada == true) {
                Socket nuevo = new Socket("localhost", nuevoNodo.getPuerto());

                SocketServidorDTO nodo
                        = new SocketServidorDTO(server.getInetAddress().toString(),
                                server.getLocalPort());

                ObjectOutputStream out = new ObjectOutputStream(nuevo.getOutputStream());
                out.writeObject(nodo);
                out.close();
            }
        } catch (IOException e) {
        }
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

                    if (entrada instanceof SocketServidorDTO) {
                        SocketServidorDTO nodoNuevo = (SocketServidorDTO) entrada;
                        System.out.println("Nodo con puerto servidor de: " + nodoNuevo.getPuerto() + " IP: " + nodoNuevo.getIp());

                        System.out.println("--------------------------------------------");
                        System.out.println("");

                        List<SocketServidorDTO> nodos = cliente.getServidoresNodos();

                        if (nodos.size() <= 0) {
                            nodos.add(this.nodo);
                        }
                        cliente.agregarNodo(nodoNuevo);
                        out.writeObject(nodos);

                        this.protocolo.nuevaConexion();

                    }
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                socketConectado.close();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
