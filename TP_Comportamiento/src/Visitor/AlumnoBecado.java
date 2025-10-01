package Visitor;

public class AlumnoBecado extends AlumnoVisitor{
    private double porcentajeBeca;  // Porcentaje de beca (ej: 0.5 para 50%)

    public AlumnoBecado(String nombre, int creditosInscriptos, double cuotaMensual, double porcentajeBeca) {
        super(nombre, creditosInscriptos, cuotaMensual);
        this.porcentajeBeca = porcentajeBeca;
    }

    public double getPorcentajeBeca() { return porcentajeBeca; }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitar(this);
    }
}
