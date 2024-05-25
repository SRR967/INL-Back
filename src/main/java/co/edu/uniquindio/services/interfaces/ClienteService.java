package co.edu.uniquindio.services.interfaces;

import co.edu.uniquindio.model.dto.*;

import java.util.List;

public interface ClienteService {
    String saveCliente(ClienteDTO clienteDto) throws Exception;
    InformacionClienteDTO getClienteById(String cedula)throws Exception;
    List<InformacionClienteDTO> getAllClientes() throws Exception;
    String updateCliente(InformacionClienteDTO clienteDto) throws Exception;
    void deleteCliente(String cedula) throws Exception;
    int saveSolicitud(SolicitudDTO solicitudDTO) throws Exception;
    List<ListaProyectosDTO> getProyectosByCliente(String cedula) throws Exception;
    ProyectoDTO getProyecto(int codigoSolicitud) throws Exception;
    int updateProyecto(ProyectoDTO proyectoDTO) throws Exception;

}

