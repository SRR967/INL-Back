package co.edu.uniquindio.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDocumento;

    @Column(nullable = false)
    private String nombreDocumento;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    private Proyecto proyecto;
}
