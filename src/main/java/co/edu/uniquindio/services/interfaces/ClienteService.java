package co.edu.uniquindio.services.interfaces;

import co.edu.uniquindio.model.dto.ClienteDTO;
import java.util.List;

public interface ClienteService {
    ClienteDTO saveCliente(ClienteDTO clienteDto);
    ClienteDTO getClienteById(String cedula);
    List<ClienteDTO> getAllClientes();
    ClienteDTO updateCliente(ClienteDTO clienteDto);
    void deleteCliente(String cedula);
}

