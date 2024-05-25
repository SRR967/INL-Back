package co.edu.uniquindio.services.implementacion;

import co.edu.uniquindio.model.dto.ListaProyectosDTO;
import co.edu.uniquindio.model.dto.ProyectoDTO;
import co.edu.uniquindio.model.dto.SolicitudDTO;
import co.edu.uniquindio.model.entities.Cliente;
import co.edu.uniquindio.model.dto.ClienteDTO;
import co.edu.uniquindio.model.entities.Proyecto;
import co.edu.uniquindio.model.entities.Solicitud;
import co.edu.uniquindio.model.enums.Estado;
import co.edu.uniquindio.repositories.ClienteRepo;
import co.edu.uniquindio.repositories.ProyectoRepo;
import co.edu.uniquindio.repositories.SolicitudRepo;
import co.edu.uniquindio.services.interfaces.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Transactional
@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepo clienteRepository;
    private final SolicitudRepo solicitudRepository;
    private final ProyectoRepo proyectoRepository;

    private boolean estaRepetidoCorreo(String email, String cedula) {
        Cliente cliente = clienteRepository.findByEmail(email);
        return cliente != null && !cliente.getCedula().equals(cedula);
    }

    private boolean estaRepetidoCedula(String cedula){
        Cliente cliente = clienteRepository.findByCedula(cedula);
        return cliente != null;
    }

    private Cliente verificarCliente(String cedula) throws Exception{
        Cliente cliente = clienteRepository.findByCedula(cedula);
        if (cliente==null){
            throw new Exception("El cliente con la cedula "+cedula+" no se encuentra registrado");
        }
        return cliente;
    }


    @Override
    public String saveCliente(ClienteDTO clienteDto) throws Exception {

        if (estaRepetidoCedula(clienteDto.cedula())){
            throw new Exception("La cedula "+clienteDto.cedula()+" ya se encuentra registrada");
        }
        if (estaRepetidoCorreo(clienteDto.correo(),clienteDto.cedula())){
            throw new Exception("El correo "+clienteDto.correo()+" ya se encuentra registrado");
        }
        Cliente cliente = new Cliente();
        cliente.setCedula(clienteDto.cedula());
        cliente.setNombre(clienteDto.nombre());
        cliente.setApellido(clienteDto.apellido());
        cliente.setTelefono(clienteDto.telefono());
        cliente.setEmail(clienteDto.correo());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncriptada = passwordEncoder.encode(clienteDto.contrasena());
        cliente.setContrasena(passwordEncriptada);

        cliente = clienteRepository.save(cliente);
        return cliente.getCedula();
    }

    @Override
    public ClienteDTO getClienteById(String cedula) throws Exception {
        Cliente cliente = verificarCliente(cedula);
        return convertToDto(cliente);
    }

    @Override
public List<ClienteDTO> getAllClientes() {
    List<ClienteDTO> clientes = new ArrayList<>();


    return clientes;
}

    @Override
    public String updateCliente(ClienteDTO clienteDto) throws Exception {
        Cliente cliente = new Cliente();

        if (estaRepetidoCorreo(clienteDto.correo(), clienteDto.cedula())){
            throw new Exception("Ya existe una cuenta registrado con ese correo");
        }
        cliente.setEmail(clienteDto.correo());
        cliente.setTelefono(clienteDto.telefono());
        cliente = clienteRepository.save(cliente);
        return cliente.getCedula();
    }

    @Override
    public void deleteCliente(String cedula) {
        clienteRepository.deleteById(cedula);
    }

    @Override
    public int saveSolicitud(SolicitudDTO solicitudDTO) throws Exception {
        Cliente cliente = verificarCliente(solicitudDTO.clienteCedula());
        List<Solicitud> solicitudesCliente = solicitudRepository.getSolicitudByClienteAndEstadoSolicitudOrEstadoSolicitud(cliente,Estado.ENPROCESO,Estado.APROBADO);
        if (!solicitudesCliente.isEmpty()){
            throw new Exception("Solo se pueden tener 1 solicitud activa por usuario");
        }

        Solicitud solicitud = new Solicitud();

        solicitud.setCliente(cliente);
        solicitud.setDetalle(solicitudDTO.detalle());
        solicitud.setDescripcion(solicitudDTO.descripcion());
        solicitud.setFecha(LocalDate.now());
        solicitud.setEstadoSolicitud(Estado.ENPROCESO);

        solicitud= solicitudRepository.save(solicitud);
        return solicitud.getId_solicitud();
    }

    @Override
    public List<ListaProyectosDTO> getProyectosByCliente(String cedula) throws Exception {
        Cliente cliente = verificarCliente(cedula);
        List<Proyecto> listaProyectos = proyectoRepository.findByIdSolicitud_Cliente_Cedula(cliente.getCedula());
        if (listaProyectos.isEmpty()){
            throw new Exception("No hay proyectos asociados a la cedula:"+cedula);
        }
        List<ListaProyectosDTO> listaProyectosDTOS =listaProyectos.stream().map(
                proyecto ->new ListaProyectosDTO(
                        proyecto.getIdProyecto(),
                        proyecto.getFechaInicio(),
                        proyecto.getNombre(),
                        proyecto.getEstadoProyecto()
                )).toList();

        return listaProyectosDTOS;
    }

    @Override
    public ProyectoDTO getProyecto(int codigoSolicitud) throws Exception {
        //Proyecto proyecto = proyectoRepository.findByIdSolicitud_Id_solicitud(codigoSolicitud);
        Proyecto proyecto= null;
        if (proyecto ==null){
            throw new Exception("Error al buscar el proyecto con el codigo de solicitud "+codigoSolicitud);
        }
        return new ProyectoDTO(proyecto.getIdProyecto(), proyecto.getNombre(),
                proyecto.getDescripcion(), proyecto.getFechaInicio(),proyecto.getFechaFin(),
                proyecto.getEstadoProyecto(),proyecto.getIdSolicitud().getId_solicitud(),
                proyecto.getEmpleado().getNombre() + proyecto.getEmpleado().getApellido());
    }

    @Override
    public int updateProyecto(ProyectoDTO proyectoDTO) throws Exception {
        Proyecto proyecto = proyectoRepository.findByIdProyecto(proyectoDTO.idProyecto());

        if (proyecto ==null){
            throw new Exception("Error al buscar el proyecto "+proyectoDTO.idProyecto());
        }
        proyecto.setNombre(proyectoDTO.nombre());
        proyecto.setDescripcion(proyectoDTO.descripcion());
        proyectoRepository.save(proyecto);
        return proyecto.getIdProyecto();
    }

    private ClienteDTO convertToDto(Cliente cliente) {
        ClienteDTO clienteDto = new ClienteDTO(cliente.getCedula(), cliente.getNombre(),
                cliente.getApellido(), cliente.getTelefono(), cliente.getEmail(), cliente.getContrasena());
        // Aquí copiar los campos de cliente a clienteDto
        return clienteDto;
    }
}