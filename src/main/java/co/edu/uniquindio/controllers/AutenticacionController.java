package co.edu.uniquindio.controllers;

import co.edu.uniquindio.model.dto.ClienteDTO;
import co.edu.uniquindio.model.dto.LoginDTO;
import co.edu.uniquindio.model.dto.MensajeDTO;
import co.edu.uniquindio.model.dto.TokenDTO;
import co.edu.uniquindio.services.interfaces.AutenticacionService;
import co.edu.uniquindio.services.interfaces.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AutenticacionController {

    private final AutenticacionService autenticacionService;
    private final ClienteService clienteService;

    @PostMapping("/login")
    public ResponseEntity<MensajeDTO<TokenDTO>> login (@Valid @RequestBody LoginDTO loginDto) throws Exception{

        TokenDTO tokenDto= autenticacionService.login(loginDto);
        return ResponseEntity.ok().body(new MensajeDTO<>(false,tokenDto));

    }

    @PostMapping("/registrarse")
    public ResponseEntity<MensajeDTO<String>> registrar(@Valid @RequestBody ClienteDTO crearPacienteDto) throws Exception{
        clienteService.saveCliente(crearPacienteDto);
        return ResponseEntity.ok().body(new MensajeDTO<>(false,"Paciente registrado correctamente"));
    }

}
