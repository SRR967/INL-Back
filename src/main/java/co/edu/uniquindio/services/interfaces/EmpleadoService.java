package co.edu.uniquindio.services.interfaces;


import co.edu.uniquindio.model.dto.ListaProyectosDTO;
import co.edu.uniquindio.model.dto.ProyectoDTO;
import co.edu.uniquindio.model.dto.RespuestaDTO;

import java.util.List;

public interface EmpleadoService {

    List<ListaProyectosDTO> verListaSolicitudes() throws Exception;

    int radicarSolicitud (RespuestaDTO respuestaDTO) throws Exception;

    ProyectoDTO getProyecto (int codigo )throws Exception;


}
