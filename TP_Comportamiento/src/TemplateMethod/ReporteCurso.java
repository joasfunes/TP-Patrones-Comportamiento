package TemplateMethod;

import java.util.List;

public class ReporteCurso extends ReporteAcademico{
    private String nombreCurso;
    private String profesor;
    private List<String> alumnosInscriptos;
    private double promedioNotas;

    public ReporteCurso(String nombreCurso, String profesor, List<String> alumnosInscriptos, double promedioNotas) {
        this.nombreCurso = nombreCurso;
        this.profesor = profesor;
        this.alumnosInscriptos = alumnosInscriptos;
        this.promedioNotas = promedioNotas;
    }

    @Override
    protected void generarContenido() {
        System.out.println("REPORTE DE CURSO: " + nombreCurso.toUpperCase());
        System.out.println("Profesor: " + profesor);
        System.out.println("Promedio general: " + String.format("%.2f", promedioNotas));
        System.out.println("\nAlumnos inscriptos (" + alumnosInscriptos.size() + "):");
        for (String alumno : alumnosInscriptos) {
            System.out.println("- " + alumno);
        }
    }

    // Hook opcional (puede ser sobrescrito por subclasses)
    @Override
    protected void generarPie() {
        super.generarPie();
        System.out.println("Nota: Este es un reporte automático generado por el sistema.");
    }
}
