package com.nodoantivirus.backend.usuarios.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nodoantivirus.backend.roles.model.Roles;
import com.nodoantivirus.backend.usuario_oportunidades.model.UsuarioOportunidades;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "id_roles", nullable = false)
    private Roles idRole;

    @OneToMany(mappedBy = "id_usuario", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<UsuarioOportunidades> usuarioOportunidades;

    public Usuarios() {}

    public Usuarios(String nombre, String apellido, String email, String password, LocalDate birthday, Roles idRole) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.idRole = idRole;
    }
}