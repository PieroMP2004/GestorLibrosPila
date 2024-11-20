import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PilaLibros {
    private ArrayList<Libro> libros;

    public PilaLibros() {
        libros = new ArrayList<>();
    }

    // Insertar libro
    public void insertar(Libro libro) {
        libros.add(libro);
    }

    // Buscar libro por código
    public Libro buscarPorCodigo(int codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo() == codigo) {
                return libro;
            }
        }
        return null;
    }

    // Eliminar libro por código
    public boolean eliminarPorCodigo(int codigo) {
        Libro libroAEliminar = buscarPorCodigo(codigo);
        if (libroAEliminar != null) {
            libros.remove(libroAEliminar);
            return true;
        }
        return false;
    }

    // Ordenar por autor descendente
    public void ordenarPorAutorDescendente() {
        Collections.sort(libros, new Comparator<Libro>() {
            @Override
            public int compare(Libro l1, Libro l2) {
                return l2.getAutor().compareTo(l1.getAutor());
            }
        });
    }

    // Obtener todos los libros
    public ArrayList<Libro> obtenerLibros() {
        return libros;
    }
}
