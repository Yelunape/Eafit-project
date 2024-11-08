package com.nodoantivirus.backend.usuario_oportunidades.controller;

import com.nodoantivirus.backend.usuario_oportunidades.model.UsuarioOportunidades;
import com.nodoantivirus.backend.usuario_oportunidades.service.UsuarioOportunidadesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarioOportunidades")
public class UsuarioOportunidadesController {

    @Autowired
    private UsuarioOportunidadesService usuarioOportunidadesService;

    //Crear
    @Operation(summary = "Método post para crear usuario oportunidades.", description = "Parámetros requeridos: nombre y descripción, el id se genera automáticamente asi que no es necesario agregarlo.")
    @PostMapping
    public UsuarioOportunidades crearUO(@RequestBody UsuarioOportunidades tipoOportunidad) {
        return usuarioOportunidadesService.crearUO(tipoOportunidad);
    }

    //Obtener todo
    @Operation(summary = "Método para obtener todos usuarios oportunidades", description = "No requiere parámetro.")
    @GetMapping
    public List<UsuarioOportunidades> obtenerTodo() {
        return usuarioOportunidadesService.obtenerUO();
    }

    //Obtener por Id
    @Operation(summary = "Método para obtener usuarios oportunidades por id.", description = "El único parámetro requerido es el del Id.")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioOportunidades> obtenerPorId(@PathVariable Long id) {
        Optional<UsuarioOportunidades> usuarioOportunidades = usuarioOportunidadesService.obtenerUsuarioOportunidadesporByIdId(id);
        return usuarioOportunidades.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Actualizar
    @Operation(summary = "Método para actualizar un tipo de oportunidad", description = "Parámetros que se pueden editar: nombre y descripción, el id se genera automáticamente asi que no es posible modificarlo.")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioOportunidades> actualizarUO(@PathVariable Long id, @RequestBody UsuarioOportunidades uODetails) {
        return ResponseEntity.ok(usuarioOportunidadesService.actualizarUO(id, uODetails));
    }

    //Eliminar
    @Operation(summary = "Método para eliminar tipos de oportunidad por id.", description = "El único parámetro requerido es el del Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUO(@PathVariable Long id) {
        usuarioOportunidadesService.eliminarUsuarioOportunidades(id);
        return ResponseEntity.noContent().build();
    }
}
