package com.umg.control_empleados.controllers;

import com.umg.control_empleados.models.empleados;
import com.umg.control_empleados.repository.empleadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class empleadosController {

    @Autowired
    private empleadosRepository empleadosRepository;


    @GetMapping("/empleados")
    public List<empleados> getAllEmpleados(){
        return empleadosRepository.findAll();
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<empleados> getEmpleadosById(@PathVariable (value = "id") Long id) {
        Optional<empleados> empleados = empleadosRepository.findById(id);
        if (empleados.isPresent()) {
            return ResponseEntity.ok(empleados.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/empleados")
    public empleados createEmpleados (@RequestBody empleados empleados){
        return empleadosRepository.save(empleados);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<empleados> updateEmpleado(@PathVariable (value = "id") Long id, @RequestBody empleados empleadoDetalles){
        Optional<empleados> Optionalempleados = empleadosRepository.findById(id);
        if (Optionalempleados.isPresent()) {
            empleados empleado = Optionalempleados.get();
            empleado.setNombre(empleadoDetalles.getNombre());
            empleado.setEmail(empleadoDetalles.getEmail());
            empleado.setContrasena(empleadoDetalles.getContrasena());

            empleadosRepository.save(empleado);
            return ResponseEntity.ok(empleado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/empleados/estado/{id}/{estado}")
    public ResponseEntity<empleados> updateEmpleadoEstado(
            @PathVariable(value = "id") Long id,
            @PathVariable(value = "estado") int activo) {

        Optional<empleados> Optionalempleados = empleadosRepository.findById(id);
        if (Optionalempleados.isPresent()) {
            empleados empleado = Optionalempleados.get();
            empleado.setActivo(activo);
            empleadosRepository.save(empleado);
            return ResponseEntity.ok(empleado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
