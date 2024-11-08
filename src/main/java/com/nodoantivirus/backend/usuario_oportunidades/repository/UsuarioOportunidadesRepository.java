package com.nodoantivirus.backend.usuario_oportunidades.repository;

import com.nodoantivirus.backend.usuario_oportunidades.model.UsuarioOportunidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioOportunidadesRepository extends JpaRepository<UsuarioOportunidades, Long> {
}
