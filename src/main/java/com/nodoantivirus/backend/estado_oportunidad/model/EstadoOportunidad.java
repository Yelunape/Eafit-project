package com.nodoantivirus.backend.estado_oportunidad.model;

import com.nodoantivirus.backend.oportunidades.model.Oportunidades;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "estado_oportunidad")
public class EstadoOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String estado;

    @OneToMany(mappedBy = "idEstado", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Oportunidades> oportunidades = new ArrayList<>();

    // Constructores
    public EstadoOportunidad() {
    }

    public EstadoOportunidad(Long id, String estado) {
        this.id = id;
        this.estado = estado;
    }

}