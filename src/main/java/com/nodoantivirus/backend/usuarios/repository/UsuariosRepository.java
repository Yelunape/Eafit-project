package com.nodoantivirus.backend.usuarios.repository;

import com.nodoantivirus.backend.usuarios.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,Long>{ Usuarios findByEmail(String email);
}
