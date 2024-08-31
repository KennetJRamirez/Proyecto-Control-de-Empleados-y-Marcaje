package com.umg.control_empleados.controllers;

import com.umg.control_empleados.models.empleados;
import com.umg.control_empleados.repository.empleadosRepository;
import com.umg.control_empleados.models.validationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class empleadosController {

    @Autowired
    private empleadosRepository empleadosRepository;

    private validationRequest validationRequest;


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

    @PostMapping("/login")
    public ResponseEntity<String> validarEmpleado(@RequestBody validationRequest request) {
        Optional<empleados> empleado = empleadosRepository.findByEmail(request.getEmail());
        Map<String, String> response = new HashMap<>();
        if (empleado.isEmpty()) {
            response.put("mensaje", "Empleado no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response.toString());
        }

        if (!empleado.get().getContrasena().equals(request.getContrasena())) {
            response.put("mensaje", "Contraseña incorrecta");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response.toString());
        }

        response.put("mensaje", "Validación exitosa");
        return ResponseEntity.ok(response.toString());
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
