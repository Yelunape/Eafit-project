package com.nodoantivirus.backend.ubicaciones.controller;

import com.nodoantivirus.backend.ubicaciones.model.Ubicaciones;
import com.nodoantivirus.backend.ubicaciones.service.UbicacionesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionesController {

    @Autowired
    private UbicacionesService ubicacionesService;

    //Crear
    @Operation(summary = "Método post para crear ubicaciones.", description = "Parámetros requeridos: región, el id se genera automáticamente asi que no es necesario agregarlo.")
    @PostMapping
    public Ubicaciones crearubicaciones(@RequestBody Ubicaciones ubicaciones) {
        return ubicacionesService.crearUbicaciones(ubicaciones);
    }

    //Obtener todo
    @Operation(summary = "Método para obtener todos los tipos de ubicaciones", description = "No requiere parámetro.")
    @GetMapping
    public List<Ubicaciones> obtenerTodo() {
        return ubicacionesService.obtenerUbicaciones();
    }

    //Obtener por Id
    @Operation(summary = "Método para obtener ubicaciones por id.", description = "El único parámetro requerido es el del Id.")
    @GetMapping("/{id}")
    public ResponseEntity<Ubicaciones> obtenerPorId(@PathVariable Long id) {
        Optional<Ubicaciones> ubicaciones = ubicacionesService.obtenerUbicacionesById(id);
        return ubicaciones.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Actualizar
    @Operation(summary = "Método para actualizar ubicaciones", description = "Parámetros que se pueden editar: región, el id se genera automáticamente asi que no es posible modificarlo.")
    @PutMapping("/{id}")
    public ResponseEntity<Ubicaciones> actualizarUbicaciones(@PathVariable Long id, @RequestBody Ubicaciones ubicacionesDetails) {
        return ResponseEntity.ok(ubicacionesService.actualizarUbicaciones(id, ubicacionesDetails));
    }

    //Eliminar
    @Operation(summary = "Método para eliminar ubicaciones.", description = "El único parámetro requerido es el del Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUbicaciones(@PathVariable Long id) {
        ubicacionesService.eliminarUbicaciones(id);
        return ResponseEntity.noContent().build();
    }

}
