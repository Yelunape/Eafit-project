package com.nodoantivirus.backend.usuario_oportunidades.service;

import com.jayway.jsonpath.internal.path.ArraySliceOperation;
import com.nodoantivirus.backend.usuario_oportunidades.model.UsuarioOportunidades;
import com.nodoantivirus.backend.usuario_oportunidades.repository.UsuarioOportunidadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioOportunidadesService {

    @Autowired
    private UsuarioOportunidadesRepository usuarioOportunidadesRepository;

    //Crear
        public UsuarioOportunidades crearUO(@RequestBody UsuarioOportunidades usuarioOportunidades) {
        return usuarioOportunidadesRepository.save(usuarioOportunidades);
    }

    //Obtener_todo
    public List<UsuarioOportunidades> obtenerUO() {
        return usuarioOportunidadesRepository.findAll();
    }

    //Obtener por Id
    public Optional<UsuarioOportunidades> obtenerUsuarioOportunidadesporByIdId(Long id) {
        return usuarioOportunidadesRepository.findById(id);
    }

    //Actualizar
    public UsuarioOportunidades actualizarUO(Long id, UsuarioOportunidades usuarioOportunidadesDetails) {
        UsuarioOportunidades usuarioOportunidades = usuarioOportunidadesRepository.findById(id).orElseThrow();
        usuarioOportunidades.setNombre(usuarioOportunidadesDetails.getNombre());
        usuarioOportunidades.setDescripcion(usuarioOportunidadesDetails.getDescripcion());
        return usuarioOportunidadesRepository.save(usuarioOportunidades);
    }

    //Eliminar
    public void eliminarUsuarioOportunidades(Long id) {
        usuarioOportunidadesRepository.deleteById(id);
    }
}
