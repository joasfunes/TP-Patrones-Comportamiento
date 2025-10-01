package Visitor;

public class AplicarBeca implements Visitor{
    private static final double DESCUENTO_POR_CREDITOS = 0.02;  // 2% de descuento por cada crédito
    private static final int CREDITOS_MINIMOS_DESCUENTO = 5;   // Mínimo 5 créditos para descuento

    @Override
    public void visitar(AlumnoRegular alumno) {
        // Aplicar descuento por cantidad de créditos (solo si supera el mínimo)
        double descuento = 0;
        if (alumno.getCreditosInscriptos() >= CREDITOS_MINIMOS_DESCUENTO) {
            descuento = alumno.getCreditosInscriptos() * DESCUENTO_POR_CREDITOS;
            descuento = Math.min(descuento, 0.3);  // Descuento máximo: 30%
        }
        double cuotaConDescuento = alumno.getCuotaMensual() * (1 - descuento);
        System.out.printf(
                "%s (Regular): Cuota original $%.2f → Cuota con descuento $%.2f (%.0f%% de descuento por %d créditos)%n",
                alumno.getNombre(), alumno.getCuotaMensual(), cuotaConDescuento, descuento * 100, alumno.getCreditosInscriptos()
        );
        alumno.setCuotaMensual(cuotaConDescuento);
    }

    @Override
    public void visitar(AlumnoBecado alumno) {
        // Aplicar beca + descuento por créditos
        double cuotaConBeca = alumno.getCuotaMensual() * (1 - alumno.getPorcentajeBeca());
        double descuentoAdicional = 0;
        if (alumno.getCreditosInscriptos() >= CREDITOS_MINIMOS_DESCUENTO) {
            descuentoAdicional = alumno.getCreditosInscriptos() * DESCUENTO_POR_CREDITOS;
            descuentoAdicional = Math.min(descuentoAdicional, 0.1);  // Descuento adicional máximo: 10%
            cuotaConBeca *= (1 - descuentoAdicional);
        }
        System.out.printf(
                "%s (Becado): Cuota original $%.2f → Cuota con beca $%.2f (%.0f%% de beca + %.0f%% descuento por %d créditos)%n",
                alumno.getNombre(), alumno.getCuotaMensual(), cuotaConBeca,
                alumno.getPorcentajeBeca() * 100, descuentoAdicional * 100, alumno.getCreditosInscriptos()
        );
        alumno.setCuotaMensual(cuotaConBeca);
    }
}
