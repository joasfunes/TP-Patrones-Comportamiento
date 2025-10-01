package ChainOfResponsibility;

public abstract class Handler {
    protected Handler next;

    public void setNext(Handler next){
        this.next = next;
    }

    public void handle(Solicitud solicitud){
        if (!procesar(solicitud) && next != null) {
            next.handle(solicitud);  // Pasa la solicitud al siguiente manejador
        }
    }

    protected abstract boolean procesar(Solicitud solicitud);  // Cada subclass decide cómo procesar

}
