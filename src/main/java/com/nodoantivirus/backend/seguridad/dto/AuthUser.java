package com.nodoantivirus.backend.seguridad.dto;

import lombok.Data;

@Data
public class AuthUser {

    private String correo;

    private String contrasena;
}
