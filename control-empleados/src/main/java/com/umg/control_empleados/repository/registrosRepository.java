package com.umg.control_empleados.repository;

import com.umg.control_empleados.models.registros_marcaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface registrosRepository extends JpaRepository<registros_marcaje, Long> {
}
