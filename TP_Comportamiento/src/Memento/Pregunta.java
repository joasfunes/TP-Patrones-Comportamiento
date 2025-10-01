package Memento;

public class Pregunta {

    private String enunciado;
    private String respuesta;

    public Pregunta(String enunciado) {
        this.enunciado = enunciado;
        this.respuesta = ""; // Respuesta vacía inicialmente
    }

    // Getters y setters
    public String getEnunciado() { return enunciado; }
    public String getRespuesta() { return respuesta; }
    public void setRespuesta(String respuesta) { this.respuesta = respuesta; }
}
