import ChainOfResponsibility.*;
import Command.*;
import Iterator.*;
import Mediator.*;
import Memento.*;
import Observer.*;
import State.*;
import Strategy.*;
import TemplateMethod.*;
import Visitor.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //CHAIN OF RESPONSIBILITY
        System.out.println("-----------------Chain of Responsibility-----------------");
        // Crear los manejadores
        Handler asistente = new Asistente();
        Handler profesor = new Profesor();
        Handler coordinador = new Coordinador();

        // Configurar la cadena: Asistente -> Profesor -> Coordinador
        asistente.setNext(profesor);
        profesor.setNext(coordinador);

        // Enviar solicitudes
        Solicitud solicitud1 = new Solicitud("Duda en ejercicio", 1, "No entiendo el ejercicio 3 de la guía.");
        asistente.handle(solicitud1);

        Solicitud solicitud2 = new Solicitud("Revisión de parcial", 2, "Necesito que revisen mi parcial corregido.");
        asistente.handle(solicitud2);

        Solicitud solicitud3 = new Solicitud("Conflicto de horarios", 3, "El horario de tutorías choca con otro curso.");
        asistente.handle(solicitud3);


        //Command
        System.out.println("-----------------Command-----------------");
        // Crear receivers
        AlumnoCommand alumno = new AlumnoCommand("Joaquín Funes");
        CursoCommand cursoJava = new CursoCommand("Patrones de Diseño en Java");
        CursoCommand cursoPython = new CursoCommand("Python Avanzado");

        // Crear invoker
        GestorComandos gestor = new GestorComandos();

        // Crear comandos
        Command inscribirseJava = new InscribirseCursoCommand(alumno, cursoJava);
        Command inscribirsePython = new InscribirseCursoCommand(alumno, cursoPython);
        Command abandonarJava = new AbandonarCursoCommand(alumno, cursoJava);
        Command solicitarCertificado = new SolicitarCertificadoCommand(alumno, cursoJava);

        // Ejecutar comandos
        gestor.ejecutarComando(inscribirseJava);      // Joaquín se inscribe en Java
        gestor.ejecutarComando(inscribirsePython);   // Joaquín se inscribe en Python
        gestor.ejecutarComando(abandonarJava);       // Joaquín abandona Java
        gestor.ejecutarComando(solicitarCertificado); // Error: Joaquín no está en Java

        // Intentar solicitar certificado de Python
        Command solicitarCertificadoPython = new SolicitarCertificadoCommand(alumno, cursoPython);
        gestor.ejecutarComando(solicitarCertificadoPython);


        //Iterator
        System.out.println("-----------------Iterator-----------------");
        // Crear cursos
        Curso cursoJava2 = new Curso("Patrones de Diseño en Java", "CS-101");
        Curso cursoPython2 = new Curso("Python Avanzado", "CS-102");
        Curso cursoBD = new Curso("Bases de Datos", "CS-103");

        // Crear alumno
        Alumno alumno2 = new Alumno("Joaquín Funes");

        // Inscribir alumno en cursos
        alumno2.inscribirseEnCurso(cursoJava2);
        alumno2.inscribirseEnCurso(cursoPython2);
        alumno2.inscribirseEnCurso(cursoBD);

        // Recorrer cursos inscritos usando el iterador
        System.out.println("\nCursos inscritos por " + alumno.getNombre() + ":");
        CursoIterator iterator = alumno2.iterator();
        while (iterator.hasNext()) {
            Curso curso = iterator.next();
            System.out.println("- " + curso);
        }


        //Mediator
        System.out.println("-----------------Mediator-----------------");
        // Crear el mediador (sala de chat)
        ChatMediator chatRoom = new ChatRoom();

        // Crear usuarios
        AlumnoMediator alumno1 = new AlumnoMediator(chatRoom, "Joaquín");
        AlumnoMediator alumno3 = new AlumnoMediator(chatRoom, "María");
        ProfesorMediator profesor2 = new ProfesorMediator(chatRoom, "Dr. López");

        // Registrar usuarios en el chat
        chatRoom.agregarUsuario(alumno1);
        chatRoom.agregarUsuario(alumno3);
        chatRoom.agregarUsuario(profesor2);

        // Simular conversación
        alumno1.enviar("Hola a todos, ¿alguien puede ayudarme con el ejercicio 3?");
        profesor2.enviar("Hola Joaquín, claro. El ejercicio 3 requiere aplicar el patrón Strategy.");
        alumno3.enviar("Yo también tengo dudas con ese ejercicio. ¿Podría explicarlo en la próxima clase?");
        profesor2.enviar("¡Por supuesto, María! Lo agregaré al temario de la próxima tutoría.");


        //Memento
        System.out.println("-----------------Memento-----------------");
        // Crear examen con preguntas
        List<String> enunciados = Arrays.asList(
                "¿Qué patrón permite guardar y restaurar el estado de un objeto?",
                "¿Cuál es la interfaz principal en el patrón Command?",
                "¿Qué patrón desacopla la comunicación entre objetos?"
        );
        Examen examen = new Examen(enunciados);
        HistorialExamen historial = new HistorialExamen();

        // Responder primera pregunta y guardar progreso
        examen.mostrarEstado();
        examen.responder("Memento");
        examen.siguientePregunta();
        historial.guardar(examen.save());

        // Responder segunda pregunta y guardar progreso
        examen.responder("Command");
        examen.siguientePregunta();
        historial.guardar(examen.save());

        // Responder tercera pregunta
        examen.responder("Mediator");
        examen.mostrarEstado();

        // Restaurar al estado anterior (segundo guardado)
        System.out.println("\n--- Restaurando al punto de guardado anterior ---");
        examen.restore(historial.restaurar());
        examen.mostrarEstado();

        // Modificar respuesta de la segunda pregunta y avanzar
        examen.responder("ICommand"); // Corregir respuesta
        examen.siguientePregunta();   // Intentar avanzar (ya está en la última)
        examen.mostrarEstado();

        // Restaurar al primer punto de guardado
        System.out.println("\n--- Restaurando al primer punto de guardado ---");
        examen.restore(historial.restaurar());
        examen.mostrarEstado();


        //Observer
        System.out.println("-----------------Observer-----------------");
        // Crear cursos
        CursoObserver cursoJava3 = new CursoObserver("Patrones de Diseño en Java", "Lunes y Miércoles 18:00");
        CursoObserver cursoPython3 = new CursoObserver("Python Avanzado", "Martes y Jueves 19:00");

        // Crear alumnos
        AlumnoObserver alumno4 = new AlumnoObserver("Joaquín");
        AlumnoObserver alumno5 = new AlumnoObserver("María");
        AlumnoObserver alumno6 = new AlumnoObserver("Carlos");

        // Registrar alumnos en cursos
        cursoJava3.agregarObserver(alumno4);
        cursoJava3.agregarObserver(alumno5);
        cursoPython3.agregarObserver(alumno5);
        cursoPython3.agregarObserver(alumno6);

        // Simular cambios en cursos (que generan notificaciones)
        cursoJava3.cambiarHorario("Lunes y Miércoles 19:00");  // Cambio de horario
        cursoPython3.publicarAviso("La clase del jueves será práctica con ejercicios de decorators.");

        // Dar de baja a un alumno y verificar que ya no recibe notificaciones
        cursoPython3.eliminarObserver(alumno6);
        cursoPython3.publicarAviso("Recordatorio: Entregar TP antes del viernes.");


        //State
        System.out.println("-----------------State-----------------");
        // Crear una inscripción
        Inscripcion inscripcion = new Inscripcion("Patrones de Diseño", "Joaquín Funes");

        // Intentar confirmar la inscripción (está en espera)
        inscripcion.confirmarInscripcion();

        // Cancelar la inscripción
        inscripcion.cancelarInscripcion();

        // Reactivar la solicitud de inscripción
        inscripcion.solicitarInscripcion();

        // Confirmar la inscripción
        inscripcion.confirmarInscripcion();

        // Intentar confirmar nuevamente (ya está confirmada)
        inscripcion.confirmarInscripcion();

        // Cancelar la inscripción
        inscripcion.cancelarInscripcion();

        // Intentar cancelar nuevamente (ya está cancelada)
        inscripcion.cancelarInscripcion();


        //Strategy
        System.out.println("-----------------Strategy-----------------");
        // Crear un alumno con estrategia de promedio simple
        AlumnoStrategy alumno7 = new AlumnoStrategy("Joaquín Funes", new PromedioSimple());

        // Agregar notas
        alumno7.agregarNota(8);
        alumno7.agregarNota(7);
        alumno7.agregarNota(9);

        // Calcular nota con promedio simple
        System.out.println("Nota final de " + alumno7.getNombre() + " (Promedio Simple): " + alumno7.calcularNotaFinal());

        // Cambiar a estrategia de promedio ponderado
        alumno7.setEstrategiaCalculo(new PromedioPonderado());
        System.out.println("Nota final de " + alumno7.getNombre() + " (Promedio Ponderado): " + alumno7.calcularNotaFinal());

        // Agregar un examen extra y cambiar a esa estrategia
        alumno7.agregarNota(10); // Esta es la nota del examen extra
        alumno7.setEstrategiaCalculo(new ExamenExtra());
        System.out.println("Nota final de " + alumno7.getNombre() + " (Con Examen Extra): " + alumno7.calcularNotaFinal());

        // Crear otro alumno con estrategia de examen extra desde el principio
        AlumnoStrategy alumno8 = new AlumnoStrategy("María López", new ExamenExtra());
        alumno8.agregarNota(6);
        alumno8.agregarNota(7);
        alumno8.agregarNota(9); // Examen extra
        System.out.println("Nota final de " + alumno8.getNombre() + " (Con Examen Extra): " + alumno8.calcularNotaFinal());




        //Template Method
        System.out.println("-----------------Template Method-----------------");
        // Datos para el reporte de curso
        List<String> alumnosJava = Arrays.asList("Joaquín Funes", "María López", "Carlos Gómez");
        ReporteAcademico reporteCurso = new ReporteCurso(
                "Patrones de Diseño en Java",
                "Dr. López",
                alumnosJava,
                8.5
        );

        // Datos para el reporte de alumno
        Map<String, Integer> cursosYNotas = new HashMap<>();
        cursosYNotas.put("Patrones de Diseño", 9);
        cursosYNotas.put("Bases de Datos", 8);
        cursosYNotas.put("Algoritmos Avanzados", 7);
        ReporteAcademico reporteAlumno = new ReporteAlumno(
                "Joaquín Funes",
                "Ingeniería en Sistemas",
                cursosYNotas
        );

        // Generar reportes
        System.out.println("=== GENERANDO REPORTE DE CURSO ===");
        reporteCurso.generarReporte();

        System.out.println("\n=== GENERANDO REPORTE DE ALUMNO ===");
        reporteAlumno.generarReporte();




        //Visitor
        System.out.println("-----------------Visitor-----------------");
        // Crear alumnos
        List<AlumnoVisitor> alumnos = new ArrayList<>();
        alumnos.add(new AlumnoRegular("Joaquín Funes", 6, 5000.0));          // 6 créditos
        alumnos.add(new AlumnoRegular("María López", 4, 5000.0));           // 4 créditos (sin descuento)
        alumnos.add(new AlumnoBecado("Carlos Gómez", 7, 5000.0, 0.5));       // 50% de beca + 7 créditos
        alumnos.add(new AlumnoBecado("Ana Martínez", 3, 5000.0, 0.25));      // 25% de beca + 3 créditos

        // Crear el visitante para aplicar becas/descuentos
        Visitor aplicarBeca = new AplicarBeca();

        // Aplicar el visitante a todos los alumnos
        System.out.println("=== APLICANDO BECAS Y DESCUENTOS ===");
        for (AlumnoVisitor alumno9 : alumnos) {
            alumno9.aceptar(aplicarBeca);
        }

        // Mostrar cuotas finales
        System.out.println("\n=== CUOTAS FINALES ===");
        for (AlumnoVisitor alumno10 : alumnos) {
            String tipo = alumno10 instanceof AlumnoBecado ? "Becado" : "Regular";
            System.out.printf(
                    "%s (%s): $%.2f%n",
                    alumno.getNombre(), tipo, alumno10.getCuotaMensual()
            );
        }

    }
}