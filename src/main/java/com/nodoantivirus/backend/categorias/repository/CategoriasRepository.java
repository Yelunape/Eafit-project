package com.nodoantivirus.backend.categorias.repository;

import com.nodoantivirus.backend.categorias.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
}
