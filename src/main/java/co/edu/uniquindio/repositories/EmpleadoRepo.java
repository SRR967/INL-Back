package co.edu.uniquindio.repositories;

import co.edu.uniquindio.model.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepo extends JpaRepository<Empleado, String> {
}
