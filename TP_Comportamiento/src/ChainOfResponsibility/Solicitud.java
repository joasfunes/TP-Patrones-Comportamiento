package ChainOfResponsibility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud {
    private String tipo;
    private int nivel; // 1: Asistente, 2: Profesor, 3: Coordinador
    private String descripcion;

}

