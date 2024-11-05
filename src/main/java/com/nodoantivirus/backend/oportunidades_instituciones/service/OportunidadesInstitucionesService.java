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

    public OportunidadesInstituciones createOportunidadesInstituciones(OportunidadesInstituciones oportunidadesInstituciones) {
        return repository.save(oportunidadesInstituciones);
    }

    public List<OportunidadesInstituciones> getAllOportunidadesInstituciones() {
        return repository.findAll();
    }

    public Optional<OportunidadesInstituciones> getOportunidadesInstitucionesById(Long id) {
        return repository.findById(id);
    }

    public OportunidadesInstituciones updateOportunidadesInstituciones(Long id, OportunidadesInstituciones updatedOportunidadesInstituciones) {
        OportunidadesInstituciones existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("OportunidadesInstituciones no encontrada"));
        existing.setOportunidades(updatedOportunidadesInstituciones.getOportunidades());
        existing.setInstituciones(updatedOportunidadesInstituciones.getInstituciones());
        return repository.save(existing);
    }

    public void deleteOportunidadesInstituciones(Long id) {
        repository.deleteById(id);
    }
}
