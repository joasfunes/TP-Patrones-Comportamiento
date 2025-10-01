package State;

public interface EstadoInscripcion {
    void solicitarInscripcion(Inscripcion inscripcion);  // Solicita inscribirse en el curso
    void confirmarInscripcion(Inscripcion inscripcion);  // Confirma la inscripción
    void cancelarInscripcion(Inscripcion inscripcion);   // Cancela la inscripción
    String getNombreEstado();                            // Devuelve el nombre del estado actual
}
