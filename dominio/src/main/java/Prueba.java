
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Prueba {

    private String nombre;
    private int puntuacion;

    // Constructor, getters y setters
    public Prueba(String nombre, int puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public static void main(String[] args) {
        System.out.println("Gola");
        // Crear una ArrayList de objetos Jugador
        ArrayList<Prueba> listaJugadores = new ArrayList<>();

        // Agregar jugadores a la lista (asegúrate de inicializar el atributo puntuacion)
        listaJugadores.add(new Prueba("Jugador1", 5));
        listaJugadores.add(new Prueba("Jugador2", 3));
        listaJugadores.add(new Prueba("Jugador3", 8));
        // ... agregar más jugadores según sea necesario

        // Ordenar la lista por el atributo de puntuación
        Collections.sort(listaJugadores, new Comparator<Prueba>() {

            @Override
            public int compare(Prueba o1, Prueba o2) {
                // Comparar los jugadores por su atributo de puntuación
                return Integer.compare(o1.getPuntuacion(), o2.getPuntuacion());
            }
        });

        // Imprimir la lista ordenada
        for (Prueba jugador : listaJugadores) {
            System.out.println(jugador.getNombre() + ": " + jugador.getPuntuacion());
        }
    }
}
