package co.edu.uniquindio.model.dto;

import co.edu.uniquindio.model.enums.Estado;

import java.time.LocalDate;

public record ListaProyectosDTO(
        int id,
        LocalDate fecha,
        String nombre,
        Estado estado
) {
}
