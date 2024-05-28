package co.edu.uniquindio.services.implementacion;

import co.edu.uniquindio.model.dto.RespuestaDTO;
import co.edu.uniquindio.model.entities.Documento;
import co.edu.uniquindio.model.entities.Empleado;
import co.edu.uniquindio.model.entities.Respuesta;
import co.edu.uniquindio.model.entities.Solicitud;
import co.edu.uniquindio.repositories.EmpleadoRepo;
import co.edu.uniquindio.repositories.RespuestaRepo;
import co.edu.uniquindio.repositories.SolicitudRepo;
import co.edu.uniquindio.services.interfaces.EmpleadoService;
import co.edu.uniquindio.services.interfaces.RespuestaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RespuestaServiceImpl implements RespuestaService {

    private final RespuestaRepo respuestaRepo;
    private final SolicitudRepo solicitudRepo;
    private final EmpleadoRepo empleadoRepo;
    @Override
    public int save(RespuestaDTO respuestaDTO) throws Exception {
        Solicitud solicitud = solicitudRepo.getSolicitudById_solicitud(respuestaDTO.solicitudId());
        Respuesta respuesta = new Respuesta();
        Empleado empleado = empleadoRepo.getEmpleadoByIdEmpleado(respuestaDTO.idEmpleado());
        if (empleado == null){
            throw new Exception("El empleado con la cedula " +respuestaDTO.idEmpleado()+" no existe");
        }

        respuesta.setEmpleado(empleado);
        respuesta.setMensaje(respuestaDTO.contenido());
        respuesta.setSolicitud(solicitud);
        respuestaRepo.save(respuesta);

        solicitud.setRespuesta(respuesta);
        solicitudRepo.save(solicitud);

        return respuesta.getId();
    }

    @Override
    public RespuestaDTO findById(int id) throws Exception {
        return null;
    }
}
