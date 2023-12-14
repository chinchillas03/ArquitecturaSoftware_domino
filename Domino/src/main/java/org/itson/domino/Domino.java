/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.itson.domino;

import java.io.IOException;
import org.itson.presentadores.PresentadorInicio;
import javax.swing.SwingUtilities;
import org.itson.p2p.Cliente;
import org.itson.p2p.Servidor;

/**
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public class Domino {

    public Domino (){
        new PresentadorInicio().mostrarPantallaInicio();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    int puerto1 = 9999;
                    Servidor servidor = new Servidor(puerto1);
                    Cliente cliente = new Cliente();
                    servidor.setCliente(cliente);
                    cliente.setMiServer(servidor);
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                new Domino();
            }
        });
    }
}
