package com.nodoantivirus.backend.tipo_oportunidad.service;

import com.nodoantivirus.backend.tipo_oportunidad.model.TipoOportunidad;
import com.nodoantivirus.backend.tipo_oportunidad.repository.TipoOportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoOportunidadService {

    @Autowired
    private TipoOportunidadRepository tipoOportunidadRepository;

    //Crear
    public TipoOportunidad crearTipoOpor(TipoOportunidad tipoOportunidad) {
        return tipoOportunidadRepository.save(tipoOportunidad);
    }

    //obtener_todo
    public List<TipoOportunidad> obtenerTiposOpor() {
        return tipoOportunidadRepository.findAll();
    }

    //Obtener por id
    public Optional<TipoOportunidad> obtenerTipoOporById(Long id) {
        return tipoOportunidadRepository.findById(id);
    }

    //Actualizar
    public TipoOportunidad actualizarTipoOpor(Long id, TipoOportunidad tipoOporDetails) {
        TipoOportunidad tipoOportunidad = tipoOportunidadRepository.findById(id).orElseThrow();
        tipoOportunidad.setNombre(tipoOporDetails.getNombre());
        tipoOportunidad.setDescripcion(tipoOporDetails.getDescripcion());
        return tipoOportunidadRepository.save(tipoOportunidad);
    }

    //Eliminar
    public void eliminarTipoOpor(Long id) {
        tipoOportunidadRepository.deleteById(id);
    }
}
