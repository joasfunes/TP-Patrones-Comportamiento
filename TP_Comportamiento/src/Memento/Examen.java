package Memento;

import java.util.ArrayList;
import java.util.List;

public class Examen {
    private List<Pregunta> preguntas;
    private int preguntaActual;

    public Examen(List<String> enunciados) {
        this.preguntas = new ArrayList<>();
        for (String enunciado : enunciados) {
            preguntas.add(new Pregunta(enunciado));
        }
        this.preguntaActual = 0;
    }

    // Responde la pregunta actual
    public void responder(String respuesta) {
        if (preguntaActual >= 0 && preguntaActual < preguntas.size()) {
            preguntas.get(preguntaActual).setRespuesta(respuesta);
        }
    }

    // Avanza a la siguiente pregunta
    public void siguientePregunta() {
        if (preguntaActual < preguntas.size() - 1) {
            preguntaActual++;
        }
    }

    // Retrocede a la pregunta anterior
    public void preguntaAnterior() {
        if (preguntaActual > 0) {
            preguntaActual--;
        }
    }

    // Guarda el estado actual del examen
    public ExamenMemento save() {
        // Crear copias de las respuestas para evitar modificar el estado original
        List<String> respuestas = new ArrayList<>();
        for (Pregunta pregunta : preguntas) {
            respuestas.add(pregunta.getRespuesta());
        }
        return new ExamenMemento(respuestas, preguntaActual);
    }

    // Restaura el estado del examen desde un memento
    public void restore(ExamenMemento memento) {
        List<String> respuestas = memento.getRespuestasGuardadas();
        for (int i = 0; i < respuestas.size(); i++) {
            preguntas.get(i).setRespuesta(respuestas.get(i));
        }
        this.preguntaActual = memento.getPreguntaActual();
    }

    // Muestra el estado actual del examen
    public void mostrarEstado() {
        System.out.println("\n--- Estado actual del examen ---");
        for (int i = 0; i < preguntas.size(); i++) {
            String respuesta = preguntas.get(i).getRespuesta().isEmpty() ?
                    "[Sin responder]" : preguntas.get(i).getRespuesta();
            System.out.println((i == preguntaActual ? "> " : "  ") +
                    (i + 1) + ". " + preguntas.get(i).getEnunciado() +
                    " | Respuesta: " + respuesta);
        }
    }

    // Getters
    public int getPreguntaActual() { return preguntaActual; }
    public List<Pregunta> getPreguntas() { return preguntas; }
}
