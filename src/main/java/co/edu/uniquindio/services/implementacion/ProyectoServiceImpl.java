package co.edu.uniquindio.services.implementacion;

import co.edu.uniquindio.model.entities.Proyecto;
import co.edu.uniquindio.model.dto.ProyectoDTO;
import co.edu.uniquindio.repositories.ProyectoRepo;
import co.edu.uniquindio.services.interfaces.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    //@Autowired
    private ProyectoRepo proyectoRepository;

    @Override
    public ProyectoDTO saveProyecto(ProyectoDTO proyectoDto) {
        Proyecto proyecto = new Proyecto();
        // Aquí copiar los campos de proyectoDto a proyecto
        proyecto = proyectoRepository.save(proyecto);
        return convertToDto(proyecto);
    }

    @Override
    public ProyectoDTO getProyectoById(int id) {
        Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
        return convertToDto(proyecto);
    }

    @Override
    public List<ProyectoDTO> getAllProyectos() {
        List<Proyecto> proyectos = proyectoRepository.findAll();
        return proyectos.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public ProyectoDTO updateProyecto(ProyectoDTO proyectoDto) {
        Proyecto proyecto = new Proyecto();
        // Aquí copiar los campos de proyectoDto a proyecto
        proyecto = proyectoRepository.save(proyecto);
        return convertToDto(proyecto);
    }

    @Override
    public void deleteProyecto(int id) {
        proyectoRepository.deleteById(id);
    }

    private ProyectoDTO convertToDto(Proyecto proyecto) {
        ProyectoDTO proyectoDto = new ProyectoDTO(proyecto.getIdProyecto(), proyecto.getNombre(), proyecto.getDescripcion(), proyecto.getFechaInicio(), proyecto.getFechaFin(), proyecto.getEstadoProyecto(), proyecto.getIdSolicitud().getId_solicitud(),proyecto.getEmpleado().getIdEmpleado());
        // Aquí copiar los campos de proyecto a proyectoDto
        return proyectoDto;
    }
}