package com.nodoantivirus.backend.oportunidades_instituciones.repository;

import com.nodoantivirus.backend.oportunidades_instituciones.model.OportunidadesInstituciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OportunidadesInstitucionesRepository extends JpaRepository<OportunidadesInstituciones, Long> {
}
