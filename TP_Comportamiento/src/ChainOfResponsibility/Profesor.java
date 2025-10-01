package ChainOfResponsibility;

public class Profesor extends Handler{
    protected boolean procesar(Solicitud solicitud) {
        if (solicitud.getNivel() == 2) {
            System.out.println("Profesor: Atendiendo solicitud de '" + solicitud.getTipo() + "'");
            System.out.println("Detalle: " + solicitud.getDescripcion());
            System.out.println("--- Solicitud resuelta por el Profesor ---\n");
            return true;
        }
        return false;
    }
}
