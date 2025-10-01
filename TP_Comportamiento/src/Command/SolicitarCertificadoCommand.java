package Command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitarCertificadoCommand implements Command{
    private AlumnoCommand alumnoCommand;
    private CursoCommand cursoCommand;

    @Override
    public void execute() {
        alumnoCommand.solicitarCertificado(cursoCommand);
    }
}
