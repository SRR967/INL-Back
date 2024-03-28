package co.edu.uniquindio.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mensaje;

    @OneToOne
    private Solicitud solicitud;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

}
