package State;

public class Cancelado implements EstadoInscripcion{
    @Override
    public void solicitarInscripcion(Inscripcion inscripcion) {
        System.out.println("Reactivando solicitud de inscripción.");
        inscripcion.cambiarEstado(new EnEspera());
    }

    @Override
    public void confirmarInscripcion(Inscripcion inscripcion) {
        System.out.println("No se puede confirmar una inscripción cancelada.");
    }

    @Override
    public void cancelarInscripcion(Inscripcion inscripcion) {
        System.out.println("La inscripción ya estaba cancelada.");
    }

    @Override
    public String getNombreEstado() {
        return "Cancelado";
    }
}
