package Observer;

public interface Subject {
    void agregarObserver(Observer observer);   // Registra un observador
    void eliminarObserver(Observer observer); // Elimina un observador
    void notificarObservers(String mensaje);  // Notifica a todos los observadores
}
