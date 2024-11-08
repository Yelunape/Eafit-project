package com.nodoantivirus.backend.tipo_oportunidad.repository;

import com.nodoantivirus.backend.tipo_oportunidad.model.TipoOportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoOportunidadRepository extends JpaRepository<TipoOportunidad, Long> {
}
