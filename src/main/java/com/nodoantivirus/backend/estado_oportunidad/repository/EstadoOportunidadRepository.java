package com.nodoantivirus.backend.estado_oportunidad.repository;

import com.nodoantivirus.backend.estado_oportunidad.model.EstadoOportunidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoOportunidadRepository extends JpaRepository<EstadoOportunidad, Long> {
}

