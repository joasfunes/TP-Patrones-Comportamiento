package TemplateMethod;

public abstract class ReporteAcademico {
    // Método plantilla (final para evitar que sea sobrescrito)
    public final void generarReporte() {
        generarEncabezado();
        generarContenido();
        generarPie();
    }

    // Métodos comunes (pueden tener implementación por defecto)
    protected void generarEncabezado() {
        System.out.println("=====================================");
        System.out.println("UNIVERSIDAD NACIONAL - SISTEMA ACADÉMICO");
        System.out.println("Fecha: " + java.time.LocalDate.now());
        System.out.println("-------------------------------------");
    }

    protected void generarPie() {
        System.out.println("-------------------------------------");
        System.out.println("Fin del reporte. Sistema de Gestión Académica v1.0");
        System.out.println("=====================================");
    }

    // Métodos abstractos (deben ser implementados por subclasses)
    protected abstract void generarContenido();
}
