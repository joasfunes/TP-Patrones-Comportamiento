package Visitor;

public class AlumnoRegular extends AlumnoVisitor {
    public AlumnoRegular(String nombre, int creditosInscriptos, double cuotaMensual) {
        super(nombre, creditosInscriptos, cuotaMensual);
    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitar(this);  // Llama al método correspondiente en el visitante
    }
}
