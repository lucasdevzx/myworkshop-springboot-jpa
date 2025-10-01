package com.descompilando.projectF.resources;

import com.descompilando.projectF.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Lucas", "lucas@gmail.com", "22997895653", "2049");
        return ResponseEntity.ok().body(u);
    }
}