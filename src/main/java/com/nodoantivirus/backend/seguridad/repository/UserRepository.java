package com.nodoantivirus.backend.seguridad.repository;

import com.nodoantivirus.backend.seguridad.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}