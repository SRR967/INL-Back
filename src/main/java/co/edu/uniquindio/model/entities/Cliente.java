package co.edu.uniquindio.model.entities;

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
public class Cliente extends Usuario implements Serializable {


    @Column(nullable = false, length = 10, updatable = false)
    private String cedula;

    @Column(nullable = false, length =50)
    private String nombre;

    @Column(nullable = false, length =50)
    private String apellido;

    @Column(nullable = false, length =10)
    private String telefono;

    @OneToMany(mappedBy = "cliente")
    private List<Solicitud> listaSolicitudes;
}
