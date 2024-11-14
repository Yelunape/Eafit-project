package com.nodoantivirus.backend.usuarios.model;

import java.util.HashSet;
import java.util.Set;

import com.nodoantivirus.backend.roles.model.Roles;

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

    private String apellido;

    private String nacimiento;

    private String correo;
    private String contrasena;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_roles",
                joinColumns = @JoinColumn(name = "usuarios_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();
}

