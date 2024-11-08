package com.nodoantivirus.backend.oportunidades.controller;

import com.nodoantivirus.backend.oportunidades.model.Oportunidades;
import com.nodoantivirus.backend.oportunidades.service.OportunidadesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/oportunidades")
public class OportunidadesController {

    @Autowired
    private OportunidadesService oportunidadesService;

    //Crear
    @Operation(summary = "Método post para crear oportunidades.", description = "Parámetros requeridos: nombre y descripción, el id se genera automáticamente asi que no es necesario agregarlo.")
    @PostMapping
    public Oportunidades crearOportunidades(@RequestBody Oportunidades oportunidades) {
        return oportunidadesService.crearOportunidades(oportunidades);
    }

    //Obtener todo
    @Operation(summary = "Método para obtener todos las portunidades", description = "No requiere parámetro.")
    @GetMapping
    public List<Oportunidades> obtenerTodo() {
        return oportunidadesService.obtenerOportunidades();
    }

    //Obtener por Id
    @Operation(summary = "Método para obtener oportunidades por id.", description = "El único parámetro requerido es el del Id.")
    @GetMapping("/{id}")
    public ResponseEntity<Oportunidades> obtenerPorId(@PathVariable Long id) {
        Optional<Oportunidades> oportunidades = oportunidadesService.obtenerOportunidadesporById(id);
        return oportunidades.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Actualizar
    @Operation(summary = "Método para actualizar oportunidades", description = "Parámetros que se pueden editar: nombre y descripción, el id se genera automáticamente asi que no es posible modificarlo.")
    @PutMapping("/{id}")
    public ResponseEntity<Oportunidades> actualizarOportunidades(@PathVariable Long id, @RequestBody Oportunidades oportunidadesDeatails) {
        return ResponseEntity.ok(oportunidadesService.actualizarOportunidades(id, oportunidadesDeatails));
    }

    //Eliminar
    @Operation(summary = "Método para eliminar oportunidades por id.", description = "El único parámetro requerido es el del Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOportunidades(@PathVariable Long id) {
        oportunidadesService.eliminarOportunidades(id);
        return ResponseEntity.noContent().build();
    }
}
