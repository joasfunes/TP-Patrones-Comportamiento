package State;

public class EnEspera implements EstadoInscripcion{
    @Override
    public void solicitarInscripcion(Inscripcion inscripcion) {
        System.out.println("Ya hay una solicitud de inscripción en espera.");
    }

    @Override
    public void confirmarInscripcion(Inscripcion inscripcion) {
        System.out.println("Inscripción confirmada. ¡Bienvenido al curso!");
        inscripcion.cambiarEstado(new Inscrito());
    }

    @Override
    public void cancelarInscripcion(Inscripcion inscripcion) {
        System.out.println("Solicitud de inscripción cancelada.");
        inscripcion.cambiarEstado(new Cancelado());
    }

    @Override
    public String getNombreEstado() {
        return "En Espera";
    }
}
