package com.descompilando.projectF.resources;

import com.descompilando.projectF.entities.User;
import com.descompilando.projectF.services.UserService;
import com.descompilando.projectF.resources.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController // Sinaliza que a classe é um recurso web que é implementado por um rest controller
@RequestMapping(value = "/users") // Define um meio de acesso para o recurso implementado
public class UserResource {

    @Autowired
    UserService userService;

    @GetMapping // Sinaliza que o méthodo responde uma requisição do tipo GET do https
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}") // Sinaliza que o methodo responde uma requisição do tipo GET do https com parâmetro
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) { // Permite que o parâmetro do http se atribua ao objeto
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = userService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}