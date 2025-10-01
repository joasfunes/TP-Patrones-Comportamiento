package Iterator;

import java.util.List;

public class AlumnoCursoIterator implements CursoIterator{
    private List<Curso> cursos;
    private int posicionActual;

    public AlumnoCursoIterator(List<Curso> cursos) {
        this.cursos = cursos;
        this.posicionActual = 0;
    }

    @Override
    public boolean hasNext() {
        return posicionActual < cursos.size();
    }

    @Override
    public Curso next() {
        if (hasNext()) {
            return cursos.get(posicionActual++);
        }
        return null; // O lanzar una excepción NoSuchElementException
    }
}
