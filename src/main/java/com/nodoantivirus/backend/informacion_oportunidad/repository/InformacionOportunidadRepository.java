package com.nodoantivirus.backend.informacion_oportunidad.repository;


import com.nodoantivirus.backend.informacion_oportunidad.model.InformacionOportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacionOportunidadRepository extends JpaRepository<InformacionOportunidad, Long> {
}
