package com.nodoantivirus.backend.seguridad.service;

import com.nodoantivirus.backend.seguridad.model.Role;
import com.nodoantivirus.backend.seguridad.model.User;
import com.nodoantivirus.backend.seguridad.repository.RoleRepository;
import com.nodoantivirus.backend.seguridad.repository.UserRepository;
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
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class UserService implements UserDetailsService {

    private static Logger logger = (Logger)

            LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            logger.info(() -> "User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user) // Ensure this method correctly returns authorities
        );
    }
    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        logger.info(user::toString);
// Implement authority retrieval logic (roles)
        return user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+ role.getName()))
                .collect(Collectors.toList());

    }
    // Optional: Method to register a new user
    public User registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder().encode(password)); // Encode password
// Define roles for the user
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER")); // Assuming you have this role saved in the database
        user.setRoles(roles);
        userRepository.save(user); // Save user to the database
        return user;
    }

}