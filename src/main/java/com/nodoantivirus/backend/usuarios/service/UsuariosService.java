package com.nodoantivirus.backend.usuarios.service;

import com.nodoantivirus.backend.usuarios.model.Usuarios;
import com.nodoantivirus.backend.usuarios.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    public Usuarios createUsuario(Usuarios usuarios){
        return usuariosRepository.save(usuarios);
    }

    public List<Usuarios> getAllUsuarios(){
        return usuariosRepository.findAll();
    }

    public Optional<Usuarios> getByIdUsuario(Long id){
        return usuariosRepository.findById(id);
    }

    public Usuarios updateUsuarios(Long id, Usuarios detailsUsuarios) {
        Usuarios usuarios = usuariosRepository.findById(id).orElseThrow();
        usuarios.setNombre(detailsUsuarios.getNombre());
        return usuariosRepository.save(usuarios);
    }

    public void deleteUsuario(Long id){
        usuariosRepository.deleteById(id);
    }
}
