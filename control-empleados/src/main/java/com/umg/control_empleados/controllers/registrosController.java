package com.umg.control_empleados.controllers;



import com.umg.control_empleados.models.empleados;
import com.umg.control_empleados.models.registros_marcaje;
import com.umg.control_empleados.repository.registrosRepository;
import com.umg.control_empleados.repository.empleadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class registrosController {

    @Autowired
    private registrosRepository registrosRepository;
    @Autowired
    private empleadosRepository empleadosRepository;

    //registrar marcaje
    @PostMapping("/registros/{id}/marcaje/{tipo}")
    public ResponseEntity<Long> registrarMarcaje(@PathVariable(value = "id") Long empleadoID, @PathVariable(value="tipo") registros_marcaje.TipoMarcaje tipo) {
        Optional<empleados> empleados = empleadosRepository.findById(empleadoID);
        if (empleados.isPresent()) {
                registros_marcaje nuevoMarcaje = new registros_marcaje();
                nuevoMarcaje.setEmpleado(empleados.get());
                nuevoMarcaje.setFecha(LocalDate.now());
                nuevoMarcaje.setHora(LocalDateTime.now());
                nuevoMarcaje.setTipo(tipo);
                registrosRepository.save(nuevoMarcaje);
                return ResponseEntity.ok(nuevoMarcaje.getId());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
