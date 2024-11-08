package com.nodoantivirus.backend.tipo_oportunidad.controller;

import com.nodoantivirus.backend.tipo_oportunidad.model.TipoOportunidad;
import com.nodoantivirus.backend.tipo_oportunidad.service.TipoOportunidadService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipoOportunidad")
public class TipoOportunidadController {

    @Autowired
    private TipoOportunidadService tipoOportunidadService;

    //Crear
    @Operation(summary = "Método post para crear un tipo de oportunidad.", description = "Parámetros requeridos: nombre y descripción, el id se genera automáticamente asi que no es necesario agregarlo.")
    @PostMapping
    public TipoOportunidad crearTO(@RequestBody TipoOportunidad tipoOportunidad) {
        return tipoOportunidadService.crearTipoOpor(tipoOportunidad);
    }

    //Obtener todo
    @Operation(summary = "Método para obtener todos los tipos de oportunidad", description = "No requiere parámetro.")
    @GetMapping
    public List<TipoOportunidad> obtenerTodo() {
        return tipoOportunidadService.obtenerTiposOpor();
    }

    //Obtener por Id
    @Operation(summary = "Método para obtener tipos de oportunidad por id.", description = "El único parámetro requerido es el del Id.")
    @GetMapping("/{id}")
    public ResponseEntity<TipoOportunidad> obtenerPorId(@PathVariable Long id) {
        Optional<TipoOportunidad> tipoOportunidad = tipoOportunidadService.obtenerTipoOporById(id);
        return tipoOportunidad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Actualizar
    @Operation(summary = "Método para actualizar un tipo de oportunidad", description = "Parámetros que se pueden editar: nombre y descripción, el id se genera automáticamente asi que no es posible modificarlo.")
    @PutMapping("/{id}")
    public ResponseEntity<TipoOportunidad> actualizarTO(@PathVariable Long id, @RequestBody TipoOportunidad tipoOporDetails) {
        return ResponseEntity.ok(tipoOportunidadService.actualizarTipoOpor(id, tipoOporDetails));
    }

    //Eliminar
    @Operation(summary = "Método para eliminar tipos de oportunidad por id.", description = "El único parámetro requerido es el del Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTO(@PathVariable Long id) {
        tipoOportunidadService.eliminarTipoOpor(id);
        return ResponseEntity.noContent().build();
    }
}
