package co.edu.uniquindio.repositories;

import co.edu.uniquindio.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

}