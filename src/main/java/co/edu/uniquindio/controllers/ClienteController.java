// ClienteController.java
package co.edu.uniquindio.controllers;

import co.edu.uniquindio.model.dto.*;
import co.edu.uniquindio.services.interfaces.ClienteService;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/{cedula}")
    public ResponseEntity<MensajeDTO<InformacionClienteDTO>> getClienteById(@PathVariable String cedula) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false,clienteService.getClienteById(cedula)));
    }

    @PostMapping("/crear-solicitud")
    public ResponseEntity<MensajeDTO<String>> saveSolicitud (@RequestBody SolicitudDTO solicitudDTO) throws Exception {
        clienteService.saveSolicitud(solicitudDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false,"Solicitud creada correctamente"));
    }

    @GetMapping("/solicitudes/{cedula}")
    public ResponseEntity<MensajeDTO<List<ListaProyectosDTO>>> getSolicitudesCliente (@PathVariable String cedula) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false,clienteService.getProyectosByCliente(cedula)));
    }

    @GetMapping("/proyecto/{id}")
    public ResponseEntity<MensajeDTO<ProyectoDTO>> getProyecto(@PathVariable int id) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false,clienteService.getProyecto(id)));
    }

    @PutMapping("/actualizar-proyecto")
    public ResponseEntity<MensajeDTO<Integer>> updateProyecto(@RequestBody ProyectoDTO proyectoDTO) throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false, clienteService.updateProyecto(proyectoDTO)));
    }




    @GetMapping()
    public List<InformacionClienteDTO> getAllClientes() throws Exception {
        return clienteService.getAllClientes();
    }

    @PutMapping
    public String updateCliente(@RequestBody InformacionClienteDTO clienteDto) throws Exception {
        return clienteService.updateCliente(clienteDto);
    }

    @DeleteMapping("/{cedula}")
    public void deleteCliente(@PathVariable String cedula) throws Exception {
        clienteService.deleteCliente(cedula);
    }
}