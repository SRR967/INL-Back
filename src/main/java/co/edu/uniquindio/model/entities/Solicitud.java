package co.edu.uniquindio.model.entities;

import co.edu.uniquindio.model.enums.Estado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Solicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSolicitud;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String detalle;

    @ManyToOne
    private Cliente cliente;

    @OneToOne(mappedBy = "idSolicitud")
    private Proyecto proyecto;

    @OneToOne(mappedBy = "solicitud")
    private Respuesta respuesta;

    private Estado estadoSolicitud;
}
