package com.nodoantivirus.backend.informacion_oportunidad.model;

import com.nodoantivirus.backend.oportunidades.model.Oportunidades;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "informacion_oportunidad")
@Getter
@Setter
public class InformacionOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String informacion;

    @OneToMany(mappedBy = "informacionOportunidadId", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Oportunidades> oportunidades = new ArrayList<>();

    // Constructores
    public InformacionOportunidad() {
    }

    public InformacionOportunidad(Long id, String info) {
        this.id = id;
        this.informacion = informacion;
    }

}
