package com.nodoantivirus.backend.estado_oportunidad.model;

import com.nodoantivirus.backend.oportunidades.model.Oportunidades;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado_oportunidad")
public class EstadoOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_oportunidad", nullable = false)
    private Oportunidades oportunidad;

    @Column(name = "id_oportunidad", nullable = false)
    private Long idOportunidad;

    //Getters y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Oportunidades getOportunidad() {
        return oportunidad;
    }

    public void setOportunidad(Oportunidades oportunidad) {
        this.oportunidad = oportunidad;
    }

    public Long getIdOportunidad() {
        return idOportunidad;
    }

    public void setIdOportunidad(Long idOportunidad) {
        this.idOportunidad = idOportunidad;
    }
}