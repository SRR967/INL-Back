package co.edu.uniquindio.controllers;

import co.edu.uniquindio.model.dto.ListaProyectosDTO;
import co.edu.uniquindio.model.dto.MensajeDTO;
import co.edu.uniquindio.model.dto.ProyectoDTO;
import co.edu.uniquindio.model.dto.RespuestaDTO;
import co.edu.uniquindio.services.interfaces.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping("/lista-solicitudes")
    public ResponseEntity<MensajeDTO<List<ListaProyectosDTO>>> verListaSolicitudes() throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, empleadoService.verListaSolicitudes()));
    }

    @PostMapping("/radicar-solicitud")
    public ResponseEntity<MensajeDTO<String>> radicarSolicitud(@RequestBody RespuestaDTO respuestaDTO)throws Exception{
        empleadoService.radicarSolicitud(respuestaDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false,"Solicitud Resuelta"));
    }

    @GetMapping("/proyecto/{idProyecto}")
    public ResponseEntity<MensajeDTO<ProyectoDTO>> getProyecto(@PathVariable int idProyecto)throws Exception{
        return ResponseEntity.ok().body(new MensajeDTO<>(false,empleadoService.getProyecto(idProyecto)));
    }
}
