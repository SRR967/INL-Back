package co.edu.uniquindio.model.dto;

import co.edu.uniquindio.model.enums.Estado;

public record RespuestaDTO(int idRespuesta, String contenido, int solicitudId, String idEmpleado) {}
