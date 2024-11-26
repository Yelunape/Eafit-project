package com.nodoantivirus.backend.oportunidades.model;

import com.nodoantivirus.backend.categorias.model.Categorias;
import com.nodoantivirus.backend.estado_oportunidad.model.EstadoOportunidad;
import com.nodoantivirus.backend.informacion_oportunidad.model.InformacionOportunidad;
import com.nodoantivirus.backend.oportunidades_instituciones.model.OportunidadesInstituciones;
import com.nodoantivirus.backend.tipo_oportunidad.model.TipoOportunidad;
import com.nodoantivirus.backend.usuario_oportunidades.model.UsuarioOportunidades;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tipo_oportunidad")

public class Oportunidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nombre", nullable = false)
    private Oportunidades nombre;

    @ManyToOne
    @JoinColumn(name = "idEstado", nullable = false)
    private EstadoOportunidad idEstado;

    @ManyToOne
    @JoinColumn(name = "idInformacion", nullable = false)
    private InformacionOportunidad informacionOportunidadId;

    @ManyToOne
    @JoinColumn(name = "idTipoOportunidad", nullable = false)
    private TipoOportunidad tipoOportunidadId;

    @ManyToOne
    @JoinColumn(name = "categoriasid", nullable = false)
    private Categorias categorias;

    @OneToMany(mappedBy = "oportunidadesId", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<OportunidadesInstituciones> oportunidadesInstituciones;

    @OneToMany(mappedBy = "oportunidadesId", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<UsuarioOportunidades> usuariosOportunidades;

    public Oportunidades() {
    }

    public Oportunidades(Long id, EstadoOportunidad idEstado, InformacionOportunidad informacionOportunidadId , TipoOportunidad tipoOportunidadId, Categorias categorias, Oportunidades nombre) {
        this.id = id;
        this.nombre = nombre;
        this.idEstado = idEstado;
        this.informacionOportunidadId = informacionOportunidadId;
        this.tipoOportunidadId = tipoOportunidadId;
        this.categorias = categorias;
    }
}