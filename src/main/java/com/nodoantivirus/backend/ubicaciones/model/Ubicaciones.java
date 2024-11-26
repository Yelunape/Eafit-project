package com.nodoantivirus.backend.ubicaciones.model;

import com.nodoantivirus.backend.instituciones.model.Instituciones;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ubicaciones")
@Getter
@Setter
public class Ubicaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String direccion;

    @OneToMany(mappedBy = "idUbicaciones", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Instituciones> instituciones = new ArrayList<>();

    // Constructor vacío requerido por JPA
    public Ubicaciones() {
    }

    // Constructor con parámetros
    public Ubicaciones(Long id, String direccion) {
        this.id = id;
        this.direccion = direccion;
    }
}

