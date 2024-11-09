package com.nodoantivirus.backend.seguridad.controller;

import com.nodoantivirus.backend.seguridad.jwt.JwtTokenProvider;
import com.nodoantivirus.backend.seguridad.model.User;
import com.nodoantivirus.backend.seguridad.service.UserService;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private static final Logger logger = (Logger)

            LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider; // Assuming you have aJwtTokenProvider class
    @Autowired
    private UserService userService; // Your UserDetailsService implementation
    @PostMapping("/authenticate") // New endpoint for authentication
    public ResponseEntity<String> authenticate(@RequestBody User user) {
        logger.info(() -> "ingresando a authenticate");
        try {
// Attempt to authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(),

                            user.getPassword())
            );
// If authentication is successful, generate a JWT token
            String token = jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(token);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        } catch (Exception e) {
            logger.error(e::getMessage);

            return
                    ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Authentication failed");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.registerUser(user.getUsername(), user.getPassword());
        return ResponseEntity.ok("User registered successfully");
    }
}
