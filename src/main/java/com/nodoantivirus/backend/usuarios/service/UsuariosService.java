package com.nodoantivirus.backend.usuarios.service;

import com.nodoantivirus.backend.roles.model.Roles;
import com.nodoantivirus.backend.roles.repository.RolesRepository;
import com.nodoantivirus.backend.seguridad.controller.AuthController;
import com.nodoantivirus.backend.usuarios.model.Usuarios;
import com.nodoantivirus.backend.usuarios.repository.UsuariosRepository;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuariosService implements UserDetailsService {

    private static final Logger logger = (Logger)
        LoggerFactory.getLogger(AuthController.class);


    @Autowired
    private UsuariosRepository usuariosRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private RolesRepository rolesRepository;

    @SuppressWarnings("null")
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuarios usuarios = usuariosRepository.findByCorreo(correo);
        if(usuarios == null){
            logger.info(()->"usuario no encontrado");
        }
        return new User(
            usuarios.getCorreo(),
            usuarios.getContrasena(),
                getAuthorities(usuarios)
        );
    }
    

    private Collection<? extends GrantedAuthority> getAuthorities(Usuarios usuarios) {
        return usuarios.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_"+
        role.getName())).collect(Collectors.toList());
    }

    public Usuarios createUsuario(Usuarios usuarios){
        System.out.println("contrasena"+usuarios);
        usuarios.setContrasena(passwordEncoder().encode(usuarios.getContrasena()));
        Set<Roles> roles = new HashSet<>();
        roles.add(rolesRepository.findByName("USER"));
        usuarios.setRoles(roles);
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
