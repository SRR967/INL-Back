package co.edu.uniquindio.services.interfaces;

import co.edu.uniquindio.model.dto.ListaProyectosDTO;
import co.edu.uniquindio.model.dto.SolicitudDTO;
import java.util.List;

public interface SolicitudService {
    SolicitudDTO saveSolicitud(SolicitudDTO solicitudDto)throws Exception;
    SolicitudDTO getSolicitudById(int id)throws Exception;
    List<ListaProyectosDTO> getAllSolicitudes()throws Exception;
    SolicitudDTO updateSolicitud(SolicitudDTO solicitudDto) throws Exception;
    void deleteSolicitud(int id)throws Exception;
}