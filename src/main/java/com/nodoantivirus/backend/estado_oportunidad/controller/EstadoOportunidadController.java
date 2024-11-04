package com.nodoantivirus.backend.estado_oportunidad.controller;

import com.nodoantivirus.backend.estado_oportunidad.model.EstadoOportunidad;
import com.nodoantivirus.backend.estado_oportunidad.service.EstadoOportunidadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado_oportunidad")
public class EstadoOportunidadController {
    @Autowired
    private EstadoOportunidadService service;

    @Operation(summary = "Crear un nuevo estado_oportunidad")
    @PostMapping
    public ResponseEntity<EstadoOportunidad> createEstadoOportunidad(@RequestBody EstadoOportunidad estadoOportunidad) {
        return ResponseEntity.ok(service.createEstadoOportunidad(estadoOportunidad));
    }

    @Operation(summary = "Obtener todos los estado_oportunidad")
    @GetMapping
    public ResponseEntity<List<EstadoOportunidad>> getAllEstadoOportunidad() {
        return ResponseEntity.ok(service.getAllEstadoOportunidad());
    }

    @Operation(summary = "Obtener un estado_oportunidad por ID")
    @GetMapping("/{id}")
    public ResponseEntity<EstadoOportunidad> getEstadoOportunidadById(@PathVariable Long id) {
        return service.getEstadoOportunidadById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Actualizar un estado_oportunidad")
    @PutMapping("/{id}")
    public ResponseEntity<EstadoOportunidad> updateEstadoOportunidad(
            @PathVariable Long id, @RequestBody EstadoOportunidad estadoOportunidad) {
        return ResponseEntity.ok(service.updateEstadoOportunidad(id, estadoOportunidad));
    }

    @Operation(summary = "Eliminar un estado_oportunidad")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoOportunidad(@PathVariable Long id) {
        service.deleteEstadoOportunidad(id);
        return ResponseEntity.noContent().build();
    }
}