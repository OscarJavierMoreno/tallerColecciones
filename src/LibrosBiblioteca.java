import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class LibrosBiblioteca
{
    static Set<String> libros = new HashSet<>();

    public static void main(String[] args)
    {
        char opcion;

        do
        {
            String input = JOptionPane.showInputDialog(
                    "BIBLIOTECA\n" +
                            "1. Agregar libro\n" +
                            "2. Mostrar libros\n" +
                            "3. Buscar libro\n" +
                            "4. Total libros\n" +
                            "5. Volver"
                    );

            opcion = Utilidades.verificacionNull(input, '5');

            switch (opcion) {
                case '1': agregarLibro(); break;
                case '2': mostrarLibros(); break;
                case '3': buscarLibro(); break;
                case '4': totalLibros(); break;
                case '5': JOptionPane.showMessageDialog(null,
                        "Regresando al menu principal"); break;
                default: JOptionPane.showMessageDialog(null,
                        "Opción No valida"); break;
            }

        } while (opcion != '5');
    }

    static void agregarLibro()
    {
        String libro = JOptionPane.showInputDialog("Nombre del libro:");

        if (libro == null || libro.isEmpty()) return;

        if (libros.add(libro))
        {
            JOptionPane.showMessageDialog(null, "Libro agregado");
        }

        else
        {
            JOptionPane.showMessageDialog(null, "Ese libro ya existe");
        }
    }

    static void mostrarLibros()
    {
        if (libros.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No hay libros");
            return;
        }

        StringBuilder sb = new StringBuilder("LIBROS:\n");

        for (String libro : libros)
        {
            sb.append("- ").append(libro).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    static void buscarLibro()
    {
        String libro = JOptionPane.showInputDialog("Libro a buscar:");

        if (libros.contains(libro))
        {
            JOptionPane.showMessageDialog(null, "Sí está disponible");
        }

        else
        {
            JOptionPane.showMessageDialog(null, "No está en la biblioteca");
        }
    }

    static void totalLibros()
    {
        JOptionPane.showMessageDialog(null,
                "Total libros únicos: " + libros.size());
    }
}
