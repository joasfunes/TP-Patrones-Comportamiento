package Mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator{
    private List<Usuario> usuarios;

    public ChatRoom() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario);
            System.out.println(usuario.getNombre() + " se unió al chat.");
        }
    }

    @Override
    public void enviarMensaje(String mensaje, Usuario usuarioRemitente) {
        for (Usuario usuario : usuarios) {
            // El mensaje no se reenvía al remitente
            if (usuario != usuarioRemitente) {
                usuario.recibir(mensaje, usuarioRemitente);
            }
        }
    }
}
