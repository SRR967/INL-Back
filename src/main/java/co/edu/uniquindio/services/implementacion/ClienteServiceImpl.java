package co.edu.uniquindio.services.implementacion;

import co.edu.uniquindio.model.entities.Cliente;
import co.edu.uniquindio.model.dto.ClienteDTO;
import co.edu.uniquindio.repositories.ClienteRepo;
import co.edu.uniquindio.services.interfaces.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    //@Autowired
    private ClienteRepo clienteRepository;

    @Override
    public ClienteDTO saveCliente(ClienteDTO clienteDto) {
        Cliente cliente = new Cliente();
        // Aquí copiar los campos de clienteDto a cliente
        cliente = clienteRepository.save(cliente);
        return convertToDto(cliente);
    }

    @Override
    public ClienteDTO getClienteById(String cedula) {
        Cliente cliente = clienteRepository.findById(cedula).orElse(null);
        return convertToDto(cliente);
    }

    @Override
public List<ClienteDTO> getAllClientes() {
    List<ClienteDTO> clientes = new ArrayList<>();

    // Agrega los datos quemados
    clientes.add(new ClienteDTO("123", "Juan", "Perez", "1234567890"));
    clientes.add(new ClienteDTO("456", "Maria", "Rodriguez", "0987654321"));
    // Agrega más clientes si lo deseas...

    return clientes;
}

    @Override
    public ClienteDTO updateCliente(ClienteDTO clienteDto) {
        Cliente cliente = new Cliente();
        // Aquí copiar los campos de clienteDto a cliente
        cliente = clienteRepository.save(cliente);
        return convertToDto(cliente);
    }

    @Override
    public void deleteCliente(String cedula) {
        clienteRepository.deleteById(cedula);
    }

    private ClienteDTO convertToDto(Cliente cliente) {
        ClienteDTO clienteDto = new ClienteDTO(cliente.getCedula(), cliente.getNombre(), cliente.getApellido(), cliente.getTelefono());
        // Aquí copiar los campos de cliente a clienteDto
        return clienteDto;
    }
}