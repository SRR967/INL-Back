package co.edu.uniquindio.services.implementacion;

import co.edu.uniquindio.model.entities.Cliente;
import co.edu.uniquindio.model.dto.ClienteDTO;
import co.edu.uniquindio.repositories.ClienteRepo;
import co.edu.uniquindio.services.interfaces.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
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
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(this::convertToDto).collect(Collectors.toList());
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