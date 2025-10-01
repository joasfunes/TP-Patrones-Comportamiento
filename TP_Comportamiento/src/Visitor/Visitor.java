package Visitor;

public interface Visitor {
    void visitar(AlumnoRegular alumno);  // Visita un alumno regular
    void visitar(AlumnoBecado alumno);   // Visita un alumno becado
}
