package co.edu.uniquindio.repositories;

import co.edu.uniquindio.model.entities.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {
    Cliente findByEmail(String correo);

    Cliente findByCedula(String cedula);
}
