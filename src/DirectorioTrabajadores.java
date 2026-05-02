import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class DirectorioTrabajadores
{
    static Map<String, Double> listaTrabajadores = new HashMap<>();

    public static void main(String[] args)
    {
        char opcion;

        do
        {
            opcion = JOptionPane.showInputDialog(
                    "DIRECTORIO DE TRABAJADORES\n" +
                            "1. Agregar trabajador\n" +
                            "2. Mostrar trabajadores\n" +
                            "3. Actualizar salario\n" +
                            "4. Salario promedio\n" +
                            "5. Volver"
            ).charAt(0);

            switch (opcion) {
                case '1': agregarTrabajador(); break;
                case '2': mostrarTrabajadores(); break;
                case '3': actualizarSalario(); break;
                case '4': salarioPromedio(); break;
                case '5': JOptionPane.showMessageDialog(null,
                        "Regresando al menu principal");
                default: JOptionPane.showMessageDialog(null,
                        "Opción No valida");
                    break;
            }

        } while (opcion != '5');
    }

    static void agregarTrabajador()
    {
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String salarioStr = JOptionPane.showInputDialog("Salario:");

        try
        {
            double salario = Double.parseDouble(salarioStr);
            listaTrabajadores.put(nombre, salario);

            JOptionPane.showMessageDialog(null,
                    "Trabajador agregado");
        }

        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,
                    "Salario inválido");
        }
    }

    static void mostrarTrabajadores()
    {
        if (listaTrabajadores.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "No hay trabajadores");
            return;
        }

        StringBuilder sb = new StringBuilder("TRABAJADORES:\n");

        for (Map.Entry<String, Double> entry : listaTrabajadores.entrySet())
        {
            sb.append(entry.getKey())
                    .append(" -> $")
                    .append(entry.getValue())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    static void actualizarSalario()
    {
        String nombre = JOptionPane.showInputDialog("Trabajador:");

        if (!listaTrabajadores.containsKey(nombre))
        {
            JOptionPane.showMessageDialog(null,
                    "Trabajador NO encontrado");
            return;
        }

        String salarioStr = JOptionPane.showInputDialog("Nuevo salario:");

        try
        {
            double salario = Double.parseDouble(salarioStr);
            listaTrabajadores.put(nombre, salario);

            JOptionPane.showMessageDialog(null,
                    "Salario actualizado");
        }

        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Dato inválido");
        }
    }

    static void salarioPromedio()
    {
        if (listaTrabajadores.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No hay datos");
            return;
        }

        double suma = 0;

        for (double salario : listaTrabajadores.values())
        {
            suma += salario;
        }

        double promedio = suma / listaTrabajadores.size();

        JOptionPane.showMessageDialog(null,
                "Salario promedio: $" + promedio);
    }
}
