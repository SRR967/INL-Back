package co.edu.uniquindio.services.interfaces;

import co.edu.uniquindio.model.dto.RespuestaDTO;
import co.edu.uniquindio.model.entities.Respuesta;

public interface RespuestaService {

    int save(RespuestaDTO respuestaDTO) throws Exception;

    RespuestaDTO findById(int id) throws Exception;


}
