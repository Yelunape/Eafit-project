package com.nodoantivirus.backend.ubicaciones.service;

import com.nodoantivirus.backend.ubicaciones.model.Ubicaciones;
import com.nodoantivirus.backend.ubicaciones.repository.UbicacionesRespository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionesService {
    @Autowired
    private UbicacionesRespository ubicacionesRepository;

    //Crear
    public Ubicaciones crearUbicaciones(Ubicaciones ubicaciones) {
        return ubicacionesRepository.save(ubicaciones);
    }

    //obtener todo
    public List<Ubicaciones> obtenerUbicaciones() {
        return ubicacionesRepository.findAll();
    }

    //Obtener por id
    public Optional<Ubicaciones> obtenerUbicacionesById(Long id) {
        return ubicacionesRepository.findById(id);
    }

    //Actualizar
    public Ubicaciones actualizarUbicaciones(Long id, Ubicaciones ubicacionesDetails) {
        Ubicaciones ubicaciones = ubicacionesRepository.findById(id).orElseThrow();
        ubicaciones.setRegion(ubicacionesDetails.getRegion());
        return ubicacionesRepository.save(ubicaciones);
    }

    //Eliminar
    public void eliminarUbicaciones(Long id) {
        ubicacionesRepository.deleteById(id);
    }
}
