package State;

public class Inscripcion {
    private EstadoInscripcion estadoActual;
    private String curso;
    private String alumno;

    public Inscripcion(String curso, String alumno) {
        this.curso = curso;
        this.alumno = alumno;
        this.estadoActual = new EnEspera(); // Estado inicial: EnEspera
    }

    // Cambia el estado actual
    public void cambiarEstado(EstadoInscripcion nuevoEstado) {
        this.estadoActual = nuevoEstado;
        System.out.println("Estado actual de la inscripción: " + estadoActual.getNombreEstado());
    }

    // Métodos que delegan en el estado actual
    public void solicitarInscripcion() {
        estadoActual.solicitarInscripcion(this);
    }

    public void confirmarInscripcion() {
        estadoActual.confirmarInscripcion(this);
    }

    public void cancelarInscripcion() {
        estadoActual.cancelarInscripcion(this);
    }

    // Getters
    public String getCurso() { return curso; }
    public String getAlumno() { return alumno; }
    public EstadoInscripcion getEstadoActual() { return estadoActual; }
}
