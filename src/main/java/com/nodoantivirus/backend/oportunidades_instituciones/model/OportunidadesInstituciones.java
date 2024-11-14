package com.nodoantivirus.backend.oportunidades_instituciones.model;

import com.nodoantivirus.backend.instituciones.model.Instituciones;
import com.nodoantivirus.backend.oportunidades.model.Oportunidades;
import jakarta.persistence.*;

@Entity
@Table(name = "oportunidades_instituciones")
public class OportunidadesInstituciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_institucion", nullable = false)
    private Instituciones institucion;

    @ManyToOne
    @JoinColumn(name = "id_oportunidad", nullable = false)
    private Oportunidades oportunidad;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instituciones getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Instituciones institucion) {
        this.institucion = institucion;
    }

    public Oportunidades getOportunidad() {
        return oportunidad;
    }

    public void setOportunidad(Oportunidades oportunidad) {
        this.oportunidad = oportunidad;
    }
}
