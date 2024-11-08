package com.nodoantivirus.backend.ubicaciones.repository;

import com.nodoantivirus.backend.ubicaciones.model.Ubicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionesRespository extends JpaRepository<Ubicaciones, Long> {
}
