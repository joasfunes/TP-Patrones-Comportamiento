package Command;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CursoCommand {
    private String nombre;
    private List<AlumnoCommand> alumnosInscriptos = new ArrayList<>();

    public CursoCommand(String nombre) {
        this.nombre = nombre;
    }

    public void inscribirAlumno(AlumnoCommand alumnoCommand) {
        if (!alumnosInscriptos.contains(alumnoCommand)) {
            alumnosInscriptos.add(alumnoCommand);
            System.out.println(alumnoCommand.getNombre() + " se inscribió en " + nombre);
        } else {
            System.out.println(alumnoCommand.getNombre() + " ya está inscripto en " + nombre);
        }
    }

    public void desinscribirAlumno(AlumnoCommand alumnoCommand) {
        if (alumnosInscriptos.remove(alumnoCommand)) {
            System.out.println(alumnoCommand.getNombre() + " abandonó el curso " + nombre);
        } else {
            System.out.println(alumnoCommand.getNombre() + " no estaba inscripto en " + nombre);
        }
    }

    public void emitirCertificado(AlumnoCommand alumnoCommand) {
        if (alumnosInscriptos.contains(alumnoCommand)) {
            System.out.println("Certificado emitido para " + alumnoCommand.getNombre() + " en " + nombre);
        } else {
            System.out.println("Error: " + alumnoCommand.getNombre() + " no está inscripto en " + nombre);
        }
    }
}
