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
    private EstadoOportunidadRepository repository;

    public EstadoOportunidad createEstadoOportunidad(EstadoOportunidad estadoOportunidad) {
        return repository.save(estadoOportunidad);
    }

    public List<EstadoOportunidad> getAllEstadoOportunidad() {
        return repository.findAll();
    }

    public Optional<EstadoOportunidad> getEstadoOportunidadById(Long id) {
        return repository.findById(id);
    }

    public EstadoOportunidad updateEstadoOportunidad(Long id, EstadoOportunidad estadoOportunidad) {
        estadoOportunidad.setId(id);
        return repository.save(estadoOportunidad);
    }

    public void deleteEstadoOportunidad(Long id) {
        repository.deleteById(id);
    }
}
