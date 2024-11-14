package com.nodoantivirus.backend.estado_oportunidad.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_oportunidad")
public class EstadoOportunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_oportunidad", nullable = false)
    private Long idOportunidad;

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdOportunidad() {
        return idOportunidad;
    }

    public void setIdOportunidad(Long idOportunidad) {
        this.idOportunidad = idOportunidad;
    }
}

