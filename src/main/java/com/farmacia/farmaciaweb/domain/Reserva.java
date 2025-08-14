package com.farmacia.farmaciaweb.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombreCliente;
    private Integer cantidadEntradas;
    private LocalDateTime fechaReserva;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    // Eliminamos cualquier referencia a Usuario para evitar errores de mappedBy
}
