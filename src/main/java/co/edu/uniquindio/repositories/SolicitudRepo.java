package co.edu.uniquindio.repositories;

import co.edu.uniquindio.model.entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepo extends JpaRepository<Solicitud, Integer>{
}
