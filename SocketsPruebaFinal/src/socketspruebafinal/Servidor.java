/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketspruebafinal;

import java.net.ServerSocket;

/**
 *
 * @author Usuario
 */
public class Servidor {
    
    private int puerto;
    private ServerSocket server;
    private Partida partida;

    public Servidor() {
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

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    
}
