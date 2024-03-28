package co.edu.uniquindio.model.dto;

import co.edu.uniquindio.model.enums.Estado;

import java.time.LocalDate;

public record ProyectoDTO(int idProyecto, String nombre, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, Estado estadoProyecto, int solicitudId, String empleadoId) {}

