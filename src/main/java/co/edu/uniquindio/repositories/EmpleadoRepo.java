package co.edu.uniquindio.repositories;

import co.edu.uniquindio.model.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepo extends JpaRepository<Empleado, String> {

    Empleado getEmpleadoByCedula(String idEmpleado);
}
