package co.edu.uniquindio.services.implementacion;

import co.edu.uniquindio.model.dto.ListaProyectosDTO;
import co.edu.uniquindio.model.dto.ProyectoDTO;
import co.edu.uniquindio.model.dto.RespuestaDTO;
import co.edu.uniquindio.model.dto.SolicitudDTO;
import co.edu.uniquindio.repositories.SolicitudRepo;
import co.edu.uniquindio.services.interfaces.EmpleadoService;
import co.edu.uniquindio.services.interfaces.ProyectoService;
import co.edu.uniquindio.services.interfaces.RespuestaService;
import co.edu.uniquindio.services.interfaces.SolicitudService;
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

    @Override
    public List<ListaProyectosDTO> verListaSolicitudes() throws Exception {
        return solicitudService.getAllSolicitudes();
    }

    @Override
    public int radicarSolicitud(RespuestaDTO respuestaDTO) throws Exception {
        return respuestaService.save(respuestaDTO);
    }

    @Override
    public ProyectoDTO getProyecto(int codigo) throws Exception {
        return  proyectoService.getProyectoById(codigo);
    }
}
