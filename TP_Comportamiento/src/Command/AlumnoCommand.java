package Command;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AlumnoCommand {
    private String nombre;
    private List<CursoCommand> cursosInscriptos = new ArrayList<>();

    public AlumnoCommand(String nombre) {
        this.nombre = nombre;
    }

    public void inscribirseEnCurso(CursoCommand cursoCommand) {
        cursoCommand.inscribirAlumno(this);
        cursosInscriptos.add(cursoCommand);
    }

    public void abandonarCurso(CursoCommand cursoCommand) {
        cursoCommand.desinscribirAlumno(this);
        cursosInscriptos.remove(cursoCommand);
    }

    public void solicitarCertificado(CursoCommand cursoCommand) {
        cursoCommand.emitirCertificado(this);
    }

}
