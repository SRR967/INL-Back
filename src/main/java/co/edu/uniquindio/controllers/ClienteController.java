// ClienteController.java
package co.edu.uniquindio.controllers;

import co.edu.uniquindio.model.dto.ClienteDTO;
import co.edu.uniquindio.services.interfaces.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public String saveCliente(@RequestBody ClienteDTO clienteDto) throws Exception {
        return clienteService.saveCliente(clienteDto);
    }

    @GetMapping("/{cedula}")
    public ClienteDTO getClienteById(@PathVariable String cedula) throws Exception {
        return clienteService.getClienteById(cedula);
    }

    @GetMapping
    public List<ClienteDTO> getAllClientes() throws Exception {
        return clienteService.getAllClientes();
    }

    @PutMapping
    public String updateCliente(@RequestBody ClienteDTO clienteDto) throws Exception {
        return clienteService.updateCliente(clienteDto);
    }

    @DeleteMapping("/{cedula}")
    public void deleteCliente(@PathVariable String cedula) throws Exception {
        clienteService.deleteCliente(cedula);
    }
}