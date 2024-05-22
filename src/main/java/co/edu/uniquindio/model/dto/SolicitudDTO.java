package co.edu.uniquindio.model.dto;

import co.edu.uniquindio.model.enums.Estado;

import java.time.LocalDate;

public record SolicitudDTO(int id_solicitud, LocalDate fecha, String descripcion, String detalle, String clienteCedula) {}

