package co.edu.uniquindio.repositories;

import co.edu.uniquindio.model.entities.Cliente;
import co.edu.uniquindio.model.entities.Empleado;
import co.edu.uniquindio.model.entities.Solicitud;
import co.edu.uniquindio.model.enums.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudRepo extends JpaRepository<Solicitud, Integer>{
    List<Solicitud> getSolicitudByClienteAndEstadoSolicitudOrEstadoSolicitud(Cliente cliente, Estado estado,Estado estado1);

    Solicitud getSolicitudByIdSolicitud(int idSolicitud);
}
