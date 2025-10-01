package Memento;

import java.util.Stack;

public class HistorialExamen {
    private Stack<ExamenMemento> historial = new Stack<>();

    public void guardar(ExamenMemento memento) {
        historial.push(memento);
        System.out.println("Progreso guardado. Puntos de guardado: " + historial.size());
    }

    public ExamenMemento restaurar() {
        if (!historial.isEmpty()) {
            return historial.pop();
        }
        return null;
    }
}
