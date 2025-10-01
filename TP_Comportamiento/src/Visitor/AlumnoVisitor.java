package Visitor;

public abstract class AlumnoVisitor {
    protected String nombre;
    protected int creditosInscriptos;
    protected double cuotaMensual;

    public AlumnoVisitor(String nombre, int creditosInscriptos, double cuotaMensual) {
        this.nombre = nombre;
        this.creditosInscriptos = creditosInscriptos;
        this.cuotaMensual = cuotaMensual;
    }

    // Método para aceptar un visitante
    public abstract void aceptar(Visitor visitor);

    // Getters
    public String getNombre() { return nombre; }
    public int getCreditosInscriptos() { return creditosInscriptos; }
    public double getCuotaMensual() { return cuotaMensual; }
    public void setCuotaMensual(double cuotaMensual) { this.cuotaMensual = cuotaMensual; }
}
