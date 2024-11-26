package com.nodoantivirus.backend.informacion_oportunidad.service;

import com.nodoantivirus.backend.informacion_oportunidad.model.InformacionOportunidad;
import com.nodoantivirus.backend.informacion_oportunidad.repository.InformacionOportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformacionOportunidadService {

    @Autowired
    private InformacionOportunidadRepository informacionOportunidadRepository;

    //Crear
    public InformacionOportunidad crearInfoOpor(InformacionOportunidad informacionOportunidad) {
        return informacionOportunidadRepository.save(informacionOportunidad);
    }

    //obtener_todo
    public List<InformacionOportunidad> obtenerInfoOpor() {
        return informacionOportunidadRepository.findAll();
    }

    //Obtener por id
    public Optional<InformacionOportunidad> obtenerInfoOporById(Long id) {
        return informacionOportunidadRepository.findById(id);
    }

    //Actualizar
    public InformacionOportunidad actualizarInfoOpor(Long id, InformacionOportunidad infoOporDetails) {
        InformacionOportunidad informacionOportunidad = informacionOportunidadRepository.findById(id).orElseThrow();
        informacionOportunidad.setInformacion(infoOporDetails.getInformacion());
        return informacionOportunidadRepository.save(informacionOportunidad);
    }

    //Eliminar
    public void eliminarInfoOpor(Long id) {
        informacionOportunidadRepository.deleteById(id);
    }
}