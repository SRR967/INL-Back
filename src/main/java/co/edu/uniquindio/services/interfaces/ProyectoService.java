package co.edu.uniquindio.services.interfaces;

import co.edu.uniquindio.model.dto.ProyectoDTO;
import java.util.List;

public interface ProyectoService {
    ProyectoDTO saveProyecto(ProyectoDTO proyectoDto);
    ProyectoDTO getProyectoById(int id);
    List<ProyectoDTO> getAllProyectos();
    ProyectoDTO updateProyecto(ProyectoDTO proyectoDto);
    void deleteProyecto(int id);
}