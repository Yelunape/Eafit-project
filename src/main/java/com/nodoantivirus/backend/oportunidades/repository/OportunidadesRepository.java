package com.nodoantivirus.backend.oportunidades.repository;

import com.nodoantivirus.backend.oportunidades.model.Oportunidades;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OportunidadesRepository extends JpaRepository<Oportunidades, Long> {
}
