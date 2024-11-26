package com.nodoantivirus.backend.tipo_oportunidad.model;

import com.nodoantivirus.backend.oportunidades.model.Oportunidades;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_oportunidad")
@Getter
@Setter
public class TipoOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String descripcion;

    @OneToMany(mappedBy = "idTipoOportunidad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Oportunidades> oportunidades = new ArrayList<>();

    // Constructor vacío requerido por JPA
    public TipoOportunidad() {
    }

    // Constructor con parámetros
    public TipoOportunidad(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
