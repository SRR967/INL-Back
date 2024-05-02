package co.edu.uniquindio.services.interfaces;

import co.edu.uniquindio.model.dto.ProyectoDTO;
import java.util.List;

public interface ProyectoService {
    ProyectoDTO saveProyecto(ProyectoDTO proyectoDto) throws Exception;
    ProyectoDTO getProyectoById(int id) throws Exception;
    List<ProyectoDTO> getAllProyectos() throws Exception;
    ProyectoDTO updateProyecto(ProyectoDTO proyectoDto) throws Exception;
    void deleteProyecto(int id) throws Exception;
}