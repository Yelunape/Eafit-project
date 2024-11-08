package com.nodoantivirus.backend.usuario_oportunidades.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario_oportinidades")
@Getter @Setter
public class UsuarioOportunidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

}
