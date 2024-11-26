package com.nodoantivirus.backend.oportunidades_instituciones.model;

import com.nodoantivirus.backend.instituciones.model.Instituciones;
import com.nodoantivirus.backend.oportunidades.model.Oportunidades;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "oportunidades_instituciones")
public class OportunidadesInstituciones {

    // Getters y Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_institucion", nullable = false)
    private Instituciones idInstitucion;

    @ManyToOne
    @JoinColumn(name = "id_oportunidad", nullable = false)
    private Oportunidades idOportunidad;

    public OportunidadesInstituciones() {
    }

    public OportunidadesInstituciones(Long id, Instituciones idInstitucion, Oportunidades idOportunidad) {
        this.id = id;
        this.idInstitucion = idInstitucion;
        this.idOportunidad = idOportunidad;
    }
}
