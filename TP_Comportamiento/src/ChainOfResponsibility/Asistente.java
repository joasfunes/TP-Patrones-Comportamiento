package ChainOfResponsibility;

public class Asistente extends Handler{

    @Override
    protected boolean procesar(Solicitud solicitud) {
        if (solicitud.getNivel() == 1) {
            System.out.println("Asistente: Atendiendo solicitud de '" + solicitud.getTipo() + "'");
            System.out.println("Detalle: " + solicitud.getDescripcion());
            System.out.println("--- Solicitud resuelta por el Asistente ---\n");
            return true;
        }
        return false;  // No puede procesarla, pasa al siguiente
    }
}
