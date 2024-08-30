package com.umg.control_empleados.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sesiones")
public class sesiones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "empleado_id",nullable = false)
    private empleados empleado;

    @Column(nullable = false, updatable = false)
    private LocalDate inicio = LocalDate.now();

    @Column(nullable = false, updatable = false)
    private LocalDate fin = LocalDate.now();
}
