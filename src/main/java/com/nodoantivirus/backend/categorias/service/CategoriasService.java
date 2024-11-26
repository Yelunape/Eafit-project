package com.nodoantivirus.backend.categorias.service;

import com.nodoantivirus.backend.categorias.model.Categorias;
import com.nodoantivirus.backend.categorias.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    //Crear
    public Categorias crearCategorias(Categorias categorias) {
        return categoriasRepository.save(categorias);
    }

    //obtenertodo
    public List<Categorias> obtenerCategorias() {
        return categoriasRepository.findAll();
    }

    //Obtener por id
    public Optional<Categorias> obtenerCategoriasById(Long id) {
        return categoriasRepository.findById(id);
    }

    //Actualizar
    public Categorias actualizarCategorias(Long id, Categorias categoriasDetails) {
        Categorias categorias = categoriasRepository.findById(id).orElseThrow();
        categorias.setCategorias(categoriasDetails.getCategorias());
        categorias.setCategorias(categoriasDetails.getCategorias());
        return categoriasRepository.save(categorias);
    }

    //Eliminar
    public void eliminarCategorias(Long id) {
        categoriasRepository.deleteById(id);
    }
}
