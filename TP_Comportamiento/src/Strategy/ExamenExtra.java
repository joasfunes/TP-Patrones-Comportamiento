package Strategy;

import java.util.List;

public class ExamenExtra implements CalculoNota{
    private final double pesoExamenExtra = 0.3;  // El examen extra vale 30% de la nota final
    private final double pesoPromedio = 0.7;    // El promedio de las notas vale 70%

    @Override
    public double calcular(List<Integer> notas) {
        if (notas.size() < 2) return 0.0; // Necesitamos al menos una nota regular y el examen extra
        // La última nota en la lista es el examen extra
        int examenExtra = notas.remove(notas.size() - 1);
        // Calcular promedio simple con las notas restantes
        double suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        double promedio = notas.isEmpty() ? 0 : suma / notas.size();
        // Calcular nota final
        return (promedio * pesoPromedio) + (examenExtra * pesoExamenExtra);
    }
}
