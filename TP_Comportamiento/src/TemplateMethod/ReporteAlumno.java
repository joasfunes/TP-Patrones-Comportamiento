package TemplateMethod;

import java.util.Map;

public class ReporteAlumno extends ReporteAcademico{
    private String nombreAlumno;
    private String carrera;
    private Map<String, Integer> cursosYNotas; // Curso -> Nota

    public ReporteAlumno(String nombreAlumno, String carrera, Map<String, Integer> cursosYNotas) {
        this.nombreAlumno = nombreAlumno;
        this.carrera = carrera;
        this.cursosYNotas = cursosYNotas;
    }

    @Override
    protected void generarContenido() {
        System.out.println("REPORTE ACADÉMICO DE ALUMNO: " + nombreAlumno.toUpperCase());
        System.out.println("Carrera: " + carrera);
        System.out.println("\nCursos y notas:");
        double sumaNotas = 0;
        for (Map.Entry<String, Integer> entry : cursosYNotas.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
            sumaNotas += entry.getValue();
        }
        double promedio = cursosYNotas.isEmpty() ? 0 : sumaNotas / cursosYNotas.size();
        System.out.println("\nPromedio general: " + String.format("%.2f", promedio));
    }

    @Override
    protected void generarEncabezado() {
        super.generarEncabezado();
        System.out.println("Tipo: Reporte Individual de Alumno");
    }
}
