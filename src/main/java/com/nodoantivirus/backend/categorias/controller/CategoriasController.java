package com.nodoantivirus.backend.categorias.controller;

import com.nodoantivirus.backend.categorias.model.Categorias;
import com.nodoantivirus.backend.categorias.service.CategoriasService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    //Crear
    @Operation(summary = "Método post para crear una categoria.", description = "Parámetros requeridos: categoria, el id se genera automáticamente asi que no es necesario agregarlo.")
    @PostMapping
    public Categorias crearCateg(@RequestBody Categorias categorias) {
        return categoriasService.crearCateg(categorias);
    }

    //Obtener todo
    @Operation(summary = "Método para obtener todas las categorias", description = "No requiere parámetro.")
    @GetMapping
    public List<Categorias> obtenerTodo() {
        return categoriasService.obtenerCateg();
    }

    //Obtener por Id
    @Operation(summary = "Método para obtener categoria por id.", description = "El único parámetro requerido es el del Id.")
    @GetMapping("/{id}")
    public ResponseEntity<Categorias> obtenerPorId(@PathVariable Long id) {
        Optional<Categorias> categorias = categoriasService.obtenerCategById(id);
        return categorias.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Actualizar
    @Operation(summary = "Método para actualizar una categoria", description = "Parámetros que se pueden editar: categoria, el id se genera automáticamente asi que no es posible modificarlo.")
    @PutMapping("/{id}")
    public ResponseEntity<Categorias> actualizarCateg(@PathVariable Long id, @RequestBody Categorias categDetails) {
        return ResponseEntity.ok(categoriasService.actualizarCateg(id, categDetails));
    }

    //Eliminar
    @Operation(summary = "Método para eliminar categorias por id.", description = "El único parámetro requerido es el del Id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCateg(@PathVariable Long id) {
        categoriasService.eliminarCateg(id);
        return ResponseEntity.noContent().build();
    }
}
