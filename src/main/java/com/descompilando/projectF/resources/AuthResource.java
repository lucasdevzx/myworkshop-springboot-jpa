package com.descompilando.projectF.resources;

import com.descompilando.projectF.entities.User;
import com.descompilando.projectF.resources.dto.LoginDTO;
import com.descompilando.projectF.resources.dto.UserDTO;
import com.descompilando.projectF.services.UserService;
import com.descompilando.projectF.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> validateLogin(@RequestBody LoginDTO dto) {
        try {
            User user = userService.login(dto.getEmail(), dto.getPassword());
            // On success, return the safe UserDTO, not the full User object with the password
            return ResponseEntity.ok(new UserDTO(user));
        } catch (ResourceNotFoundException e) {
            // On failure, return 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}
