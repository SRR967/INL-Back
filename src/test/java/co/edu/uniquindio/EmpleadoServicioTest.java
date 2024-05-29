package co.edu.uniquindio;


import co.edu.uniquindio.model.dto.ListaProyectosDTO;
import co.edu.uniquindio.model.dto.ProyectoDTO;
import co.edu.uniquindio.model.dto.RespuestaDTO;
import co.edu.uniquindio.services.interfaces.EmpleadoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
@Sql("classpath:dataset.sql")
public class EmpleadoServicioTest {

    @Autowired
    private EmpleadoService empleadoService;

    @Test
    public void verListaSolicitudesTest()throws Exception{
        List<ListaProyectosDTO> lista = empleadoService.verListaSolicitudes();
        lista.forEach(System.out::println);
        Assertions.assertEquals(2,lista.size());
    }

    @Test
    public void radicarSolicitudTest () throws Exception{
        RespuestaDTO respuestaDTO = new RespuestaDTO(
                2,
                "No se aprobo la solicitud",
                1,
                "1080367852"
        );
        int id = empleadoService.radicarSolicitud(respuestaDTO);
        Assertions.assertEquals(2,id);
    }

    @Test
    public void getProyectoTest() throws Exception{
        ProyectoDTO proyectoDTO = empleadoService.getProyecto(1);
        Assertions.assertEquals("Proyecto A",proyectoDTO.nombre());

    }




}
