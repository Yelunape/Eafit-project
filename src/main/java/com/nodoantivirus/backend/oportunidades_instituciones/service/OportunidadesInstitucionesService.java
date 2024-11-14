package com.nodoantivirus.backend.oportunidades_instituciones.service;

import com.nodoantivirus.backend.oportunidades_instituciones.model.OportunidadesInstituciones;
import com.nodoantivirus.backend.oportunidades_instituciones.repository.OportunidadesInstitucionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OportunidadesInstitucionesService {

    @Autowired
    private OportunidadesInstitucionesRepository repository;

    public OportunidadesInstituciones save(OportunidadesInstituciones oportunidadInstitucion) {
        return repository.save(oportunidadInstitucion);
    }

    public List<OportunidadesInstituciones> getAll() {
        return repository.findAll();
    }

    public Optional<OportunidadesInstituciones> getById(Long id) {
        return repository.findById(id);
    }

    public OportunidadesInstituciones update(Long id, OportunidadesInstituciones updated) {
        OportunidadesInstituciones oportunidadInstitucion = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("OportunidadInstitucion not found"));
        oportunidadInstitucion.setInstitucion(updated.getInstitucion());
        oportunidadInstitucion.setOportunidad(updated.getOportunidad());
        return repository.save(oportunidadInstitucion);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
