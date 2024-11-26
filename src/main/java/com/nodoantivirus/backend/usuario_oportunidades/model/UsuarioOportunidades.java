package com.nodoantivirus.backend.usuario_oportunidades.model;

import com.nodoantivirus.backend.oportunidades.model.Oportunidades;
import com.nodoantivirus.backend.usuarios.model.Usuarios;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario_oportinidades")
@Getter
@Setter
public class UsuarioOportunidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 255)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_oportunidades", nullable = false)
    private Oportunidades idOportunidades;

    // Constructor vacío requerido por JPA
    public UsuarioOportunidades() {
    }

    // Constructor personalizado para facilitar la creación de objetos
    public UsuarioOportunidades(String nombre, String descripcion, Usuarios idUsuario, Oportunidades idOportunidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
        this.idOportunidades = idOportunidades;
    }
}
