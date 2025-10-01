package Mediator;

public class ProfesorMediator extends Usuario{
    public ProfesorMediator(ChatMediator mediador, String nombre) {
        super(mediador, nombre);
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println(nombre + " (Profesor) envía: " + mensaje);
        mediador.enviarMensaje(mensaje, this);
    }

    @Override
    public void recibir(String mensaje, Usuario remitente) {
        System.out.println(nombre + " (Profesor) recibe de " + remitente.getNombre() + ": " + mensaje);
    }
}
