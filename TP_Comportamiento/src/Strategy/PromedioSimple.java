package Strategy;

import java.util.List;

public class PromedioSimple implements CalculoNota{
    @Override
    public double calcular(List<Integer> notas) {
        if (notas.isEmpty()) return 0.0;
        double suma = 0;
        for (int nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }
}
