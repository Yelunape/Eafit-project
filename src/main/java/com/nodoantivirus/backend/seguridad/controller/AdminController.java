package com.nodoantivirus.backend.seguridad.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @GetMapping("/configuracion")
    public ResponseEntity<String> obtenerConfiguracion() {
        return ResponseEntity.ok("Configuración de administrador.");
    }
}