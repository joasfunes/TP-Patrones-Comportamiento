package State;

public class Inscrito implements EstadoInscripcion{
    @Override
    public void solicitarInscripcion(Inscripcion inscripcion) {
        System.out.println("Ya estás inscripto en el curso.");
    }

    @Override
    public void confirmarInscripcion(Inscripcion inscripcion) {
        System.out.println("La inscripción ya estaba confirmada.");
    }

    @Override
    public void cancelarInscripcion(Inscripcion inscripcion) {
        System.out.println("Inscripción cancelada.");
        inscripcion.cambiarEstado(new Cancelado());
    }

    @Override
    public String getNombreEstado() {
        return "Inscrito";
    }
}
