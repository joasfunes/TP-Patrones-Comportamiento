package Mediator;

public abstract class Usuario {
    protected ChatMediator mediador;
    protected String nombre;

    public Usuario(ChatMediator mediador, String nombre) {
        this.mediador = mediador;
        this.nombre = nombre;
    }

    public abstract void enviar(String mensaje);      // Envía un mensaje a través del mediador
    public abstract void recibir(String mensaje, Usuario remitente);  // Recibe un mensaje

    // Getter
    public String getNombre() {
        return nombre;
    }
}
