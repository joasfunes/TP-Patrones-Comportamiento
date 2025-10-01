package Iterator;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Alumno {
    private String nombre;
    private List<Curso> cursosInscriptos;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.cursosInscriptos = new ArrayList<>();
    }

    public void inscribirseEnCurso(Curso curso) {
        if (!cursosInscriptos.contains(curso)) {
            cursosInscriptos.add(curso);
            System.out.println(nombre + " se inscribió en " + curso.getNombre());
        } else {
            System.out.println(nombre + " ya está inscripto en " + curso.getNombre());
        }
    }

    public CursoIterator iterator() {
        return new AlumnoCursoIterator(cursosInscriptos);
    }

}
