package co.edu.uniquindio.services.implementacion;

import co.edu.uniquindio.model.entities.Cliente;
import co.edu.uniquindio.model.entities.Solicitud;
import co.edu.uniquindio.model.dto.SolicitudDTO;
import co.edu.uniquindio.model.enums.Estado;
import co.edu.uniquindio.repositories.ClienteRepo;
import co.edu.uniquindio.repositories.SolicitudRepo;
import co.edu.uniquindio.services.interfaces.SolicitudService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {


    private final SolicitudRepo solicitudRepository;


    @Override
    public SolicitudDTO saveSolicitud(SolicitudDTO solicitudDto)throws Exception{
        Solicitud solicitud = new Solicitud();

        solicitud= solicitudRepository.save(solicitud);
        return convertToDto(solicitud);
    }

    @Override
    public SolicitudDTO getSolicitudById(int id) {
        Solicitud solicitud = solicitudRepository.findById(id).orElse(null);
        return convertToDto(solicitud);
    }

    @Override
    public List<SolicitudDTO> getAllSolicitudes() {
        List<Solicitud> solicitudes = solicitudRepository.findAll();
        return solicitudes.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public SolicitudDTO updateSolicitud(SolicitudDTO solicitudDto) {
        Solicitud solicitud = new Solicitud();
        // Aquí copiar los campos de solicitudDto a solicitud
        solicitud = solicitudRepository.save(solicitud);
        return convertToDto(solicitud);
    }

    @Override
    public void deleteSolicitud(int id) {
        solicitudRepository.deleteById(id);
    }

    private SolicitudDTO convertToDto(Solicitud solicitud) {
        SolicitudDTO solicitudDto = new SolicitudDTO(solicitud.getId_solicitud(), solicitud.getFecha(), solicitud.getDescripcion(),solicitud.getDetalle(),solicitud.getCliente().getCedula());
        // Aquí copiar los campos de solicitud a solicitudDto
        return solicitudDto;
    }
}