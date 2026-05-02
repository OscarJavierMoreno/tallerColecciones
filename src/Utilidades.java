
public class Utilidades
{
    public static char verificacionNull(String input, char numeroOpcion)
    {
        if (input == null || input.isEmpty())
        {
            return numeroOpcion;
        }

        return  input.charAt(0);
    }
}
