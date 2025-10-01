package Observer;

import lombok.Getter;

@Getter
public class AlumnoObserver implements Observer{
    private String nombre;

    public AlumnoObserver(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update(String mensaje) {
        System.out.println(nombre + " recibió notificación: " + mensaje);
    }

}
