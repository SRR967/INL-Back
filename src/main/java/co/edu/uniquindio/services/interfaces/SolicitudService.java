package co.edu.uniquindio.services.interfaces;

import co.edu.uniquindio.model.dto.SolicitudDTO;
import java.util.List;

public interface SolicitudService {
    SolicitudDTO saveSolicitud(SolicitudDTO solicitudDto);
    SolicitudDTO getSolicitudById(int id);
    List<SolicitudDTO> getAllSolicitudes();
    SolicitudDTO updateSolicitud(SolicitudDTO solicitudDto);
    void deleteSolicitud(int id);
}