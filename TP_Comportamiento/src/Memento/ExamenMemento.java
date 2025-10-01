package Memento;

import java.util.ArrayList;
import java.util.List;

public class ExamenMemento {
    private final List<String> respuestasGuardadas;
    private final int preguntaActual;

    public ExamenMemento(List<String> respuestasGuardadas, int preguntaActual) {
        this.respuestasGuardadas = new ArrayList<>(respuestasGuardadas); // Copia defensiva
        this.preguntaActual = preguntaActual;
    }

    // Getters (solo para Originator)
    public List<String> getRespuestasGuardadas() { return respuestasGuardadas; }
    public int getPreguntaActual() { return preguntaActual; }
}
