package Observer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CursoObserver implements Subject{
    private String nombre;
    private String horario;
    private List<Observer> observadores;

    public CursoObserver(String nombre, String horario) {
        this.nombre = nombre;
        this.horario = horario;
        this.observadores = new ArrayList<>();
    }

    @Override
    public void agregarObserver(Observer observer) {
        if (!observadores.contains(observer)) {
            observadores.add(observer);
            System.out.println("Nuevo alumno inscripto en " + nombre + ": " + ((AlumnoObserver) observer).getNombre());
        }
    }

    @Override
    public void eliminarObserver(Observer observer) {
        observadores.remove(observer);
        System.out.println("Alumno dado de baja de " + nombre + ": " + ((AlumnoObserver) observer).getNombre());
    }

    @Override
    public void notificarObservers(String mensaje) {
        System.out.println("\n--- Notificación enviada desde " + nombre + " ---");
        for (Observer observer : observadores) {
            observer.update(mensaje);
        }
    }

    // Métodos para cambiar el estado del curso (y notificar)
    public void cambiarHorario(String nuevoHorario) {
        this.horario = nuevoHorario;
        notificarObservers("Cambio de horario: Nuevo horario de " + nombre + " es " + nuevoHorario);
    }

    public void publicarAviso(String aviso) {
        notificarObservers("Nuevo aviso en " + nombre + ": " + aviso);
    }

}
