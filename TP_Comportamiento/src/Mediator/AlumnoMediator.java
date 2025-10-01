package Mediator;

public class AlumnoMediator extends Usuario{
    public AlumnoMediator(ChatMediator mediador, String nombre) {
        super(mediador, nombre);
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println(nombre + " (Alumno) envía: " + mensaje);
        mediador.enviarMensaje(mensaje, this);
    }

    @Override
    public void recibir(String mensaje, Usuario remitente) {
        System.out.println(nombre + " (Alumno) recibe de " + remitente.getNombre() + ": " + mensaje);
    }
}
