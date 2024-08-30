package com.umg.control_empleados.models;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "registros_marcaje")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class registros_marcaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name="empleado_id",nullable=false)
    private empleados empleado;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column (name="hora",nullable = false)
    private LocalTime hora;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMarcaje tipo;

    public enum TipoMarcaje{
        ENTRADA,SALIDA
    }
}
