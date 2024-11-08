package com.nodoantivirus.backend.oportunidades.service;

import com.nodoantivirus.backend.oportunidades.model.Oportunidades;
import com.nodoantivirus.backend.oportunidades.repository.OportunidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OportunidadesService {
    @Autowired
    private OportunidadesRepository oportunidadesRepository;

    //Crear
    public Oportunidades crearOportunidades(Oportunidades oportunidades) {
        return oportunidadesRepository.save(oportunidades);
    }

    //obtener todo
    public List<Oportunidades> obtenerOportunidades() {
        return oportunidadesRepository.findAll();
    }

    //Obtener por id
    public Optional<Oportunidades> obtenerOportunidadesporById(Long id) {
        return oportunidadesRepository.findById(id);
    }

    //Actualizar
    public Oportunidades actualizarOportunidades(Long id, Oportunidades oportunidadesDetails) {
        Oportunidades oportunidades = oportunidadesRepository.findById(id).orElseThrow();
        oportunidades.setNombre(oportunidadesDetails.getNombre());
        oportunidades.setDescripcion(oportunidadesDetails.getDescripcion());
        return oportunidadesRepository.save(oportunidades);
    }

    //Eliminar
    public void eliminarOportunidades(Long id) {
        oportunidadesRepository.deleteById(id);
    }
}
