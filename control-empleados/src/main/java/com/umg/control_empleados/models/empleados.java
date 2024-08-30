package com.umg.control_empleados.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name= "empleados")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name="contrasena", nullable = false)
    private String contrasena;

    @Column(name="activo", nullable = false)
    private int activo;

}
