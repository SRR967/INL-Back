package co.edu.uniquindio.services.interfaces;

import co.edu.uniquindio.model.dto.ClienteDTO;
import co.edu.uniquindio.model.dto.ListaProyectosDTO;
import co.edu.uniquindio.model.dto.ProyectoDTO;
import co.edu.uniquindio.model.dto.SolicitudDTO;

import java.util.List;

public interface ClienteService {
    String saveCliente(ClienteDTO clienteDto) throws Exception;
    ClienteDTO getClienteById(String cedula)throws Exception;
    List<ClienteDTO> getAllClientes() throws Exception;
    String updateCliente(ClienteDTO clienteDto) throws Exception;
    void deleteCliente(String cedula) throws Exception;
    int saveSolicitud(SolicitudDTO solicitudDTO) throws Exception;
    List<ListaProyectosDTO> getProyectosByCliente(String cedula) throws Exception;
    ProyectoDTO getProyecto(int codigoSolicitud) throws Exception;
    int updateProyecto(ProyectoDTO proyectoDTO) throws Exception;

}

