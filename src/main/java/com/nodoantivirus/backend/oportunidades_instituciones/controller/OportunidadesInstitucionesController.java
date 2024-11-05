package com.nodoantivirus.backend.oportunidades_instituciones.controller;

import com.nodoantivirus.backend.oportunidades_instituciones.model.OportunidadesInstituciones;
import com.nodoantivirus.backend.oportunidades_instituciones.service.OportunidadesInstitucionesService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oportunidades_instituciones")
public class OportunidadesInstitucionesController {

    @Autowired
    private OportunidadesInstitucionesService service;

    @PostMapping
    public ResponseEntity<OportunidadesInstituciones> createOportunidadesInstituciones(@RequestBody OportunidadesInstituciones oportunidadesInstituciones) {
        return new ResponseEntity<>(service.createOportunidadesInstituciones(oportunidadesInstituciones), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OportunidadesInstituciones>> getAllOportunidadesInstituciones() {
        return new ResponseEntity<>(service.getAllOportunidadesInstituciones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OportunidadesInstituciones> getOportunidadesInstitucionesById(@PathVariable Long id) {
        return service.getOportunidadesInstitucionesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OportunidadesInstituciones> updateOportunidadesInstituciones(@PathVariable Long id, @RequestBody OportunidadesInstituciones updatedOportunidadesInstituciones) {
        return new ResponseEntity<>(service.updateOportunidadesInstituciones(id, updatedOportunidadesInstituciones), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOportunidadesInstituciones(@PathVariable Long id) {
        service.deleteOportunidadesInstituciones(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
