package com.nodoantivirus.backend.instituciones.controller;

import com.nodoantivirus.backend.instituciones.model.Instituciones;
import com.nodoantivirus.backend.instituciones.service.InstitucionesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instituciones")
public class InstitucionesController {

    @Autowired
    private InstitucionesService institucionesService;

    @Operation(summary = "Obtener todas las instituciones")
    @GetMapping
    public List<Instituciones> getAllInstituciones() {
        return institucionesService.getAllInstituciones();
    }

    @Operation(summary = "Obtener una institución por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Instituciones> getInstitucionById(@PathVariable Long id) {
        return institucionesService.getInstitucionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear una nueva institución")
    @PostMapping
    public Instituciones createInstitucion(@RequestBody Instituciones institucion) {
        return institucionesService.createInstitucion(institucion);
    }

    @Operation(summary = "Actualizar una institución existente")
    @PutMapping("/{id}")
    public ResponseEntity<Instituciones> updateInstitucion(@PathVariable Long id, @RequestBody Instituciones institucionDetails) {
        return ResponseEntity.ok(institucionesService.updateInstitucion(id, institucionDetails));
    }

    @Operation(summary = "Eliminar una institución")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitucion(@PathVariable Long id) {
        institucionesService.deleteInstitucion(id);
        return ResponseEntity.noContent().build();
    }
}
