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
    public Categorias crearCateg(Categorias categorias) {
        return categoriasRepository.save(categorias);
    }

    //obtener todo
    public List<Categorias> obtenerCateg() {
        return categoriasRepository.findAll();
    }

    //Obtener por id
    public Optional<Categorias> obtenerCategById(Long id) {
        return categoriasRepository.findById(id);
    }

    //Actualizar
    public Categorias actualizarCateg(Long id, Categorias categDetails) {
        Categorias categorias = categoriasRepository.findById(id).orElseThrow();
        categorias.setCategoria(categDetails.getCategoria());
        categorias.setCategoria(categDetails.getCategoria());
        return categoriasRepository.save(categorias);
    }

    //Eliminar
    public void eliminarCateg(Long id) {
        categoriasRepository.deleteById(id);
    }
}
