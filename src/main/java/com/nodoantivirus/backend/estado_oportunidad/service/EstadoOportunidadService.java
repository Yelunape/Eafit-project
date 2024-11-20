package com.nodoantivirus.backend.estado_oportunidad.service;

import com.nodoantivirus.backend.estado_oportunidad.model.EstadoOportunidad;
import com.nodoantivirus.backend.estado_oportunidad.repository.EstadoOportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoOportunidadService {

    @Autowired
    private EstadoOportunidadRepository estadoOportunidadRepository;

    public EstadoOportunidad createEstadoOportunidad(EstadoOportunidad estadoOportunidad) {
        return estadoOportunidadRepository.save(estadoOportunidad);
    }

    public List<EstadoOportunidad> getAllEstadoOportunidad() {
        return estadoOportunidadRepository.findAll();
    }

    public Optional<EstadoOportunidad> getEstadoOportunidadById(Long id) {
        return estadoOportunidadRepository.findById(id);
    }

    public EstadoOportunidad updateEstadoOportunidad(Long id, EstadoOportunidad estadoOportunidad) {
        estadoOportunidad.setId(id);
        return estadoOportunidadRepository.save(estadoOportunidad);
    }

    public void deleteEstadoOportunidad(Long id) {
        estadoOportunidadRepository.deleteById(id);
    }
}

