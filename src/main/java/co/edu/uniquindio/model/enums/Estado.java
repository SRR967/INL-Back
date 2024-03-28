package co.edu.uniquindio.model.enums;

public enum Estado {
    FINALIZADO("Finalizado"),
    ENPROCESO("En proceso"),
    APROBADO("Aprobado"),
    RECHAZADO("Rechazado");
    // No Fokiu

    private String estado;

    Estado(String estado){
        this.estado = estado;
    }
}
