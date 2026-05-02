import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        char numeroOpcion;

        do
        {
            String input = JOptionPane.showInputDialog(
                "Seleccione:\n" +
                        "1. Lista de tareas\n" +
                        "2. Biblioteca\n" +
                        "3. Directorio de trabajadores\n" +
                        "4. Salir");

            numeroOpcion = Utilidades.verificacionNull(input, '4');

            switch (numeroOpcion)
            {
                case '1': ListaTareas.main(null); break;
                case '2': LibrosBiblioteca.main(null); break;
                case '3': DirectorioTrabajadores.main(null); break;
                case '4': JOptionPane.showMessageDialog(null,
                        "Gracias por usar el programa"); break;
                default: JOptionPane.showMessageDialog(null,
                        "Opción No valida"); break;
            }

        } while (numeroOpcion != '4');
    }
}