// ClienteController.java
package co.edu.uniquindio.controllers;

import co.edu.uniquindio.model.dto.ClienteDTO;
import co.edu.uniquindio.services.interfaces.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteDTO saveCliente(@RequestBody ClienteDTO clienteDto) {
        return clienteService.saveCliente(clienteDto);
    }

    @GetMapping("/{cedula}")
    public ClienteDTO getClienteById(@PathVariable String cedula) {
        return clienteService.getClienteById(cedula);
    }

    @GetMapping
    public List<ClienteDTO> getAllClientes() {git 
        return clienteService.getAllClientes();
    }

    @PutMapping
    public ClienteDTO updateCliente(@RequestBody ClienteDTO clienteDto) {
        return clienteService.updateCliente(clienteDto);
    }

    @DeleteMapping("/{cedula}")
    public void deleteCliente(@PathVariable String cedula) {
        clienteService.deleteCliente(cedula);
    }
}