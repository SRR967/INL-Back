// ClienteController.java
package co.edu.uniquindio.controllers;

import co.edu.uniquindio.model.dto.*;
import co.edu.uniquindio.services.implementacion.EmailService;
import co.edu.uniquindio.services.interfaces.ChatBotService;
import co.edu.uniquindio.services.interfaces.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final EmailService emailService;
    private final ChatBotService chatBotService;

    @GetMapping("/{cedula}")
    public ResponseEntity<MensajeDTO<InformacionClienteDTO>> getClienteById(@PathVariable String cedula) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false,clienteService.getClienteById(cedula)));
    }

    @PostMapping("/crear-solicitud")
    public ResponseEntity<MensajeDTO<String>> saveSolicitud (@RequestBody SolicitudDTO solicitudDTO) throws Exception {
        System.out.println("solicitud");
        clienteService.saveSolicitud(solicitudDTO);
        emailService.sendSimpleMessage(clienteService.getClienteById(solicitudDTO.clienteCedula()).correo(),"Solicitud creada","Su solicitud ha sido creada correctamente");
        //emailService.sendSimpleMessage("marlons.espinosaj@gmail.com","Solicitud creada","Su solicitud ha sido creada correctamente");
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

    @GetMapping("/chatbot")
    public String chatbotWelcome() {
        return "Hola! Soy tu chatbot. ¿Cómo te puedo ayudar hoy?";
    }

    @PostMapping("/chatbot")
    public String chatbotMessage(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        try {
            return chatBotService.getResponse(message);
        } catch (IOException e) {
            e.printStackTrace();
            return "Lo siento, hubo un problema al procesar tu solicitud.";
        }
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