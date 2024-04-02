package co.edu.uniquindio.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Documento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocumento;

    @Column(nullable = false)
    private String nombreDocumento;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    private Proyecto proyecto;
}
