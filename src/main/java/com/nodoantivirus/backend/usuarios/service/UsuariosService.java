package com.nodoantivirus.backend.usuarios.service;

import com.nodoantivirus.backend.roles.model.Roles;
import com.nodoantivirus.backend.roles.repository.RolesRepository;
import com.nodoantivirus.backend.usuarios.model.Usuarios;
import com.nodoantivirus.backend.usuarios.repository.UsuariosRepository;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService implements UserDetailsService {

    private static Logger logger = (Logger) LoggerFactory.getLogger(UsuariosService.class);

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuarios usuarios = usuariosRepository.findByEmail(email);
        if (usuarios == null) {
            logger.info(() -> "Usuario no encontrado.");
            throw new UsernameNotFoundException("Usuario no encontrado.");
        }
        return new org.springframework.security.core.userdetails.User(usuarios.getEmail(), usuarios.getPassword(), getAuthorities(usuarios));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Usuarios usuarios) {
        logger.info(usuarios::toString);
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + usuarios.getIdRole().getRol()));
    }

    // Crear un Usuario.
    public Usuarios createUsuario(Usuarios usuarios) {
        if (usuariosRepository.findByEmail(usuarios.getEmail()) != null) {
            throw new IllegalArgumentException("El usuario con el email " + usuarios.getEmail() + " ya existe.");
        }

        usuarios.setPassword(passwordEncoder().encode(usuarios.getPassword()));
        Roles roles = rolesRepository.findById((Long) usuarios.getIdRole().getId())
                .orElseThrow(() -> new IllegalArgumentException("Rol no encontrado"));
        usuarios.setIdRole(roles);
        return usuariosRepository.save(usuarios);
    }

    //Obtener todos los usuarios.
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    //Actualizar un usuario.
    public Usuarios updateUsuarios(Long id, Usuarios usuariosDetails) {
        Usuarios usuarios = usuariosRepository.findById(id).orElseThrow();
        usuarios.setNombre(usuariosDetails.getNombre());
        usuarios.setApellido(usuariosDetails.getApellido());
        usuarios.setEmail(usuariosDetails.getEmail());
        usuarios.setPassword(usuariosDetails.getPassword());
        usuarios.setBirthday(usuariosDetails.getBirthday());

        Roles roles = rolesRepository.findById((long) usuariosDetails.getIdRole().getId()).orElseThrow();
        usuarios.setIdRole(roles);

        return usuariosRepository.save(usuarios);
    }

    //Obtener usuario por Id.
    public Optional<Usuarios> getByIdUsuario(Long id) {
        return usuariosRepository.findById(id);
    }

    //Eliminar un usuario por Id.
    public void deleteUsuario(Long id) {
        usuariosRepository.deleteById(id);
    }

    public Usuarios getByCorreo(String correo){
        return usuariosRepository.findByEmail(correo);
    }
}
