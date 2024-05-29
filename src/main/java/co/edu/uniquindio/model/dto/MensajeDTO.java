package co.edu.uniquindio.model.dto;

public record MensajeDTO<T>(
        boolean error,
        T respuesta
) {
}
