/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketspruebafinal;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Nodo implements Runnable{
    
    private Servidor server;
    private Socket socket;
//    private List<Cliente> clientes;
    private SocketServidorDTO nodo;
    private List<SocketServidorDTO> nodos;

    public Nodo(ServerSocket servidor) throws IOException {
        this.server = new Servidor(servidor);
        this.nodo = new SocketServidorDTO(servidor.getInetAddress().toString(), servidor.getLocalPort());
        this.nodos = new LinkedList<>();
        Thread hilo = new Thread(this);
        hilo.start();
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public List<SocketServidorDTO> getNodos() {
        return nodos;
    }

    public void setNodos(List<SocketServidorDTO> nodos) {
        this.nodos = nodos;
    }

    public SocketServidorDTO getNodo() {
        return nodo;
    }

    public void setNodo(SocketServidorDTO nodo) {
        this.nodo = nodo;
    }

    public Servidor getServer() {
        return server;
    }

    public void setServer(Servidor server) {
        this.server = server;
    }
    
    public void leerDatos(){
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            
            in.readUTF();
        } catch (Exception e) {
        }
    }
    
    public void enviar(String texto) throws IOException {
        try {
            for (SocketServidorDTO nodo1 : nodos) {
                if (nodo1.getPuerto() != this.nodo.getPuerto()) {
                    Socket nuevo = new Socket(nodo1.getIp(), nodo1.getPuerto());
                    
                    DataOutputStream out = new DataOutputStream(nuevo.getOutputStream());
                    
                    out.writeUTF(texto);

                    this.socket.close();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void agregarNodo(SocketServidorDTO nuevoNodo) {
        try {
            if (nodos.isEmpty()) {
                this.nodos.add(this.nodo);
            } else {
                for (SocketServidorDTO nodo1 : nodos) {
                    if (nodo1.getPuerto() == nuevoNodo.getPuerto()) {
                        break;
                    } else {
                        this.nodos.add(nuevoNodo);
                    }
                    System.out.println("-----------------");
                    System.out.println("Puerto: " + nodo1.getPuerto());
                    System.out.println("-----------------");
                    System.out.println("");
                }
            }
            this.regresarInformacionSocket(nuevoNodo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void regresarInformacionSocket(SocketServidorDTO nodo) {
        try {
            this.socket = new Socket(nodo.getIp(), nodo.getPuerto());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(this.nodo);
            out.close();
            this.socket.close();
            this.socket = null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Esperando conexión de cliente...");

                Socket socketConectado = this.server.getServer().accept();

                System.out.println("Cliente conectado");

                ObjectInputStream in = new ObjectInputStream(socketConectado.getInputStream());

                SocketServidorDTO nodo = (SocketServidorDTO) in.readObject();

                System.out.println("Nodo con puerto servidor de: " + nodo.getPuerto() + " IP: " + nodo.getIp());
                this.agregarNodo(nodo);

                socketConectado.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
