package Command;

import java.util.Stack;

public class GestorComandos {
    private Stack<Command> historialComandos = new Stack<>();

    public void ejecutarComando(Command comando) {
        comando.execute();
        historialComandos.push(comando);  // Guarda el comando para posible "undo"
    }

    // Opcional: Método para deshacer el último comando
    public void deshacerUltimoComando() {
        if (!historialComandos.isEmpty()) {
            Command comando = historialComandos.pop();
            // Aquí iría la lógica para "undo", pero en este ejemplo no la implementamos
            System.out.println("Deshaciendo último comando (lógica de undo no implementada)");
        } else {
            System.out.println("No hay comandos para deshacer");
        }
    }
}
