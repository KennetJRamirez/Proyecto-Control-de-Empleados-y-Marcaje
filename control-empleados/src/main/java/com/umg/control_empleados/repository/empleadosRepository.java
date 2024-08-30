package com.umg.control_empleados.repository;

import com.umg.control_empleados.models.empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface empleadosRepository extends JpaRepository<empleados,Long> {
}
