package co.edu.uniquindio.model.entities;

import co.edu.uniquindio.model.enums.Cargo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Empleado extends Usuario implements Serializable {

    @Column(nullable = false, length = 10, updatable = false)
    private String idEmpleado;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    private Cargo cargo;

    @OneToMany(mappedBy = "empleado")
    private List<Respuesta> respuestas;

    @OneToMany(mappedBy = "empleado")
    private List<Proyecto> proyectos;
}