package co.edu.uniquindio;

import co.edu.uniquindio.model.dto.*;
import co.edu.uniquindio.model.entities.Cliente;
import co.edu.uniquindio.model.enums.Estado;
import co.edu.uniquindio.services.interfaces.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@Transactional
@SpringBootTest
@Sql("classpath:dataset.sql")
public class ClienteServicioTest {

    @Autowired
    private ClienteService clienteService;

//    @Test
//    public void registrarClienteTest() throws Exception{
//        ClienteDTO cliente = new ClienteDTO(
//                "123456789",
//                "Juan",
//                "Pérez",
//                "555-1234",
//                "juan.perez@example.com",
//                "password123"
//        );
//        String cedula =clienteService.saveCliente(cliente);
//        Assertions.assertEquals("123456789",cedula);
//    }
//
//    @Test
//    public void actualizarClienteTest() throws Exception {
//
//        InformacionClienteDTO guardado = clienteService.getClienteById("12137792");
//
//        InformacionClienteDTO modificado = new InformacionClienteDTO(
//                guardado.cedula(),
//                guardado.nombre(),
//                guardado.apellido(),
//                "3202583678",
//                guardado.correo()
//        );
//        clienteService.updateCliente(modificado);
//        InformacionClienteDTO objetoModificado = clienteService.getClienteById("12137792");
//        Assertions.assertEquals("3202583678",objetoModificado.telefono());
//
//    }
//
//    @Test
//    public void saveSolicitud() throws Exception{
//
//        SolicitudDTO solicitudDTO = new SolicitudDTO(
//                3, LocalDate.now(),
//                "Descripcion de prueba",
//                "Detalle de prueba", "1234567890");
//        int id= clienteService.saveSolicitud(solicitudDTO);
//        Assertions.assertEquals(3,id);
//    }
//
//    @Test
//    public void getProyectosByCliente() throws Exception{
//        List<ListaProyectosDTO> lista = clienteService.getProyectosByCliente("0987654321");
//        lista.forEach(System.out::println);
//        Assertions.assertEquals(1,lista.size());
//
//    }
//
//    @Test
//    public void getProyectoTest() throws Exception{
//        ProyectoDTO proyectoDTO = clienteService.getProyecto(1);
//        Assertions.assertEquals("Proyecto A",proyectoDTO.nombre());
//    }
//
//    @Test
//    public void updateProyectoTest() throws Exception{
//        ProyectoDTO guardado = clienteService.getProyecto(1);
//
//        ProyectoDTO modificado = new ProyectoDTO(
//                guardado.idProyecto(),
//                guardado.nombre(),
//                guardado.descripcion(),
//                guardado.fechaInicio(),
//                guardado.fechaFin(),
//                Estado.RECHAZADO,
//                guardado.solicitudId(),
//                guardado.nombreEmpleado()
//        );
//
//        clienteService.updateProyecto(modificado);
//
//        ProyectoDTO objetoModificado = clienteService.getProyecto(1);
//        Assertions.assertEquals(Estado.RECHAZADO,objetoModificado.estadoProyecto());
//
//    }

}


