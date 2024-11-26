package com.nodoantivirus.backend.roles.service;

import com.nodoantivirus.backend.roles.model.Roles;
import com.nodoantivirus.backend.roles.repository.RolesRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public Roles saveRole(Roles role) {
        return rolesRepository.save(role);
    }

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Optional<Roles> getRoleById(Long id) {
        return rolesRepository.findById(id);
    }

    public Roles updateRole(Long id, Roles roleDetails) {
        Roles role = rolesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        role.setRol(roleDetails.getRol());
        return rolesRepository.save(role);
    }

    public void deleteRole(Long id) {
        rolesRepository.deleteById(id);
    }

    @PostConstruct
    public void initializeRoles() {
        if (rolesRepository.findAll().isEmpty()) {
            rolesRepository.save(new Roles(null, "User"));
            rolesRepository.save(new Roles(null, "Admin"));
        }
    }
}