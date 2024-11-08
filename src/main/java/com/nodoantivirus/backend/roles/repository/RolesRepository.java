package com.nodoantivirus.backend.roles.repository;

import com.nodoantivirus.backend.roles.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
}
