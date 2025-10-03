package com.descompilando.projectF.services;

import com.descompilando.projectF.entities.User;
import com.descompilando.projectF.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Declara a classe para o conteiner do framework
public class UserService {

    @Autowired // Injeta a dependência do conteiner automaticamente
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }
}
