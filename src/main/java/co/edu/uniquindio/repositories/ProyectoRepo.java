package co.edu.uniquindio.repositories;

import co.edu.uniquindio.model.entities.Cliente;
import co.edu.uniquindio.model.entities.Proyecto;
import co.edu.uniquindio.model.enums.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoRepo extends JpaRepository<Proyecto, Integer> {
    List<Proyecto> findByIdSolicitudCliente(Cliente cliente);
    Proyecto findByIdSolicitud(int idSolicitud);
    Proyecto findByIdProyecto(int idProyecto);
}
