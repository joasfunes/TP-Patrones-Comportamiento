package Strategy;

import java.util.ArrayList;
import java.util.List;

public class AlumnoStrategy {
    private String nombre;
    private List<Integer> notas;
    private CalculoNota estrategiaCalculo;

    public AlumnoStrategy(String nombre, CalculoNota estrategiaCalculo) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
        this.estrategiaCalculo = estrategiaCalculo;
    }

    // Agrega una nota al alumno
    public void agregarNota(int nota) {
        notas.add(nota);
    }

    // Calcula la nota final usando la estrategia configurada
    public double calcularNotaFinal() {
        return estrategiaCalculo.calcular(new ArrayList<>(notas)); // Pasamos una copia de la lista
    }

    // Cambia la estrategia de cálculo
    public void setEstrategiaCalculo(CalculoNota estrategiaCalculo) {
        this.estrategiaCalculo = estrategiaCalculo;
    }

    // Getters
    public String getNombre() { return nombre; }
    public List<Integer> getNotas() { return notas; }
    public CalculoNota getEstrategiaCalculo() { return estrategiaCalculo; }
}
