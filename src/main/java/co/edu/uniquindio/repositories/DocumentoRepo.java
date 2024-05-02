package co.edu.uniquindio.repositories;

import co.edu.uniquindio.model.entities.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepo extends JpaRepository<Documento, Integer> {
}
