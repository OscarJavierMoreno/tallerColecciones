import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ListaTareas
{
    static List<String> listaDeTareasPorHacer = new ArrayList<>();

    public static void main(String[] args)
    {
        char numeroOpcion;

        do
        {
            String input = JOptionPane.showInputDialog ("LISTA DE TAREAS\n" +
                    "1. Agregar nueva tarea\n" +
                    "2. Mostrar todas las tareas\n" +
                    "3. Marcar una tarea como completada\n" +
                    "4. Mostrar el número total de tareas pendientes\n" +
                    "5. Volver");

            numeroOpcion = Utilidades.verificacionNull(input, '5');

            switch (numeroOpcion)
            {
                case '1': agregarListaDeTarea(); break;
                case '2': JOptionPane.showMessageDialog(null,
                        mostrarListadoDeTareas()); break;
                case '3': tareasCompletadas(); break;
                case '4': tareasPendientes(); break;
                case '5': JOptionPane.showMessageDialog(null,
                        "Regresando al menu principal"); break;
                default: JOptionPane.showMessageDialog(null,
                        "Opción No valida"); break;
            }

        } while (numeroOpcion != '5');
    }

    public static void agregarListaDeTarea()
    {
        String tarea = JOptionPane.showInputDialog("Digite la tarea: ");
        listaDeTareasPorHacer.add(tarea);

        if (tarea == null || tarea.isEmpty()) return;

        JOptionPane.showMessageDialog(null,
                "Tarea agregada a la lista");
    }

    public static StringBuilder mostrarListadoDeTareas()
    {
        if (listaDeTareasPorHacer.isEmpty())
        {
            return new StringBuilder("SIN TAREAS");
        }

        StringBuilder taskList = new StringBuilder();
        int index = 1;

        for (String task : listaDeTareasPorHacer)
        {
            taskList.append(index).append(". ").append(task).append("\n");
            index ++;
        }

        return taskList;
    }

    public static void tareasCompletadas()
    {
        if (listaDeTareasPorHacer.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "No hay tareas pendientes");
            return;
        }

        String input = JOptionPane.showInputDialog(
                "SELECCIONE LA TAREA COMPLETADA:\n"
                        + mostrarListadoDeTareas());

        if (input == null || input.isEmpty()) return;

        int numeroDeTarea = Integer.parseInt(input);

        if (numeroDeTarea < 1 || numeroDeTarea > listaDeTareasPorHacer.size())
        {
            JOptionPane.showMessageDialog(null,
                    "Número inválido");
            return;
        }

        String removedTask = listaDeTareasPorHacer.remove(numeroDeTarea - 1);

        JOptionPane.showMessageDialog(null,
                "Tarea completada:\n" + removedTask);
    }

    public static void tareasPendientes()
    {
        JOptionPane.showMessageDialog(null,
                "Tienes un total de " + listaDeTareasPorHacer.size() +
                        " tareas pendientes");
    }
}
