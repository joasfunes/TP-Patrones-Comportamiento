package Command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AbandonarCursoCommand implements Command{
    private AlumnoCommand alumnoCommand;
    private CursoCommand cursoCommand;


    @Override
    public void execute() {
        alumnoCommand.abandonarCurso(cursoCommand);
    }
}
