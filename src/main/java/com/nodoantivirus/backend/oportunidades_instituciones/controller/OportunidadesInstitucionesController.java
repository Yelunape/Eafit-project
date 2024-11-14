package com.nodoantivirus.backend.oportunidades_instituciones.controller;

import com.nodoantivirus.backend.oportunidades_instituciones.model.OportunidadesInstituciones;
import com.nodoantivirus.backend.oportunidades_instituciones.service.OportunidadesInstitucionesService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oportunidades_instituciones")
public class OportunidadesInstitucionesController {

    @Autowired
    private OportunidadesInstitucionesService service;

    @PostMapping
    public ResponseEntity<OportunidadesInstituciones> create(@RequestBody OportunidadesInstituciones oportunidadInstitucion) {
        return ResponseEntity.ok(service.save(oportunidadInstitucion));
    }

    @GetMapping
    public ResponseEntity<List<OportunidadesInstituciones>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OportunidadesInstituciones> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OportunidadesInstituciones> update(@PathVariable Long id, @RequestBody OportunidadesInstituciones updated) {
        return ResponseEntity.ok(service.update(id, updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
