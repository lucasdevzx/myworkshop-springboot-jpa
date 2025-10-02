package com.descompilando.projectF.resources;

import com.descompilando.projectF.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Sinaliza que a classe é um recurso web que é implementado por um rest controller
@RequestMapping(value = "/users") // Define um meio de acesso para o recurso implementado
public class UserResource {

    @GetMapping // Sinaliza que o méthodo responde uma requisição do tipo Get do https
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Lucas", "lucas@gmail.com", "22997895653", "2049");
        return ResponseEntity.ok().body(u);
    }
}