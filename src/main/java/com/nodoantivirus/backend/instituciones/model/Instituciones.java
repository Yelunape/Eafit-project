package com.nodoantivirus.backend.instituciones.model;

import com.nodoantivirus.backend.oportunidades_instituciones.model.OportunidadesInstituciones;
import com.nodoantivirus.backend.ubicaciones.model.Ubicaciones;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Instituciones")
public class Instituciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_region", nullable = false)
    private Ubicaciones idUbicaciones;

    @OneToMany(mappedBy = "institucionId", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<OportunidadesInstituciones> oportunidadesInstituciones = new ArrayList<>();

    // Constructores
    public Instituciones() {
    }

    public Instituciones(Long id, String nombre, String direccion, Ubicaciones idUbicaciones) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.idUbicaciones = idUbicaciones;
    }
}
