package com.umg.control_empleados.controllers;

import com.umg.control_empleados.models.empleados;
import com.umg.control_empleados.models.sesiones;
import com.umg.control_empleados.repository.empleadosRepository;
import com.umg.control_empleados.repository.sesionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class sesionesController {

    @Autowired
    private sesionesRepository sesionesRepository;
    @Autowired
    private empleadosRepository empleadosRepository;



    //registrar marcaje
    @PostMapping("/sesion/inicio/{id}")
    public ResponseEntity<Long> sesionInicio(@PathVariable(value = "id") Long empleadoID) {
        Optional<empleados> empleados = empleadosRepository.findById(empleadoID);
        if (empleados.isPresent()) {
            sesiones sesion = new sesiones();
            sesion.setEmpleado(empleados.get());
            sesion.setInicio(LocalDateTime.now()); // Usa LocalDateTime para guardar fecha y hora
            sesionesRepository.save(sesion);
            return ResponseEntity.ok(sesion.getId());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/sesion/fin/{id}")
    public ResponseEntity<sesiones> sesionFin(@PathVariable(value = "id") Long sesionID){
        Optional<sesiones> OptionalSesiones = sesionesRepository.findById(sesionID);
        if (OptionalSesiones.isPresent()) {
            sesiones sesion = OptionalSesiones.get();
            sesion.setFin(LocalDateTime.now()); // Usa LocalDateTime para guardar fecha y hora
            sesionesRepository.save(sesion);
            return ResponseEntity.ok(sesion);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
