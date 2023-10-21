/**
 * FrmTablero.java
 * Oct 19, 2023 11:03:38 PM
 */
package org.itson.frames;

import com.itson.dominio.FichaJuego;
import com.itson.dominio.Jugador;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.itson.Modelos.ModelTablero;
import org.itson.dibujo.Dibujante;
import org.itson.dibujo.FichaJugDibujo;
import org.itson.dibujo.Figuras;
import org.itson.dibujo.JugadorDibujo;

/**
 *
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public class FrmTablero extends JFrame {

    ModelTablero tablero;
    Dibujante dibujante;
    List<Figuras> figuras;
    JPanel panel;

    public FrmTablero(List<Jugador> listaJugadores, int cantidadFichas) {
        setTitle("Dibujando en JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
        this.paint(this.getGraphics());
    }

    @Override
    public void paint(Graphics g) {
        super.add(panel);
        super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
           iniciarPantalla(panel);
    }

    public static void main(String[] args) {
        List<Jugador> lista = new ArrayList<>();
        lista.add(new Jugador("Joel"));
        lista.add(new Jugador("Juan"));
        lista.add(new Jugador("Diego"));
        lista.add(new Jugador("Javier"));
        new FrmTablero(lista, 7).setVisible(true);
    }

    private void iniciarPantalla(JPanel panel) {
        Graphics g = panel.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 35, 1024, 40);
        g.setColor(Color.BLACK);
        g.fillRect(0, 715, 1024, 40);
        List<FichaJuego> listaJ = tablero.recuperaListaJugadores();
        this.figuras = List.of(
                new JugadorDibujo(25, 65, Color.DARK_GRAY),
                new JugadorDibujo(25, 585, Color.BLACK),
                new JugadorDibujo(830, 65, Color.GRAY),
                new JugadorDibujo(830, 585, Color.LIGHT_GRAY),
                new FichaJugDibujo(110, 600, listaJ)
        );
        dibujante = new Dibujante(panel);
        JButton btnAbandonar = new JButton("Abandonar Partida");
        btnAbandonar.setBounds(420, 590, 150, 30);
        panel.add(btnAbandonar);
        JScrollPane jscp = new JScrollPane();
        JButton btnPozo = new JButton("Jalar Pozo");
        btnPozo.setBounds(880, 450, 100, 30);
        panel.add(jscp);
        panel.add(btnPozo);
        dibujante.dibujarTodos(figuras);
//
//        panel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                // Obtiene las coordenadas del clic
//                System.out.println(e.getX());
//                System.out.println(e.getY());
//                for (int i = 0; i < figuras.size(); i++) {
//                    System.out.println(listaJ.get(i).getX());
//                    System.out.println(listaJ.get(i).getY());
//                    if (e.getX() == listaJ.get(i).getX() && e.getY() == listaJ.get(i).getY()) {
//                        System.out.println(listaJ.get(i));
//                    }
//                }
//                int x = e.getX();
//                int y = e.getY();
//            }
//        });

//        btnPozo.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Acción a realizar cuando se hace clic en el botón
//                JOptionPane.showMessageDialog(null, "Soy el pozo");
//            }
//        });
//        btnAbandonar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Acción a realizar cuando se hace clic en el botón
//                JOptionPane.showMessageDialog(null, "¡Botón clickeado!");
//            }
//        });
    }

}
