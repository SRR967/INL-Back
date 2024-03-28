package co.edu.uniquindio.model.entities;

import co.edu.uniquindio.model.enums.Estado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_solicitud;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String detalle;

    @ManyToOne
    private Cliente cliente;

    @OneToOne
    private Proyecto proyecto;

    @OneToOne(mappedBy = "solicitud")
    private Solicitud solicitud;

    private Estado estadoSolicitud;
}
