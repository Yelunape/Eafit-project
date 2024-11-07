package com.nodoantivirus.backend.usuarios.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Sea autoincrementable
    private Long id;

    private String nombre;
}

