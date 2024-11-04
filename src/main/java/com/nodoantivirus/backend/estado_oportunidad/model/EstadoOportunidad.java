package com.nodoantivirus.backend.estado_oportunidad.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estado_oportunidad")
public class EstadoOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_oportunidad", nullable = false)
    private Oportunidad oportunidad;

    @Column(name = "id_oportunidad", nullable = false)
    private Long idOportunidad;

    //Getters y setters

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