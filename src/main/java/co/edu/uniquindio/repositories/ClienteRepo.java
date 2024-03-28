package co.edu.uniquindio.repositories;

import co.edu.uniquindio.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente, String> {
}
