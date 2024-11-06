package com.nodoantivirus.backend.informacion_oportunidad.controller;

import com.nodoantivirus.backend.informacion_oportunidad.model.InformacionOportunidad;
import com.nodoantivirus.backend.informacion_oportunidad.service.InformacionOportunidadService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/informacionoportunidad")

public class InformacionOportunidadController {
    @Autowired
    private InformacionOportunidadService informacionOportunidadService;

    //Crear
    @Operation(summary = "Método post para crear información de oportunidad.", description = "Parámetros requeridos: información, el id se genera automáticamente asi que no es necesario agregarlo.")
    @PostMapping
    public InformacionOportunidad crearInfoOpor(@RequestBody InformacionOportunidad informacionOportunidad) {
        return informacionOportunidadService.crearInfoOpor(informacionOportunidad);
    }

    //Obtener todo
    @Operation(summary = "Método para obtener toda la información de oportunidad", description = "No requiere parámetro.")
    @GetMapping
    public List<InformacionOportunidad> obtenerTodo() {
        return informacionOportunidadService.obtenerInfoOpor();
    }

    //Obtener por Id
    @Operation(summary = "Método para obtener información de oportunidad por id.", description = "El único parámetro requerido es el del Id.")
    @GetMapping("/{id}")
    public ResponseEntity<InformacionOportunidad> obtenerPorId(@PathVariable Long id) {
        Optional<InformacionOportunidad> informacionOportunidad = informacionOportunidadService.obtenerInfoOporById(id);
        return informacionOportunidad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Actualizar
    @Operation(summary = "Método para actualizar información de oportunidad", description = "Parámetros que se pueden editar: información, el id se genera automáticamente asi que no es posible modificarlo.")
    @PutMapping("/{id}")
    public ResponseEntity<InformacionOportunidad> actualizarInfoOpor(@PathVariable Long id, @RequestBody InformacionOportunidad informacionOportunidad) {
        return ResponseEntity.ok(informacionOportunidadService.actualizarInfoOpor(id, informacionOportunidad));
    }

    //Eliminar
    @Operation(summary = "Método para eliminar información de oportunidad por id.", description = "El único parámetro requerido es el del Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInfoOpor(@PathVariable Long id) {
        informacionOportunidadService.eliminarInfoOpor(id);
        return ResponseEntity.noContent().build();
    }
}
