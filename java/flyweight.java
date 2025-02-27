import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Clase que representa el tipo de luchador (Flyweight)
class TipoLuchador {
    private String nombre;
    private String estilo;
    private String poder;

    public TipoLuchador(String nombre, String estilo, String poder) {
        this.nombre = nombre;
        this.estilo = estilo;
        this.poder = poder;
    }

    public void mostrar(int vida, int x, int y) {
        System.out.println("Mostrando " + nombre + " (" + estilo + ", Poder: " + poder +
                           ") con vida " + vida + " en (" + x + ", " + y + ")");
    }
}

// Fabrica que gestiona los tipos de luchadores (Flyweight Factory)
class FabricaLuchadores {
    private static Map<String, TipoLuchador> tipos = new HashMap<>();

    public static TipoLuchador obtenerTipoLuchador(String nombre, String estilo, String poder) {
        String clave = nombre + "-" + estilo + "-" + poder;
        if (!tipos.containsKey(clave)) {
            System.out.println("Creando nuevo tipo de luchador: " + nombre +
                               " (" + estilo + ", Poder: " + poder + ")");
            tipos.put(clave, new TipoLuchador(nombre, estilo, poder));
        }
        return tipos.get(clave);
    }
}

// Clase Luchador que usa un TipoLuchador para dibujarse
class Luchador {
    private TipoLuchador tipo;
    private int vida;
    private int x;
    private int y;

    public Luchador(TipoLuchador tipo, int vida, int x, int y) {
        this.tipo = tipo;
        this.vida = vida;
        this.x = x;
        this.y = y;
    }

    public void dibujar() {
        tipo.mostrar(vida, x, y);
    }
}

// Clase pública con el método main (nombre del archivo: flyweight.java)
public class flyweight {
    public static void main(String[] args) {
        // Creación de tipos de luchadores (Flyweights)
        TipoLuchador ninja = FabricaLuchadores.obtenerTipoLuchador("Ryu", "Karate", "Hadouken");
        TipoLuchador samurai = FabricaLuchadores.obtenerTipoLuchador("Hanzo", "Kenjutsu", "Corte Relámpago");

        // Creación de luchadores con diferentes posiciones y vida
        List<Luchador> luchadores = new ArrayList<>();
        luchadores.add(new Luchador(ninja, 100, 10, 20));
        luchadores.add(new Luchador(samurai, 120, 30, 40));
        luchadores.add(new Luchador(ninja, 90, 50, 60));
        luchadores.add(new Luchador(samurai, 110, 70, 80));

        // Dibujar a cada luchador
        for (Luchador luchador : luchadores) {
            luchador.dibujar();
        }
    }
}
