package com.nodoantivirus.backend.categorias.model;

import com.nodoantivirus.backend.oportunidades.model.Oportunidades;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
@Getter
@Setter
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String categorias;

    @OneToMany(mappedBy = "categorias", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Oportunidades> oportunidades = new ArrayList<>();

    public Categorias() {}

    public Categorias(Long id, String categorias) {
        this.id = id;
        this.categorias = categorias;
    }
}
