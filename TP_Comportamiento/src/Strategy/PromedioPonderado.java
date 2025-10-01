package Strategy;

import java.util.List;

public class PromedioPonderado implements CalculoNota{
    // Pesos para cada nota (ej: primera nota vale 30%, segunda 30%, tercera 40%)
    private final double[] pesos = {0.3, 0.3, 0.4};

    @Override
    public double calcular(List<Integer> notas) {
        if (notas.isEmpty()) return 0.0;
        double sumaPonderada = 0;
        for (int i = 0; i < notas.size(); i++) {
            double peso = (i < pesos.length) ? pesos[i] : pesos[pesos.length - 1]; // Usa el último peso si hay más notas que pesos
            sumaPonderada += notas.get(i) * peso;
        }
        return sumaPonderada;
    }
}
