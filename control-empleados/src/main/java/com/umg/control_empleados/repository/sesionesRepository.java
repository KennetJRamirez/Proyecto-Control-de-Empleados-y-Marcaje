package com.umg.control_empleados.repository;

import com.umg.control_empleados.models.sesiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sesionesRepository extends JpaRepository <sesiones,Long>{ }
