package com.nodoantivirus.backend.informacion_oportunidad.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "informacion_oportunidad")
@Getter
@Setter
public class InformacionOportunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String informacion;

}
