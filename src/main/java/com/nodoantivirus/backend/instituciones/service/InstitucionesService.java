package com.nodoantivirus.backend.instituciones.service;

import com.nodoantivirus.backend.instituciones.model.Instituciones;
import com.nodoantivirus.backend.instituciones.repository.InstitucionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitucionesService {

    @Autowired
    private InstitucionesRepository institucionesRepository;

    public List<Instituciones> getAllInstituciones() {
        return institucionesRepository.findAll();
    }

    public Optional<Instituciones> getInstitucionById(Long id) {
        return institucionesRepository.findById(id);
    }

    public Instituciones createInstitucion(Instituciones institucion) {
        return institucionesRepository.save(institucion);
    }

    public Instituciones updateInstitucion(Long id, Instituciones institucionDetails) {
        Instituciones institucion = institucionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Institucion no encontrada"));
        institucion.setNombre(institucionDetails.getNombre());
        institucion.setDireccion(institucionDetails.getDireccion());
        return institucionesRepository.save(institucion);
    }

    public void deleteInstitucion(Long id) {
        institucionesRepository.deleteById(id);
    }
}