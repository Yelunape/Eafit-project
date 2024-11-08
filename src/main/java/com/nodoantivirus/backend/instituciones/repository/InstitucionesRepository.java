package com.nodoantivirus.backend.instituciones.repository;

import com.nodoantivirus.backend.instituciones.model.Instituciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitucionesRepository extends JpaRepository<Instituciones, Long> {
}
