package com.nodoantivirus.backend.roles.model;

import com.nodoantivirus.backend.usuarios.model.Usuarios;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Roles")
@Getter
@Setter
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String rol;

    @OneToMany(mappedBy = "idRole", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Usuarios> usuarios = new ArrayList<>();

    // Constructor vacío
    public Roles() {
    }

    // Constructor con argumentos
    public Roles(Long id, String rol) {
        this.id = id;
        this.rol = rol;
    }

}