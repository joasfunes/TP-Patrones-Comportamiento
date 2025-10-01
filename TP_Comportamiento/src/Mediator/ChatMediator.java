package Mediator;

public interface ChatMediator {
    void enviarMensaje(String mensaje, Usuario usuario);  // Envía un mensaje a todos los usuarios
    void agregarUsuario(Usuario usuario);
}
