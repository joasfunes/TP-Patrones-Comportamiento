package ChainOfResponsibility;

public class Coordinador extends Handler{
    protected boolean procesar(Solicitud solicitud) {
        System.out.println("Coordinador: Atendiendo solicitud de '" + solicitud.getTipo() + "'");
        System.out.println("Detalle: " + solicitud.getDescripcion());
        System.out.println("--- Solicitud resuelta por el Coordinador (máxima prioridad) ---\n");
        return true;  // El coordinador siempre resuelve (es el último eslabón)
    }
}
