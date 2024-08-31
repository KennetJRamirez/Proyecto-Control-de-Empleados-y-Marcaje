package com.umg.control_empleados.repository;

import com.umg.control_empleados.models.empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface empleadosRepository extends JpaRepository<empleados,Long> {
    Optional<empleados> findByEmail(String email);
}
