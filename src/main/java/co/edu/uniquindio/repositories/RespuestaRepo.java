package co.edu.uniquindio.repositories;

import co.edu.uniquindio.model.entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepo extends JpaRepository<Respuesta,Integer > {
}
