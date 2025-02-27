import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// Clase que representa una canción
class Cancion {
    private String titulo;
    private String artista;

    public Cancion(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "\"" + titulo + "\" de " + artista;
    }
}

// Iterador para la lista de reproducción
class ListaReproduccionIterator implements Iterator<Cancion> {
    private List<Cancion> canciones;
    private int indice;

    public ListaReproduccionIterator(List<Cancion> canciones) {
        this.canciones = canciones;
        this.indice = 0;
    }

    @Override
    public boolean hasNext() {
        return indice < canciones.size();
    }

    @Override
    public Cancion next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Cancion cancion = canciones.get(indice);
        indice++;
        return cancion;
    }
}

// Clase que representa una lista de reproducción (Iterable)
class ListaReproduccion implements Iterable<Cancion> {
    private List<Cancion> canciones;

    public ListaReproduccion() {
        canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    @Override
    public Iterator<Cancion> iterator() {
        return new ListaReproduccionIterator(canciones);
    }
}

// Clase pública con el método main
public class interator {
    public static void main(String[] args) {
        ListaReproduccion playlist = new ListaReproduccion();
        playlist.agregarCancion(new Cancion("Bohemian Rhapsody", "Queen"));
        playlist.agregarCancion(new Cancion("Smells Like Teen Spirit", "Nirvana"));
        playlist.agregarCancion(new Cancion("Hotel California", "Eagles"));

        // Iterar sobre la lista de reproducción e imprimir cada canción
        for (Cancion cancion : playlist) {
            System.out.println(cancion);
        }
    }
}
