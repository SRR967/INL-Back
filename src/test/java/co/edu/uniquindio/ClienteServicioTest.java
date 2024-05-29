package co.edu.uniquindio;

import co.edu.uniquindio.model.dto.ClienteDTO;
import co.edu.uniquindio.services.interfaces.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class ClienteServicioTest {

    @Autowired
    private ClienteService clienteService;

    @Test
    public void registrarClienteTest() throws Exception{
        ClienteDTO cliente = new ClienteDTO(
                "123456789",
                "Juan",
                "Pérez",
                "555-1234",
                "juan.perez@example.com",
                "password123"
        );
        String cedula =clienteService.saveCliente(cliente);
        Assertions.assertEquals("123456789",cedula);
    }
}


