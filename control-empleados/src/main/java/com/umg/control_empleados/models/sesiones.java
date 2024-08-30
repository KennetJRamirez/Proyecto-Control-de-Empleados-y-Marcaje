package com.umg.control_empleados.models;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

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
    private LocalDateTime  inicio = LocalDateTime.now();

    @Column(nullable = false, updatable = false)
    private LocalDateTime  fin = LocalDateTime .now();
}
