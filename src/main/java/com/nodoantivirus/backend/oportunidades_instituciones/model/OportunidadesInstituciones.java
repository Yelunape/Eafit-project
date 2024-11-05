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
    @JoinColumn(name = "id_instituciones", nullable = false)
    private Instituciones instituciones;

    @ManyToOne
    @JoinColumn(name = "id_oportunidades", nullable = false)
    private Oportunidades oportunidades;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instituciones getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(Instituciones instituciones) {
        this.instituciones = instituciones;
    }

    public Oportunidades getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(Oportunidades oportunidades) {
        this.oportunidades = oportunidades;
    }
}
