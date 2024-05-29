package co.edu.uniquindio.services.implementacion;

import co.edu.uniquindio.model.dto.ListaProyectosDTO;
import co.edu.uniquindio.model.dto.ProyectoDTO;
import co.edu.uniquindio.model.dto.RespuestaDTO;
import co.edu.uniquindio.model.dto.SolicitudDTO;
import co.edu.uniquindio.repositories.SolicitudRepo;
import co.edu.uniquindio.services.interfaces.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final SolicitudService solicitudService;
    private final RespuestaService respuestaService;
    private final ProyectoService proyectoService;
    private final EmailService emailService;
    private final ClienteService clienteService;

    @Override
    public List<ListaProyectosDTO> verListaSolicitudes() throws Exception {
        return solicitudService.getAllSolicitudes();
    }

    @Override
    public int radicarSolicitud(RespuestaDTO respuestaDTO) throws Exception {
        SolicitudDTO solicitudDTO = solicitudService.getSolicitudById(respuestaDTO.solicitudId());
        emailService.sendSimpleMessage(clienteService.getClienteById(solicitudDTO.clienteCedula()).correo(),"Estado de Solicitud","Su solicitud a cambiado de estado");
        return respuestaService.save(respuestaDTO);
    }

    @Override
    public ProyectoDTO getProyecto(int codigo) throws Exception {
        return  proyectoService.getProyectoById(codigo);
    }
}
